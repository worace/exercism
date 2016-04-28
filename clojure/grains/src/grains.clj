(ns grains)

(defn bigdub [n] (* (biginteger 2) n))

(defn square [n]
  (loop [n n
         q 1]
    (if (= n 1)
      q
      (recur (dec n) (bigdub q)))))

(defn total []
  (reduce + (map square (range 1 65))))
