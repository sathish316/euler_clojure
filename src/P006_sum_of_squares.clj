(defn square [x] (* x x))

(defn one-to-n [n] (range 1 (inc n)))

(defn sigma_x2 [n]
  (reduce + (map square (one-to-n n))))

(defn sigmax_2 [n]
  (square (reduce + (one-to-n n))))

(defn sigma_delta [n]
  (- (sigmax_2 n) (sigma_x2 n)))

(println (sigma_x2 10))
(println (sigmax_2 10))
(println (sigma_delta 10))
(println (sigma_delta 100))
