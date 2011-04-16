(use '[clojure.contrib.lazy-seqs :only [primes]])
(use 'clojure.contrib.math)
(require 'clojure.contrib.seq-utils)

(defn num-of-digits [number]
  (count (str number)))

(defn n-digit [n series]
  (first (filter #(= (num-of-digits %) n) (series))))

(defn prime? [n]
  (loop [n n d (round (Math/sqrt n))]
    (if (or (= n 1) (even? n)) false
      (if (<= d 1) true
        (if (zero? (rem n d)) false
          (recur n (dec d))
          )))))

(def prime? (memoize prime?))

;(defn include-less-than? [col, n]
;  (clojure.contrib.seq-utils/includes? (take-while #(<= % n) col) n))
;
;(defn mersenne-prime? [prime]
;  (include-less-than? primes (- (expt 2 prime) 1)))

(defn mersenne-prime? [prime]
  (prime? (- (expt 2 prime) 1)))

(defn mersenne-primes []
  (filter mersenne-prime? primes))

(defn fibo
  ([] (concat [0 1] (fibo 0 1)))
  ([a b] (let [n (+ a b)]
    (lazy-seq (cons n (fibo b n)))
    ))
  )

;(prn (n-digit 140 fibo))
(prn (n-digit 3 mersenne-primes))

