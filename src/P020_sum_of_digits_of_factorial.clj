(defn fact [n]
  (loop [f 1 n n]
    (if (zero? n) f (recur (* f n) (dec n)))))

(defn sum-of-digits [number]
  (reduce + (map #(Character/digit % 10) (seq (.toCharArray (str number))))))

(println (sum-of-digits (fact 100)))