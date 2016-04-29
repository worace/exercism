(ns gigasecond
    (:import java.util.Calendar))

(defn date [year month day]
  (doto (java.util.Calendar/getInstance)
    (.set year (dec month) day 0 0)))

(defn add [date seconds]
  (doto date
    (.add java.util.Calendar/SECOND seconds)))

(defn ymd-vec [date]
  [(.get date java.util.Calendar/YEAR)
   (inc (.get date java.util.Calendar/MONTH))
   (.get date java.util.Calendar/DAY_OF_MONTH)])

(def gigasecond (Math/pow 10 9))

(defn from [year month day]
  (-> (date year month day)
      (add gigasecond)
      (ymd-vec)))
