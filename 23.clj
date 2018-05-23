{:_id 23 :restricted ["reverse"]
:title "Reverse a Sequence"
:tests ["(= (__ [1 2 3 4 5]) [5 4 3 2 1])"
"(= (__ (sorted-set 5 7 2 7)) '(7 5 2))"
"(= (__ [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]])"]
:description "Write a function which reverses a sequence."
:tags ["easy" "seqs" "core-functions"]}

user=> (reduce conj () [1 2 3 4 5])
(5 4 3 2 1)

(defn reverse-seq [s]
  (reduce conj () s))

=> (reverse-seq [1 2 3 4 5])
(5 4 3 2 1)

=> (reduce conj () [1 2 3 4 5])
(5 4 3 2 1)

; how reduce works:

=> (conj () 1)
(1)
user=> (conj '(1) 2)
(2 1)
user=> (conj '(2 1) 3)
(3 2 1)
user=> (conj '(3 2 1) 4)
(4 3 2 1)
user=> (conj '(4 3 2 1) 5)
(5 4 3 2 1)

; this is exactly what into does:

user=> (source into)
(defn into
  "Returns a new coll consisting of
  to-coll with all of the items of
  from-coll conjoined. A transducer
  may be supplied."
  ([to from]
     (if (instance? clojure.lang.IEditableCollection to)
       (with-meta (persistent! (reduce conj! (transient to) from)) (meta to))
       (reduce conj to from)))
  ([to xform from]
     (if (instance? clojure.lang.IEditableCollection to)
       (with-meta (persistent! (transduce xform conj! (transient to) from)) (meta to))
       (transduce xform conj to from))))
