;; 65 Black Box Testing [m]

{:_id 65, :title "Black Box Testing"
:description "Clojure has many collection types, which act in subtly different ways.
The core functions typically convert them into a uniform \"sequence\" type and work with them that way,
but it can be important to understand the behavioral and performance differences
so that you know which kind is appropriate for your application.<br />
<br />Write a function which takes a collection and returns one of :map, :set, :list, or :vector - 
describing the type of collection it was given.<br />
You won't be allowed to inspect their class or use the built-in predicates like list? - 
the point is to poke at them and understand their behavior.", :tags ["hard" "seqs" "testing"]
:tests [
"(= :map (__ {:a 1, :b 2}))"
"(= :list (__ (range (rand-int 20))))"
"(= :vector (__ [1 2 3 4 5 6]))"
"(= :set (__ #{10 (rand-int 5)}))"
"(= [:map :set :vector :list] (map __ [{} #{} [] ()]))"]
:restricted ["class" "type" "Class" "vector?" "sequential?" "list?" "seq?" "map?" "set?" "instance?" "getClass"]}

The seq types act in subtly different ways.
The core functions typically convert them into
a uniform "sequence" type and work with them that way,
but it can be important to understand
the behavioral and performance differences
so you know which kind is appropriate for your application.

This func takes a coll and returns one of
:map, :set, :list, or :vector -
describing the type of coll it was given.
It does not inspect their class
or use the built-in predicates like list? -
it pokes at them to understand their behavior.
Works like class, type, Class, vector?
sequential? list? seq? map? set? instance? getClass

(= :map (__ {:a 1, :b 2}))
(= :list (__ (range (rand-int 20))))
(= :vector (__ [1 2 3 4 5 6]))
(= :set (__ #{10 (rand-int 5)}))
(= [:map :set :vector :list] (map __ [{} #{} [] ()]))

#((zipmap (map str [{} #{} () []]) [:map :set :list :vector]) (str (empty %)))

#(condp = (nth (str %) 0)
   \{ :map
   \c :list
   \[ :vector
   \# :set)
   
(comp {\# :set \{ :map \[ :vector \c :list} first str)
