(use 'clojure.contrib.math)

(defn natural-numbers-a-pow-b [max-a max-b]
    (for [a (range 1 max-a) b (range 1 max-b)]
      (expt a b)))

(defn sum-of-digits [number]
  (reduce + (map #(Character/digit % 10) (seq (.toCharArray (str number))))))

(prn (reduce max (map sum-of-digits (natural-numbers-a-pow-b 100 100))))

