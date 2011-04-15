(require 'clojure.contrib.seq-utils)

(defn fibo
  ([] (concat [0 1] (fibo 0 1)))
  ([a b] (let [n (+ a b)]
    (lazy-seq (cons n (fibo b n)))
    ))
  )

(defn num-of-digits [number]
  (count (str number)))

(defn n-digit-fibo [n]
  (first (filter #(= (num-of-digits (last %)) n) (clojure.contrib.seq-utils/indexed (fibo)))))

(prn (n-digit-fibo 1000))
