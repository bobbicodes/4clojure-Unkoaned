{:_id 80 :title "Perfect Numbers" :tests [
"(= (__ 6) true)" "(= (__ 7) false)" "(= (__ 496) true)" "(= (__ 500) false)" "(= (__ 8128) true)"]
:description "A number is \"perfect\" if the sum of its divisors equal the number itself.
6 is a perfect number because 1+2+3=6.  Write a function which returns true for perfect numbers and false otherwise."
:tags ["medium"]}

(= (__ 6) true)
(= (__ 7) false)
(= (__ 496) true)
(= (__ 500) false)
(= (__ 8128) true)

(fn [x] (= x (apply + (filter #(= 0 (mod x %)) (range 1 x)))))
