(ns etl
  (:require [clojure.string :refer [lower-case]]))

(defn downcase-keys [[keys value]] [(map lower-case keys) value])

(defn map-entries [[keys value]] (map (fn [k] [k value]) keys))

(defn transform
  "Take map of num -> collection of strings and produce new map
   with all values from collection as keys pointing to num.
   Along the way downcase all of the strings"
  [m]
  (->> m
      (map reverse)
      (map downcase-keys)
      (mapcat map-entries)
      (into {})))
