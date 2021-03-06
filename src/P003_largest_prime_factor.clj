(use '[clojure.contrib.lazy-seqs :only [primes]])
(use 'clojure.set)

(defn natural-numbers [n] (take n (iterate inc 1)))

(defn factors [n]
  (filter #(zero? (rem n %)) (filter odd? (natural-numbers (quot n 2)))))

(defn prime? [n]
  (if (<= n 1) false
    (if (= n 2) true
      (if (even? n) false
        (loop [n n d (int (Math/sqrt n))]
          (if (<= d 1) true
            (if (zero? (rem n d)) false
              (recur n (dec d))
              )))))))

(defn largest-prime-factor [n]
  (first (filter #(prime? %) (reverse (sort (factors n))))))

;(prn (largest-prime-factor 13195))
(prn (factors 600851475143))
;(prn (largest-prime-factor 600851475143))


