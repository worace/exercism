(ns allergies)

(def allergens
  [:eggs :peanuts :shellfish :strawberries
   :tomatoes :chocolate :pollen :cats])

(defn left-shift [n] (bit-shift-left n 1))

(def allergen-masks (zipmap allergens
                            (iterate left-shift 1)))

(defn allergic-to? [score allergen]
  (-> allergen allergen-masks (bit-and score) pos?))

(defn allergies [score]
  (filter (partial allergic-to? score)
          allergens))
