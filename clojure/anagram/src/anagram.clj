(ns anagram
  (:require [clojure.string :refer [lower-case]]))

(defn anagrams-for
  [word possibilities]
  (filter (fn [possibility]
            (and (= (sort (lower-case possibility))
                    (sort (lower-case word)))
                 (not (= (lower-case word) (lower-case possibility)))))
          possibilities))
