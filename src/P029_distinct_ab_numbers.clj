(use 'clojure.contrib.math)

(defn natural-numbers-a-pow-b [min-a max-a min-b max-b]
    (for [a (range min-a max-a) b (range min-b max-b)]
      (expt a b)))

(prn (count (set (natural-numbers-a-pow-b 2 101 2 101))))
