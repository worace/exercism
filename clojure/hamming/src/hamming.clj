(ns hamming)

(defn pair-distance [a b]
  (if (= a b) 0 1))

(defn distance [str1 str2]
  (if-not (= (count str1) (count str2))
    nil
    (reduce + (map pair-distance str1 str2))))
