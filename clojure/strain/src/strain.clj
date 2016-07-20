(ns strain)

(defn retain [pred coll]
  (loop [kept []
         coll coll]
    (cond
      (empty? coll) kept
      (pred (first coll)) (recur (conj kept (first coll))
                                 (rest coll))
      :else (recur kept (rest coll)))))

(defn discard [pred coll] (retain (comp not pred) coll))
