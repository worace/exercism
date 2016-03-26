(ns phone-number
  (:require [clojure.string :refer [replace]]))

(defn number [pn]
  (let [sani (replace pn #"[^0-9]" "")]
    (cond
      (= 10 (count sani)) sani
      (and (= 11 (count sani)) (= \1 (first sani))) (apply str (drop 1 sani))
      :else (apply str (take 10 (repeat "0"))))))

(defn area-code [pn]
  (apply str (take 3 (number pn))))

(defn pretty-print [pn]
  (let [num (number pn)]
    (apply str (concat ["("]
                 (take 3 num)
                 [") "]
                 (take 3 (drop 3 num))
                 ["-"]
                 (take 4 (drop 6 num))))))
