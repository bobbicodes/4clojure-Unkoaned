{:_id 34 :restricted ["range"], :title "Implement range"
:tests ["(= (__ 1 4) '(1 2 3))" "(= (__ -2 2) '(-2 -1 0 1))" "(= (__ 5 8) '(5 6 7))"]
:description "Write a function which creates a list of all integers in a given range."
:tags ["easy" "seqs" "core-functions"]}

user=> (source range)
(defn range
  "Returns a lazy seq of nums from start (inclusive) to end (exclusive), by step, where start defaults to 0, step to 1, and end to infinity. When step is equal to 0, returns an infinite sequence of start. When start is equal to end, returns empty list."
  ([]
   (iterate inc' 0))
  ([end]
   (if (instance? Long end)
     (clojure.lang.LongRange/create end)
     (clojure.lang.Range/create end)))
  ([start end]
   (if (and (instance? Long start) (instance? Long end))
     (clojure.lang.LongRange/create start end)
     (clojure.lang.Range/create start end)))
  ([start end step]
   (if (and (instance? Long start) (instance? Long end) (instance? Long step))
     (clojure.lang.LongRange/create start end step)
     (clojure.lang.Range/create start end step))))

(#(take (- %2 %1) (iterate inc %1)) 1 4)
;;=> (1 2 3)
