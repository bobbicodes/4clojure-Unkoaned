;; 81 Set Intersection

{:_id 81 :restricted ["intersection"]
:title "Set Intersection"
:tests [
"(= (__ #{0 1 2 3} #{2 3 4 5}) #{2 3})"
"(= (__ #{0 1 2} #{3 4 5}) #{})"
"(= (__ #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d})"]
:description "Write a function which returns the intersection of two sets.
The intersection is the sub-set of items that each set has in common."
:tags ["easy" "set-theory"]}

user=> (find-doc " intersection")
-------------------------
clojure.set/intersection
([s1] [s1 s2] [s1 s2 & sets])
  Return a set that is the intersection of the input sets

((fn [a b] (set (filter #(contains? b %) a)))
#{0 1 2 3} #{2 3 4 5})
;;=> #{2 3}
((fn [a b] (set (filter #(contains? b %) a)))
#{0 1 2} #{3 4 5})
;;=> #{}
((fn [a b] (set (filter #(contains? b %) a)))
#{:a :b :c :d} #{:c :e :a :f :d})
;;=> #{:a :c :d}
