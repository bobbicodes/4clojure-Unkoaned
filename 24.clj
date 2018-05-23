{:_id 24 :title "Sum It All Up"
:tests ["(= (__ [1 2 3]) 6)"
"(= (__ (list 0 -2 5 5)) 8)"
"(= (__ #{4 2 1}) 7)"
"(= (__ '(0 0 -1)) -1)"
"(= (__ '(1 10 3)) 14)"]
:description "Write a function which returns the sum of a sequence of numbers."
:tags ["easy" "seqs"]}

(#(apply + %) [1 2 3])
;;=> 6

(#(apply + %) (list 0 -2 5 5))
;;=> 8

(#(apply + %) #{4 2 1})
;;=> 7

(#(apply + %) '(0 0 -1))
;;=>-1

(#(apply + %) '(1 10 3))
;;=> 14

reduce also works exactly the same
