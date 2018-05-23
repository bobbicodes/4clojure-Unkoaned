;; 93 Partial Flatten [m]

Flattens any nested combination of sequential things
(lists, vectors, etc.), but maintains the
lowest level sequential items.
The result should be a sequence of sequences
with only one level of nesting.

(= (__ [["Do"] ["Nothing"]])
   [["Do"] ["Nothing"]])
(= (__ [[[[:a :b]]] [[:c :d]] [:e :f]])
   [[:a :b] [:c :d] [:e :f]])
(= (__ '((1 2)((3 4)((((5 6)))))))
   '((1 2)(3 4)(5 6)))

(fn pf [s]
  (if (every? coll? s)
    (mapcat pf s)
    [s]))
