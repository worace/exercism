(ns hexadecimal)

(def nums (->> (range 10)
               (apply str)
               (map identity)))

(def letters (->> (range 97 123)
                  (map char)))

(def nums-and-letters (concat nums letters))

(defn char-value-mapping [base]
  (zipmap nums-and-letters
          (range base)))

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

(def hex-to-int (partial -to-decimal 16))
