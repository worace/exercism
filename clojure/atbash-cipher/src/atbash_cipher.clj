(ns atbash-cipher
  (:require [clojure.string :refer [lower-case join]]))

(def alphabet (map char (take 26 (iterate inc (int \a)))))

(def cipher (zipmap alphabet (reverse alphabet)))

(defn remove-punctuation [str] (clojure.string/replace str #"\W" ""))

(defn divide-chunks [msg] (->> msg
                               (partition 5 5 [])
                               (map (partial apply str))))

(defn recombine [chunks] (join " " chunks))

(defn encrypt [plaintext] (map (fn [c] (get cipher c c))
                               plaintext))

(defn encode [text]
  (-> text
      lower-case
      remove-punctuation
      encrypt
      divide-chunks
      recombine))
