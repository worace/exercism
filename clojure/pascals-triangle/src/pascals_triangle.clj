(ns pascals-triangle)

(defn next-row [prev-row]
  (mapv (fn [i] (bigint (+ (get prev-row (dec i) 0)
                           (get prev-row i 0))))
       (range (inc (count prev-row)))))

(defn -triangle
  ([] (cons [1] (-triangle (list [1]))))
  ([prev-triangle]
   (let [nr (next-row (first prev-triangle))]
     (lazy-seq
      (cons nr (-triangle (list nr)))))))

(def triangle (take 10 (-triangle)))

(defn row [n] (last (take n (-triangle))))
