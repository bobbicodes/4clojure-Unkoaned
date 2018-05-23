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

;; 36 Let it Be	

(let [x 7 y 3 z 1] (+ x y))
;;=> 10
(let [x 7 y 3 z 1] (+ y z))
;;=> 4
(let [x 7 y 3 z 1] z)
;;=> 1
