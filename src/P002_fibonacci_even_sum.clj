(defn fibo
  ([] (concat [0 1] (fibo 0 1)))
  ([a b] (let [n (+ a b)]
    (lazy-seq (cons n (fibo b n)))
    ))
  )

(defn fibo-till [max]
  (take-while #(< % max) (fibo)))

(defn even-fibo-sum [max]
  (reduce + (filter even? (take-while #(< % max) (fibo)))))

;(prn (even-fibo-sum 200))
(prn (even-fibo-sum 4e6))