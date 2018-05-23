{:_id 66 :title "Greatest Common Divisor"
:tests [
"(= (__ 2 4) 2)"
"(= (__ 10 5) 5)"
"(= (__ 5 7) 1)"
"(= (__ 1023 858) 33)"]
:description "Given two integers, write a function which\nreturns the greatest common divisor.", :tags ["easy"]}

Takes two ints, returns GCD
	
#(if (zero? %) %2 (recur (mod %2 %) %))
	
((fn gcd [a b]
   (if (zero? b)
     a
    (recur b (mod a b))))
 2 4)
;;=> 2

((fn gcd [a b] (if (zero? b) a (recur b (mod a b)))) 10 5)
;;=> 5

((fn gcd [a b] (if (zero? b) a (recur b (mod a b)))) 5 7)
;;=>  1

((fn gcd [a b] (if (zero? b) a (recur b (mod a b)))) 1023 858)
;;=> 33
