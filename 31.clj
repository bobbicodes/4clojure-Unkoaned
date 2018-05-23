{:_id 31 :title "Pack a Sequence"
:tests ["(= (__ [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))"
"(= (__ [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))"
"(= (__ [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))"]
:description "Write a function which packs consecutive duplicates into sub-lists."
:tags ["easy" "seqs"]}

user=> (partition-by identity [1 1 2 1 1 1 3 3])
((1 1) (2) (1 1 1) (3 3))
