(defn natural-numbers [n] (take n (iterate inc 1)))

(defn factors [n]
  (filter #(zero? (rem n %)) (natural-numbers (quot n 2))))

(defn triangle-sequence [i sum]
  (lazy-seq (cons sum (triangle-sequence (inc i) (+ sum i)))))

(prn (first (filter #(>= (count (factors %)) 500) (triangle-sequence 1 0))))