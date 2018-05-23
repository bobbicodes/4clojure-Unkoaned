{:_id 75 :title "Euler's Totient Function"
:tests [
"(= (__ 1) 1)"
"(= (__ 10) (count '(1 3 7 9)) 4)"
"(= (__ 40) 16)"
"(= (__ 99) 60)"],
:description "Two numbers are coprime if their greatest common divisor equals 1. 
Euler's totient function f(x) is defined as the number of positive integers less than x which are coprime to x.
The special case f(1) equals 1.  Write a function which calculates Euler's totient function."
:tags ["medium"]}

(fn [a]
  (count
    (for [b (range a)
          :when (not-any? #(= 0 (rem a %) (rem b %)) (range 2 a))]
      b)))
