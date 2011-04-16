(defn natural-numbers [n] (take n (iterate inc 1)))

(defn palindrome? [s]
  (= s (apply str (reverse s))))

(defn palindrome_in_base_2_and_10? [decimal]
  (and (palindrome? (str decimal)) (palindrome? (Integer/toString decimal 2))))

(prn (reduce + (filter palindrome_in_base_2_and_10? (natural-numbers 1e6))))
