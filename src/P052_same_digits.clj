(defn natural-numbers [] (iterate inc 1))

(defn digits [number]
  (if (zero? number) ()
    (cons (rem number 10) (digits (quot number 10)))))

;(prn (digits 12321))

(defn equal-digits? [number]
  (let [d (set (digits number))]
    (and
      (= d (set (digits (* 2 number))))
      (= d (set (digits (* 3 number))))
      (= d (set (digits (* 4 number))))
      (= d (set (digits (* 5 number))))
      (= d (set (digits (* 6 number))))
      )))

;(prn (equal-digits? 125874))

(prn (first (filter equal-digits? (natural-numbers))))

