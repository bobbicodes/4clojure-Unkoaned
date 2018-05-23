;{:_id 21 :restricted ["nth"], :title "Nth Element"
:tests ["(= (__ '(4 5 6 7) 2) 6)" "(= (__ [:a :b :c] 0) :a)" "(= (__ [1 2 3 4] 1) 2)" "(= (__ '([1 2] [3 4] [5 6]) 2) [5 6])"]
:description "Write a function which returns the Nth element from a sequence."}

(defn nth-element [s n]
  (last (take (inc n) s)))
user=> (nth-element [1 2 3 4] 1)
2

; the function body:
(last (take (inc n) s))

; with args:

user=> (last (take (inc 1) [1 2 3 4]))
2

; grabs n digits

=> (take (inc 1) [1 2 3 4])
(1 2)

; and call last on the result:

=> (last '(1 2))
2
