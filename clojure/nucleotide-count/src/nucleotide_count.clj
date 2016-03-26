(ns nucleotide-count)

(def base {\A 0, \T 0, \C 0, \G 0})

(defn nucleotide-counts [sequence]
  (merge base (frequencies sequence)))

(defn count [nt sequence]
  (if-let [c (get (nucleotide-counts sequence) nt)]
    c
    (throw (IllegalArgumentException. "Invalid nucleotide supplied."))))
