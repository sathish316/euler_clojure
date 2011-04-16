(use 'clojure.contrib.math)

(defn n-digit-numbers [n]
  (range (expt 10 (dec n)) (expt 10 n)))

(defn digits-upto [n]
  (set (range 1 (inc n))))

(def digits-upto (memoize digits-upto))

(defn digits [number]
  (if (zero? number) ()
    (cons (rem number 10) (digits (quot number 10)))))

(defn pandigital? [number]
  (= (set (digits number)) (digits-upto (count (str number)))))

(defn prime? [n]
  (if (<= n 1) false
    (if (= n 2) true
      (if (even? n) false
        (loop [n n d (int (Math/sqrt n))]
          (if (<= d 1) true
            (if (zero? (rem n d)) false
              (recur n (dec d))
              )))))))

(defn pandigital-prime? [number]
  (and (pandigital? number)
    (prime? number)))

(defn pandigital-primes [n]
  (filter pandigital-prime? (n-digit-numbers n)))

(prn (first (pandigital-primes 9)))


