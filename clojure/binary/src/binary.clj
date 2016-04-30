(ns binary)

(defn char-value-mapping [base]
  (zipmap (apply str (range base)) (range base)))

(defn -to-decimal [base numstring]
  (let [mapping (char-value-mapping base)]
    (if-not (every? mapping numstring)
      0
      (loop [position 1
             num 0
             digits (reverse numstring)]
        (if (empty? digits)
          num
          (recur (* base position)
                 (+ num (* (mapping (first digits)) position))
                 (rest digits)))))))

(def to-decimal (partial -to-decimal 2))
