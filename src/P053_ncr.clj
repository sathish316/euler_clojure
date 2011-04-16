(defn fact [number]
  (loop [f 1 n number]
    (if (= n 1) f
      (recur (* f n) (dec n)))))
;(def fact (memoize fact))

(defn ncr [[n r]]
  (/ (fact n) (* (fact r) (fact (- n r)))))

;(prn (fact 5))
;(prn (ncr [5 2]))
;(prn (ncr [23 10]))
;(prn (time (ncr 23 10)))

(defn combis [max-n]
  (for [n (range 23 max-n) r (range 10 (inc n))]
    [n r]
    ))

;(prn (combis 6))
(def c (filter #(> (ncr %) 1e6) (combis 100)))
(prn c)
(prn (count c))
;(prn (first (filter #(> (ncr %) 100) [[23 11]])))
