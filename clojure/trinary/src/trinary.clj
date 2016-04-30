(ns trinary)

(def t2d {\0 0 \1 1 \2 2})

(defn to-decimal [trinary-string]
  (if-not (every? t2d trinary-string)
    0
    (loop [position 1
           num 0
           digits (reverse trinary-string)]
      (if (empty? digits)
        num
        (recur (* 3 position)
               (+ num (* (t2d (first digits)) position))
               (rest digits))))))
