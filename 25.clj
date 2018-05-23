{:_id 25 :title "Find the odd numbers"
:tests ["(= (__ #{1 2 3 4 5}) '(1 3 5))"
"(= (__ [4 2 1 6]) '(1))"
"(= (__ [2 2 4 6]) '())"
"(= (__ [1 1 1 3]) '(1 1 1 3))"]
:description "Write a function which returns only the odd numbers from a sequence."
:tags ["easy" "seqs"]}
(filter odd?
  #{1 2 3 4 5})
;;=> (1 3 5)

(filter odd? [4 2 1 6]) ;;=> (1)
(filter odd? [2 2 4 6]) ;;=> ()
(filter odd? [1 1 1 3]) ;;=> (1 1 1 3)
