(ns roman-numerals)

(def rn (reverse (sort {1    "I"
                        4    "IV"
                        5    "V"
                        9    "IX"
                        10   "X"
                        40   "XL"
                        50   "L"
                        90   "XC"
                        100  "C"
                        400  "CD"
                        500  "D"
                        900  "CM"
                        1000 "M"})))

(def div (comp int /))

(defn numerals [number]
  (loop [number number
         numeral ""
         rn rn]
    (if (empty? rn)
      numeral
      (let [[dec-digit roman-digit] (first rn)]
        (recur (mod number dec-digit)
               (str numeral
                    (apply str (take (div number dec-digit)
                                     (repeat roman-digit))))
               (rest rn))))))
