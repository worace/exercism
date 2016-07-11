(ns accumulate)

(defn accumulate [f coll]
  (loop [coll coll
         output []]
    (if (empty? coll)
      output
      (recur (rest coll)
             (conj output (f (first coll)))))))
