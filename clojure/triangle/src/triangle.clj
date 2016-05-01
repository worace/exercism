(ns triangle)

(defn valid-triangle? [sides]
  (every? (fn [s] (< s (- (reduce + sides) s))) sides))

(defn type [& sides]
  (cond
    (not (valid-triangle? sides)) :illogical
    (apply = sides) :equilateral
    (= 2 (count (into #{} sides))) :isosceles
    :else :scalene))
