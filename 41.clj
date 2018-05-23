{:_id 41 :title "Drop Every Nth Item"
:tests ["(= (__ [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])"
"(= (__ [:a :b :c :d :e :f] 2) [:a :c :e])"
"(= (__ [1 2 3 4 5 6] 4) [1 2 3 5 6])"]
:description "Write a function which drops every Nth item from a sequence."
:tags ["easy" "seqs"]}

user> (defn drop-every-nth [s n]
  (apply concat (partition-all (dec n) n s)))
#'user/drop-every-nth
user> (drop-every-nth [1 2 3 4 5 6 7 8] 3)
(1 2 4 5 7 8)

[:a :b :c :d :e :f] 2
;;=> (:a :c :e)
[1 2 3 4 5 6] 4
;;=> (1 2 3 5 6)
