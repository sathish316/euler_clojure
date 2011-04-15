(use 'clojure.contrib.combinatorics)

(defn n-1-to-1 [n]
  (reverse (range 1 n)))

(defn products [n]
  (map #(reduce * %) (cartesian-product (n-1-to-1 n) (n-1-to-1 n)))
  )

(defn palindrome? [number]
  (= (str number) (apply str (reverse (str number))))
  )

(defn max-palindrome [n]
  (reduce max (filter palindrome? (products n)))
  )

;(println (palindrome? 1000))
;(println (palindrome? 1001))
;(println (take 10 (products 100)))
(println (max-palindrome 1000))
