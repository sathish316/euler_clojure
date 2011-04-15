(def *lower* -100)
(def *upper* 100)

(defn f [a b n] (+ (* n n) (* a n) b))

(defn prime? [n]
  (loop [n n d (int (Math/sqrt n))]
    (if (<= d 1) true
      (if (zero? (rem n d)) false
        (recur n (dec d))
        )
      )
    )
  )


(defn primecount [a b]
  (count (take-while #(prime? (f a b %)) (iterate inc 0))))

(defn primecounts []
  (for [a (range *lower* *upper*) b (range *lower* *upper*)]
    {:a a :b b :count (primecount a b)}
    )
  )

(defn maxprimecount [first other]
  (if (> (:count first) (:count other)) first other))

(defn primecount-max []
  (reduce maxprimecount (primecounts)))

(prn (primecount-max))