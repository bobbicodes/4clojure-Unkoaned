{:_id 42 :title "Factorial Fun"
:tests ["(= (__ 1) 1)" "(= (__ 3) 6)" "(= (__ 5) 120)" "(= (__ 8) 40320)"]
:description "Write a function which calculates factorials."
:tags ["easy" "math"]}

(defn bang-it [n]
  (reduce * (range 1 (inc n))))
#'user/bang-it
user> (bang-it 8)
40320
