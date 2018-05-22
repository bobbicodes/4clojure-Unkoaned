{:_id 58
:restricted ["comp"]
:title "Function Composition"
:tests ["(= [3 2 1] ((__ rest reverse) [1 2 3 4]))"
        "(= 5 ((__ (partial + 3) second) [1 2 3 4]))"
        "(= true ((__ zero? #(mod % 8) +) 3 5 7 9))"
        "(= \"HELLO\" ((__ #(.toUpperCase %) #(apply str %) take) 5 \"hello world\"))"]
:description "Write a function which allows you to create function compositions.
The parameter list should take a variable number of functions, and create a function applies them from right-to-left."
:tags ["medium" "higher-order-functions" "core-functions"]}

(= [3 2 1] ((__ rest reverse) [1 2 3 4]))	
(= 5 ((__ (partial + 3) second) [1 2 3 4]))
(= true ((__ zero? #(mod % 8) +) 3 5 7 9))
(= "HELLO"
   ((__ #(.toUpperCase %) #(apply str %) take)
    5 "hello world"))

(fn [& fs] (reduce #(fn [& x] (% (apply %2 x))) fs))
