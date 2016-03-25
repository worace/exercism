(ns anagram
  (:require [clojure.string :refer [lower-case]]))

(defn same-word? [word possibility]
  (= (lower-case word) (lower-case possibility)))

(def character-pool (comp sort lower-case))

(defn anagram? [word possibility]
  (and (= (character-pool possibility)
          (character-pool word))
       (not (same-word? word possibility))))

(defn anagrams-for
  [word possibilities]
  (filter (partial anagram? word) possibilities))
