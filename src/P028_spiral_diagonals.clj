(use '[clojure.contrib.seq-utils :only [indexed]])

(defn natural-numbers [] (iterate inc 1))

(defn odd-numbers [] (filter odd? (natural-numbers)))

(defn spiral-counts [] (cons 1 (map #(* 4 (inc %)) (odd-numbers))))

(defn spiral-sequence [i sum]
  (lazy-seq (cons sum (spiral-sequence (inc i) (+ sum (nth (spiral-counts) i))))))

;(prn "odd" (take 5 (odd-numbers )))

;(prn "cnt" (take 5 (spiral-counts )))

;(prn "sig" (take 5 (spiral-sequence 0 0)))

(def spiral-top-right-corners (take 501 (drop 1 (spiral-sequence 0 0))))

(defn spiral-corners [[i top-right-corner]]
  (let [d (* 2 i)]
    (if (= 1 top-right-corner) [1]
    [
      top-right-corner
      (- top-right-corner d)
      (- top-right-corner (* 2 d))
      (- top-right-corner (* 3 d))
      ])))

;(prn (spiral-corners 0 1))
;(prn (spiral-corners 1 9))
;(prn (spiral-corners 2 25))

(def spiral-corners-501 (map spiral-corners (indexed spiral-top-right-corners)))

(prn spiral-corners-501 )
(prn (reduce + (flatten spiral-corners-501)))
