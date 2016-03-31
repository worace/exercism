(ns leap)

(defn divis-by? [num denom] (= 0 (mod num denom)))

(defn leap-year? [year]
  (and (divis-by? year 4)
       (or (not (divis-by? year 100))
           (divis-by? year 400))))
