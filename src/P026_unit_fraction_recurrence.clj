(require 'clojure.contrib.seq-utils)

(defn natural-numbers [n] (take n (iterate inc 1)))

(defn unit-fractions [n] (map #(vector % (with-precision 500 :rounding FLOOR (/ 1M %))) (natural-numbers n)))

(defn decimal [big-decimal]
  (.substring (str big-decimal) (inc (.indexOf (str big-decimal) "."))))

(defn unit-fraction-decimals [n]
  (map #(vector (first %) (decimal (second %))) (unit-fractions n)))

(defn reclen [s]
  (loop [len 1]
    (let [parts (partition len s)]
      (if (= (first parts) (second parts)) len
        (if (= len (count s))
          -1
          (recur (inc len))
          )
        )
      )
    ))


(defn unit-fraction-with-recurrence-length [n]
  (map #(vector (first %) (reclen (second %))) (unit-fraction-decimals n)))

(defn longest-recurring-fraction [n]
  (let [unit-lengths (unit-fraction-with-recurrence-length n)
        units (map first unit-lengths)
        lengths (map last unit-lengths)
        max (reduce max lengths)]
    (nth units (.indexOf lengths max))
    )
  )

(prn (reclen "123456789"))
(prn (reclen "123124"))
(prn (reclen "111111"))
(prn (reclen "123123"))
;(prn (filter #(not (= (second %) -1)) (unit-fraction-with-recurrence-length 1000)))
(prn (longest-recurring-fraction 1000))
