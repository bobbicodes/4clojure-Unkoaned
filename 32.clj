{:_id 32 :title "Duplicate a Sequence"
:tests ["(= (__ [1 2 3]) '(1 1 2 2 3 3))"
"(= (__ [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))"
"(= (__ [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))"
"(= (__ [44 33]) [44 44 33 33])"]
:description "Write a function which duplicates each element of a sequence.",
:tags ["easy" "seqs"]}

user=> (#(interleave % %) [1 2 3])
(1 1 2 2 3 3)
