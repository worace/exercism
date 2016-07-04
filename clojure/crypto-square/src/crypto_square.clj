(ns crypto-square
  (:require [clojure.string :refer [lower-case join split]]))

(defn remove-punctuation [str]
  (clojure.string/replace str #"\W" ""))

(defn normalize-plaintext [text]
  (-> text lower-case remove-punctuation))

(defn square-size [text]
  (let [sqrt (Math/sqrt (count text))]
    (if (> sqrt (int sqrt))
      (inc (int sqrt))
      (int sqrt))))

(defn rows [text]
  (let [col-count (square-size text)]
    (map (partial apply str)
         (partition col-count col-count [] text))))

(defn plaintext-segments [text]
  (-> text normalize-plaintext rows))

(defn max-value [f coll] (->> coll (map f) (apply max)))

(defn pad-to [n coll] (concat coll (take (- n (count coll))
                                         (repeat nil))))

(defn compact [coll] (filter (comp not nil?) coll))

(defn transpose [rows]
  (let [padding (partial pad-to (max-value count rows))]
    (->> rows
         (map padding)
         (apply map vector)
         (map compact))))

(defn ciphertext [plaintext]
  (->> plaintext
       plaintext-segments
       transpose
       (reduce concat)
       (apply str)))

(defn normalize-ciphertext [text]
  (->> text
       plaintext-segments
       transpose
       (map (partial apply str))
       (join " ")))
