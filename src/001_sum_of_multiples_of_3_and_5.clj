(defn sum [n] (reduce +
  (filter
    #(or
      (= (mod % 3) 0) (= (mod % 5) 0))
    (range n)
    )
  ))

(println (sum 1000))
