(use '[clojure.contrib.lazy-seqs :only [primes]])
(use 'clojure.set)

(defn natural-numbers [n] (take n (iterate inc 1)))

(defn factors [n]
  (filter #(zero? (rem n %)) (natural-numbers (quot n 2))))

;(defn primes-upto [n]
;  (take-while #(<= % n) primes))
;
;(defn prime-factors [n]
;  (let [all-factors (factors n)]
;    (intersection
;      (set all-factors)
;      (set (primes-upto (reduce max all-factors)))
;      )))

(defn prime? [n]
  (loop [n n d (int (Math/sqrt n))]
    (if (<= d 1) true
      (if (zero? (rem n d)) false
        (recur n (dec d))
        )
      )
    )
  )

(defn largest-prime-factor [n]
  (first (filter #(prime? %) (reverse (sort (factors n))))))

;(prn (largest-prime-factor 13195))
(prn (largest-prime-factor 600851475143))


