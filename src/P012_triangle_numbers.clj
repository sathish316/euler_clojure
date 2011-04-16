(defn natural-numbers [n] (take n (iterate inc 1)))

(defn divisors [n]
  (conj (filter #(zero? (rem n %)) (natural-numbers (quot n 2))) n))

(defn triangle-sequence [i sum]
  (lazy-seq (cons sum (triangle-sequence (inc i) (+ sum i)))))

;(prn (divisors 6))
(prn (first (filter #(>= (count (divisors %)) 250) (triangle-sequence 1 0))))
