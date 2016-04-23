(ns meetup
  (:require [clj-time.core :as t]
            [clj-time.predicates :as pr]
            [clj-time.periodic :as p]))

(defn date-vec [date]
  [(t/year date) (t/month date) (t/day date)])

(defn day-of-week-matcher [day-of-week]
  (eval (symbol "clj-time.predicates"
                (str (name day-of-week) "?"))))

(defn nth-day [n dates]
  (nth dates n))

(defn teens? [date]
  (let [teens (into #{} (range 10 20))]
    (teens (t/day date))))

(defn occurrence-matcher [occurrence]
  (get {:first  (partial nth-day 0)
        :second (partial nth-day 1)
        :third  (partial nth-day 2)
        :fourth (partial nth-day 3)
        :last last
        :teenth (fn [dates] (last (filter teens? dates)))}
       occurrence))

(defn days-in-month
  ([] (days-in-month (t/now)))
  ([date]
   (take (t/number-of-days-in-the-month date)
         (p/periodic-seq (t/first-day-of-the-month date)
                         (t/days 1)))))

(defn meetup [month year day-of-week occurrence]
  (->> (t/local-date year month 1)
       (days-in-month)
       (filter (day-of-week-matcher day-of-week))
       ((occurrence-matcher occurrence))
       (date-vec)))
