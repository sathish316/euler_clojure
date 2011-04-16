(use 'clojure.contrib.combinatorics)

(defn to-i [digits]
  (loop [v 0 d digits]
    (if (empty? d) v
      (recur (+ (* v 10) (first d)) (rest d)))))
;(prn (to-i '(3 1 2)))

(defn digits-upto [n]
  (set (range 0 (inc n))))

(defn pandigital-numbers [n]
  (map to-i (permutations (digits-upto n))))

(defn digits [number]
  (if (zero? number) ()
    (cons (rem number 10) (digits (quot number 10)))))

(defn vector-digits [number]
  (apply vector (reverse (digits number))))

(defn sub-number [number i j]
  (to-i (subvec (vector-digits number) i j)))

;(prn (sub-number 1406357289 1 4))

(defn divisible? [number]
  (and
    (= 10 (count (digits number)))
    (zero? (rem (sub-number number 1 4) 2))
    (zero? (rem (sub-number number 2 5) 3))
    (zero? (rem (sub-number number 3 6) 5))
    (zero? (rem (sub-number number 4 7) 7))
    (zero? (rem (sub-number number 5 8) 11))
    (zero? (rem (sub-number number 6 9) 13))
    (zero? (rem (sub-number number 7 10) 17))
    ))

;(prn (divisible? 1406357289))

(prn (count (filter divisible? (pandigital-numbers 9))))


