(ns robot-name)

(def last-robot-id (atom 0))

(defn robot [] (swap! last-robot-id inc))

(defn random-char [] (char (rand-nth (range (int \A) (int \Z)))))

(defn random-num [] (rand-nth (range 0 10)))

(defn random-name []
  (apply str (concat (take 2 (repeatedly random-char))
                     (take 3 (repeatedly random-num)))))

;; generating non-repeating names
;; A -- just make a random name and check if it's already used; if so make another?
;; B -- start at name "0" (AA000 ??) and simply increment from there
;;      probably better but have to come up with good means of incrementing the whole thing
;;      with some strategy for how they "overflow" or wrap

(def robot-names (atom {}))

(defn robot-name [robot]
  (if-let [existing-name (get @robot-names robot)]
    existing-name
    (let [name (random-name)]
      (swap! robot-names assoc robot name)
      name)))

(defn reset-name [robot]
  (swap! robot-names dissoc robot))
