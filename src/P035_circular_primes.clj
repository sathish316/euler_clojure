(use '[clojure.contrib.seq-utils :only [rotations]])

(defn natural-numbers [n] (take n (iterate inc 1)))

(defn prime? [n]
  (if (<= n 1) false
    (if (= n 2) true
      (if (even? n) false
        (loop [n n d (int (Math/sqrt n))]
          (if (<= d 1) true
            (if (zero? (rem n d)) false
              (recur n (dec d))
              )))))))
;(def prime? (memoize prime?))

(defn number-rotations [number]
  (map #(bigint (apply str %)) (rotations (str number))))

(defn circular-prime? [number]
  (every? prime? (number-rotations number)))

(defn circular-primes [n]
  (filter #(and (prime? %) (circular-prime? %)) (natural-numbers n)))
(def circular-primes (memoize circular-primes))

(prn (circular-primes 1000000))
(prn (count (circular-primes 1000000)))
