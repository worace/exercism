(ns word-count)

(defn split [message] (clojure.string/split message #" +"))

(defn remove-punctuation [message]
  (clojure.string/replace message #"[^A-Z1-9a-z ]" ""))

(defn word-count [message]
  (-> message
      (clojure.string/lower-case)
      (remove-punctuation)
      (split)
      (frequencies)))
