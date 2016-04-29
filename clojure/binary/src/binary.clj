(ns binary)

(def b2d {\0 0 \1 1})

(defn to-decimal [binary-string]
  (if-not (every? b2d binary-string)
    0
    (loop [position 1
           num 0
           digits (reverse binary-string)]
      (if (empty? digits)
        num
        (recur (* 2 position)
               (+ num (* (b2d (first digits)) position))
               (rest digits))))))
