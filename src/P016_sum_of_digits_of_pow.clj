(defn pow [x y]
  (loop [p 1 x x y y]
    (if (zero? y) p (recur (* p x) x (dec y)))
    )
  )

(defn sum-of-digits [number]
  (reduce + (map #(Character/digit % 10) (seq (.toCharArray (str number))))))

(println (sum-of-digits (pow 2 1000)))
