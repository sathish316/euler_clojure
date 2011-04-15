(use 'clojure.set)

(defn natural-numbers [n] (take n (iterate inc 1)))

(defn divisors [n]
  (filter #(zero? (rem n %)) (natural-numbers (int (/ n 2)))))

(defn sum-of-divisors [n]
  (reduce + (divisors n)))

(defn numbers-and-sum-of-divisors [n]
  (map #(list % (sum-of-divisors %)) (natural-numbers n)))

(defn sum-of-divisors-and-numbers [n]
  (map #(list (sum-of-divisors %) %) (natural-numbers n)))

(defn amicable-pairs [n]
  (filter
    #(not (= (first %) (second %)))
    (intersection (set (numbers-and-sum-of-divisors n)) (set (sum-of-divisors-and-numbers n)))))

(defn amicable-numbers [n]
  (set (flatten (apply list (amicable-pairs n)))))

(prn (reduce + (amicable-numbers 10000)))


