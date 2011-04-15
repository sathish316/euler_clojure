(use 'clojure.contrib.combinatorics)

(defn square [x] (* x x))

(defn pythagorean-triplet? [[a b c]]
  (= (+ (square a) (square b)) (square c)))

(defn perimeter [[a b c]]
  (+ a b c))

(defn natural-numbers [n] (take n (iterate inc 1)))

(defn triangles [n]
  (cartesian-product (natural-numbers n) (natural-numbers n) (natural-numbers n)))

(defn pythagorean-triplet-with-perimeter [value]
  (first (filter #(and (= (perimeter %) value) (pythagorean-triplet? %)) (triangles (/ value 2)))))

;(println (natural-numbers 100))
;(println (triangles 100))
;(println (pythagorean-triplet? [3 4 5]))
;(println (pythagorean-triplet? [3 4 6]))
;(println (pythagorean-triplets 12))
(println (pythagorean-triplet-with-perimeter 1000))