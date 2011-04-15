(use '[clojure.contrib.lazy-seqs :only [primes]])

(defn sum-of-primes-upto [n]
  (reduce + (take-while #(< % n) primes))
  )

(println (sum-of-primes-upto 2e6))
