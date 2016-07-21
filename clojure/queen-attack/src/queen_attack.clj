(ns queen-attack
  (:require [clojure.string :refer [join]]))

(defn square-string [{b :b w :w} row col]
  (cond
    (= [row col] b) "B"
    (= [row col] w) "W"
    :else "_"))

(defn row-string [queens row]
  (->> (range 8)
       (map (fn [col] (square-string queens row col)))
       (join " ")))

(defn board-string [queens]
  (str (->> (range 8)
            (map (partial row-string queens))
            (join "\n"))
       "\n"))

(defn can-attack [{[row-black col-black] :b
                   [row-white col-white] :w}]
  (or (= row-black row-white)
      (= col-black col-white)
      (= (- row-black row-white)
         (- col-black col-white))))
