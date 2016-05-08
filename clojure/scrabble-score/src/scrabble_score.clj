(ns scrabble-score
  (require [clojure.string :refer [replace split upper-case]]))

(def given-point-values "A, E, I, O, U, L, N, R, S, T 1 D, G 2 B, C, M, P 3 F, H, V, W, Y 4 K 5 J, X 8 Q, Z 10" )

(as-> given-point-values i
  (replace i #", " "")
  (split i #" ")
  (partition 2 i)
  (map (fn [[_ b]] [_ (Integer/parseInt b)]) i)
  (map (fn [[a b]] (zipmap a (repeat b))) i)
  (reduce merge i)
  (def letter-values i))

(defn score-letter [letter]
  (as-> letter l
    (upper-case l)
    (first l)
    (get letter-values l 0)))

(defn score-word [word]
  (->> word
       (map score-letter)
       (reduce +)))
