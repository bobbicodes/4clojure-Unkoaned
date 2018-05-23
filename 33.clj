{:_id 33 :title "Replicate a Sequence"
:tests ["(= (__ [1 2 3] 2) '(1 1 2 2 3 3))"
"(= (__ [:a :b] 4) '(:a :a :a :a :b :b :b :b))"
"(= (__ [4 5 6] 1) '(4 5 6))" "(= (__ [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))"
"(= (__ [44 33] 2) [44 44 33 33])"]
:description "Write a function which replicates each element of a sequence a variable number of times."
:tags ["easy" "seqs"]}

(defn splatter [s n]
  (mapcat
    (fn [s]
      (repeat n s))s))
#'user/splatter
user=> (splatter [1 2 3] 2)
(1 1 2 2 3 3)

user=> (repeat 2 [1 2 3])
([1 2 3] [1 2 3])

(mapcat (fn [s]
  (repeat 2 s)) [1 2 3])
(1 1 2 2 3 3)
