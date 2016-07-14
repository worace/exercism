(ns kindergarten-garden)

(def students [:alice :bob :charlie :david :eve :fred :ginny
               :harriet :ileana :joseph :kincaid :larry])

(def plantings {\V :violets \C :clover \R :radishes \G :grass})

(defn group-plantings [row-string]
  (->> (clojure.string/split row-string #"\n")
       (map (partial partition 2))
       (apply map vector)
       (map (partial apply concat))
       (map (partial apply str))))

(defn convert-planting-symbols [string] (map plantings string))

(defn garden [row-string]
  (->> row-string
       (group-plantings)
       (map convert-planting-symbols)
       (zipmap students)))

