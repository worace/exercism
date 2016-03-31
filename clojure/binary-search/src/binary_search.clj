(ns binary-search)

(defn middle [s] (int (/ (count s) 2)))

(defn binary-search
  ([val s] (binary-search val s (middle s)))
  ([val s position]
   (cond
     (empty? s) (throw (IllegalArgumentException. "not found"))
     (= val (get s position)) position
     (> val (get s position)) (+ 1
                                 position
                                 (binary-search val
                                                (vec (drop (inc position) s))
                                                (middle (drop (inc position) s))))
     (<= val (get s position)) (binary-search val
                                              (vec (take position s))
                                              (middle (take position s))))))

(defn search-for [val s]
  (if-not (= (sort s) s)
    (throw (IllegalArgumentException. "must be sorted"))
    (binary-search val (into [] s))))
