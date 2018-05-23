{:_id 35 :title "Local bindings"
:tests ["(= __ (let [x 5] (+ 2 x)))" "(= __ (let [x 3, y 10] (- y x)))" "(= __ (let [x 21] (let [y 3] (/ x y))))"]
:description "Clojure lets you give local names to values using the special let-form."
:tags ["elementary" "syntax"]}

(let [x 5] (+ 2 x))
;;=> 7
(let [x 3, y 10] (- y x))
;;=> 7
(let [x 21] (let [y 3] (/ x y)))
;;=> 7
