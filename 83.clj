{:_id 83 :title "A Half-Truth"
:tests [
"(= false (__ false false))"
"(= true (__ true false))
"(= false (__ true))"
"(= true (__ false true false))"
"(= false (__ true true true))"
"(= true (__ true true true false))"]

:description 
"Write a function which takes a variable number of booleans.
Your function should return true if some of the parameters are true
but not all of the parameters are true.
Otherwise your function should return false."
:tags ["easy"]}
	
(not= false false) ;;=> false
(not= true false)) ;;=> true
(not= true) ;;=> false
(not= false true false) ;;=> true
(not= true true true) ;;=> false
(not= true true true false) ;;=> true
