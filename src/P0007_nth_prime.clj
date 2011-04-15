(use '[clojure.contrib.lazy-seqs :only [primes]])

(defn nth-prime [n]
  (nth primes (dec n))
  )

(println (nth-prime 10001))

