(def *lower* -999)
(def *upper* 1000)

(defn f [a b n] (+ (* n n) (* a n) b))

(defn prime? [n]
  (loop [n n d (int (Math/sqrt n))]
    (if (or (<= n 1) (even? n)) false
      (if (<= d 1) true
        (if (zero? (rem n d)) false
          (recur n (dec d))
          )))))


(defn primecount [a b]
  (count (take-while #(prime? (f a b %)) (iterate inc 0))))

(defn primecounts []
  (for [a (filter odd? (range *lower* *upper*)) b (filter odd? (range *lower* *upper*))]
    {:a a :b b :count (primecount a b)}
    )
  )

(defn maxprimecount [first other]
  (if (> (:count first) (:count other)) first other))

(defn primecount-max []
  (reduce maxprimecount (primecounts)))

(prn (time (primecount-max)))

;(prn (prime? -100))
;(prn (prime? -937))
;(prn (prime? 1))
;(prn (prime? 2))
;(prn (prime? 3))
;(prn (prime? 5))
;(prn (prime? 10))
;(prn (prime? 23))
;(prn (prime? 100))

