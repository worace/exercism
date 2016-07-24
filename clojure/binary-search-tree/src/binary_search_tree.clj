(ns binary-search-tree)

(def value :value)
(def left :left)
(def right :right)

(defn singleton [value] {:value value})

(declare insert)
(defn insert-on [side value tree]
  (assoc tree side (insert value (side tree))))

(defn insert [value tree]
  (cond
    (nil? tree) (singleton value)
    (nil? (:value tree)) (assoc tree :value value)
    (> value (:value tree)) (insert-on right value tree)
    :else (insert-on left value tree)))

(defn from-list [coll]
  (reduce (fn [tree value] (insert value tree))
          nil
          coll))

(defn to-list [tree]
  (cond
    (nil? tree) []
    :else (concat (to-list (left tree))
                  [(value tree)]
                  (to-list (right tree)))))
