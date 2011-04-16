(use 'clojure.contrib.math)

(defn n-digit-numbers [n]
  (range (expt 10 (dec n)) (expt 10 n)))

(defn digits-upto [n]
  (set (range 1 (inc n))))

(def digits-upto (memoize digits-upto))

(defn digits [number]
  (set (map #(Character/digit % 10) (seq (.toCharArray (str number))))))

(defn pandigital? [number]
  (= (digits number) (digits-upto (count (str number)))))

(defn prime? [n]
  (loop [n n d (int (Math/sqrt n))]
    (if (or (<= n 1) (even? n)) false
      (if (<= d 1) true
        (if (zero? (rem n d)) false
          (recur n (dec d))
          )))))

(defn pandigital-prime? [number]
  (and (pandigital? number)
    (prime? number)))

(defn pandigital-primes [n]
  (filter pandigital-prime? (n-digit-numbers n)))

(prn (first (pandigital-primes 6)))


