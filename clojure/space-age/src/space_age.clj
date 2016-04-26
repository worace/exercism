(ns space-age)

(def seconds-per-earth-year 31557600)

(def earth-to-planets
  {:earth 1
   :mercury 0.2408467
   :venus 0.61519726
   :mars 1.8808158
   :jupiter 11.862615
   :saturn 29.447498
   :uranus 84.016846
   :neptune 164.79132})

(defn planet-age [seconds planet-name]
  (/ (/ seconds seconds-per-earth-year)
     (earth-to-planets planet-name)))

(defmacro defplanet [planet-name]
  (let [fn-name (str "on-" (name planet-name))]
    `(do (defn ~(symbol fn-name)
           [seconds#]
           (planet-age seconds# ~planet-name)))))

(defplanet :earth)
(defplanet :mercury)
(defplanet :venus)
(defplanet :mars)
(defplanet :jupiter)
(defplanet :saturn)
(defplanet :venus)
(defplanet :uranus)
(defplanet :neptune)
