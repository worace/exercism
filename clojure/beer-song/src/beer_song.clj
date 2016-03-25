(ns beer-song
  (:require [clojure.string :refer [join]]))

(defn quantities [num]
  {:num num
   :bottle (if (> num 1) "bottles" "bottle")
   :it-one (if (> num 1) "one" "it")
   :remaining (if (> num 1) (dec num) "no more")
   :bottle-remaining (if (= (dec num) 1) "bottle" "bottles")})


(defn first-line [{:keys [num bottle]}]
  [num bottle "of beer on the wall," num bottle "of beer.\n"])

(defn second-line [{:keys [it-one remaining bottle-remaining]}]
  ["Take" it-one "down and pass it around,"
   remaining bottle-remaining
   "of beer on the wall.\n"])

(defn num-verse [num]
  (let [q (quantities num)
        lines [(first-line q) (second-line q)]]
    (apply str
           (map (partial join " ") lines))))

(def final-verse "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n")
(defn verse [num]
  (if (= num 0)
    final-verse
    (num-verse num)))

(defn sing
  ([start] (sing start 0))
  ([start finish]
   (if (= start finish)
     (verse start)
     (str (verse start) "\n" (sing (dec start) finish)))))
