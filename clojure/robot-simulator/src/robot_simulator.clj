(ns robot-simulator)

(def dirs [:north :east :south :west])

(def velocities (zipmap dirs [{:x 0 :y 1}
                              {:x 1 :y 0}
                              {:x 0 :y -1}
                              {:x -1 :y 0}]))

(defn rotated-map [coll] (zipmap coll (drop 1 (cycle coll))))

(defn turn-right [bearing] (-> dirs rotated-map bearing))

(defn turn-left [bearing] (-> dirs reverse rotated-map bearing))

(defn advance [{bearing :bearing current-pos :coordinates :as r}]
  (let [velocity (get velocities bearing)
        new-position (merge-with + current-pos velocity)]
    (assoc r :coordinates new-position)))

(def handlers
  {\R (fn [r] (update r :bearing turn-right))
   \L (fn [r] (update r :bearing turn-left))
   \A advance})

(defn robot [coordinates bearing]
  {:coordinates coordinates :bearing bearing})

(defn process-command [robot command]
  ((handlers command) robot))

(defn simulate [commands robot]
  (reduce process-command robot commands))
