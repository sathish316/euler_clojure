(defn natural-numbers [n] (take n (iterate inc 1)))

(defn f [n]
  (if (odd? n) (inc (* 3 n)) (/ n 2)))

(defn collatz-seq [n]
  (lazy-seq (cons n (collatz-seq (f n)))))

(defn collatz-chain [n]
  (conj (vec (take-while #(not (= % 1)) (collatz-seq n))) 1))

(prn (collatz-chain 13))

(defn collatz-chains [n]
  (map #(list % (collatz-chain %)) (natural-numbers n)))

(defn collatz-chain-lengths [n]
  (map #(list (first %) (count (last %))) (collatz-chains n)))

(defn max-length [chain1 chain2]
  (if (> (last chain1) (last chain2)) chain1 chain2))

(prn (reduce max-length (collatz-chain-lengths 1000000)))