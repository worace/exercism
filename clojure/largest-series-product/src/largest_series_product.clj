(ns largest-series-product)

(defn parse-int [string] (Integer/parseInt (str string)))

(defn series-product [coll] (apply * coll))

(defn largest-product [length digits]
  (assert (>= (count digits) length))
  (assert (>= length 0))
  (if (zero? length)
    1
    (->> digits
         (map parse-int)
         (partition length 1)
         (map series-product)
         (apply max 0))))
