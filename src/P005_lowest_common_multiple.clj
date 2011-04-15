(defn multiples-of-n [n]
  (iterate #(+ % n) n))

(defn divisible-by-1-to-n? [m n]
  (every? #(zero? (mod m %)) (range 1 (inc n))))


(defn lowest-common-multiple-upto [n]
  (first (filter #(divisible-by-1-to-n? % n) (multiples-of-n n)))
  )

(println (take 5 (multiples-of-n 20)))
(println (divisible-by-1-to-n? 120 5))
(println (lowest-common-multiple-upto 20))
