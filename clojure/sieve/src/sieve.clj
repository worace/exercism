(ns sieve)

(defn divis? [num denom] (= 0 (mod num denom)))

(defn sieve [n]
  (loop [i 2 primes []]
    (if (> i n)
      primes
      (recur (inc i)
             (if (some #(divis? i %) primes)
               primes
               (conj primes i))))))
