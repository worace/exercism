(ns prime-factors)

(defn of [num]
  (loop [num num divisors [] current-div 2]
    (cond
      (> current-div num) divisors
      (= (/ num current-div) 1) (conj divisors current-div)
      (integer? (/ num current-div)) (recur (/ num current-div)
                                            (conj divisors current-div)
                                            current-div)
      :else (recur num divisors (inc current-div)))))
