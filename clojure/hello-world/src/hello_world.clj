(ns hello-world)

(def defines-some "variable")

;; (def hello (fn [name] "Hello"))
(defn hello [name] "Hello")

;; sdfasdf
;; (fn [argument1 argument2] "pizza")
;; function(arg1, arg2) { return "pizza"; }
(defn hello
  ([] (hello "World"))
  ([arg] (str "Hello, " arg "!")))
