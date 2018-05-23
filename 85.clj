{:_id 85 :title "Power Set" :tests [
"(= (__ #{1 :a}) #{#{1 :a} #{:a} #{} #{1}})"
"(= (__ #{}) #{#{}})"
"(= (__ #{1 2 3})\n   #{#{} #{1} #{2} #{3} #{1 2} #{1 3} #{2 3} #{1 2 3}})"
"(= (count (__ (into #{} (range 10)))) 1024)"]
:description "Write a function which generates the <a href=\"http://en.wikipedia.org/wiki/Power_set\">power set</a>
of a given set.  The power set of a set x is the set of all subsets of x, including the empty set and x itself."
:tags ["hard" "set-theory"]}

(= (__ #{1 :a}) #{#{1 :a} #{:a} #{} #{1}})
(= (__ #{}) #{#{}})
(= (__ #{1 2 3})
   #{#{} #{1} #{2} #{3} #{1 2} #{1 3} #{2 3} #{1 2 3}})
(= (count (__ (into #{} (range 10)))) 1024)

reduce (fn [e v] (into e (map #(conj % v) e))) #{#{}}

(fn powerset [s]
  (reduce #(into % (for [subset %] (conj subset %2))) #{#{}} s))
