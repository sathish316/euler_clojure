(defn natural-numbers [n] (take n (iterate inc 1)))

(defn reverse-number [number]
  (bigint (apply str (reverse (str number)))))

(defn palindrome? [number]
  (= number (reverse-number number)))

(defn lynchrel-number? [number]
  (loop [n number i 50]
    (if (zero? i) true
      (let [next-number (+ n (reverse-number n))]
        (if (palindrome? next-number) false
          (recur next-number (dec i)))))))

(defn lynchrel-numbers [n]
  (filter lynchrel-number? (natural-numbers n)))

(prn (count (lynchrel-numbers 10000)))