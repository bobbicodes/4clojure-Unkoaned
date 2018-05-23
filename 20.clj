{:_id 20 :title "Penultimate Element"
:tests ["(= (__ (list 1 2 3 4 5)) 4)" "(= (__ [\"a\" \"b\" \"c\"]) \"b\")" "(= (__ [[1 2] [3 4]]) [1 2])"]
:description "Write a function which returns the second to last element from a sequence."}

(defn penultimate [s]
  (second (reverse s)))

; so we can then call it:
user=> (penultimate [1 2 3 4 5])
4

; what's this doing?

=> (reverse [1 2 3 4 5])
(5 4 3 2 1)
=> (second '(5 4 3 2 1))
4
