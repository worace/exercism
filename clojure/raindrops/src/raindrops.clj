(ns raindrops)

(defn prime-factors [num]
  (loop [num num divisors [] current-div 2]
    (cond
      (> current-div num) divisors
      (= (/ num current-div) 1) (conj divisors current-div)
      (integer? (/ num current-div)) (recur (/ num current-div)
                                            (conj divisors current-div)
                                            current-div)
      :else (recur num divisors (inc current-div)))))

(def sounds {3 "Pling" 5 "Plang" 7 "Plong"})

(defn or-n [n string] (if (empty? string) (str n) string))

(defn convert [n]
  (->> n
       prime-factors
       set
       sort
       (map sounds)
       (apply str)
       (or-n n)))
