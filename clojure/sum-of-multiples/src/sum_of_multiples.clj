(ns sum-of-multiples)

(defn divis? [num denom] (= 0 (mod num denom)))

(defn divisor-exists? [divisors n] (some #(divis? n %) divisors))

(defn sum-of-multiples
  ([ceil] (sum-of-multiples [3 5] ceil))
  ([divisors ceil]
   (->> (range ceil)
        (filter (partial divisor-exists? divisors))
        (reduce +))))
