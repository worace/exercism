(ns bob)

(defn shouting?
  "Message is considered shouting if it has at least one letter and is all upper case."
  [message] (and (re-find #"[A-Z]" message)
                 (= message (clojure.string/upper-case message))))

(defn question? [message] (clojure.string/ends-with? message "?"))

(defn silence? [message] (= " " (apply str (into #{} message))))

(defn numeric? [message] (re-find #"\d+" message))

(defn response-for [message]
  (cond
    (empty? message) "Fine. Be that way!"
    (silence? message) "Fine. Be that way!"
    (shouting? message) "Whoa, chill out!"
    (question? message) "Sure."
    :else "Whatever."))
