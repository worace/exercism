(ns kindergarten-garden
  (:require [clojure.string :refer [lower-case]]))

(def default-students [:alice :bob :charlie :david :eve :fred :ginny
               :harriet :ileana :joseph :kincaid :larry])

(def plantings {\V :violets \C :clover \R :radishes \G :grass})

(defn group-plantings [row-string]
  (->> (clojure.string/split row-string #"\n")
       (map (partial partition 2))
       (apply map vector)
       (map (partial apply concat))
       (map (partial apply str))))

(defn convert-planting-symbols [string] (map plantings string))

(defn format-name [student] (-> student name lower-case keyword))

(defn prep-students [students] (sort (map format-name students)))

(defn garden
  ([row-string] (garden row-string default-students))
  ([row-string students] (->> row-string
                              (group-plantings)
                              (map convert-planting-symbols)
                              (zipmap (prep-students students)))))

