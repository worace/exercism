(ns grade-school)

(defn add [db student grade]
  (update db grade (fnil conj []) student))

(defn grade [db g]
  (get db g []))

(defn sort-students [[grade students]] [grade (sort students)])

(defn sorted [db] (into (sorted-map) (map sort-students db)))
