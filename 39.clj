{:_id 39 :restricted ["interleave"], :title "Interleave Two Seqs"
:tests ["(= (__ [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))"
"(= (__ [1 2] [3 4 5 6]) '(1 3 2 4))"
"(= (__ [1 2 3 4] [5]) [1 5])"
"(= (__ [30 20] [25 15]) [30 25 20 15])"]
:description "Write a function which takes two sequences and returns the first item from each,
then the second item from each, then the third, etc."
:tags ["easy" "seqs" "core-functions"]}

user=> (source mapcat)
(defn mapcat
  "Returns result of applying concat to
  result of applying map to f and colls.
  Thus function f should return a collection.
  Returns transducer when no colls provided"
  ([f] (comp (map f) cat))
  ([f & colls]
     (apply concat (apply map f colls))))

(mapcat list [1 2 3] [:a :b :c])
;;=> (1 :a 2 :b 3 :c)
(mapcat list [1 2] [3 4 5 6])
;;=> (1 3 2 4)
(mapcat list [1 2 3 4] [5])
;;=> (1 5)
(mapcat list [30 20] [25 15])
;;=> (30 25 20 15)
