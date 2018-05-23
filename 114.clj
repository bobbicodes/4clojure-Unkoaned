;; 114 Global take-while [m]

take-while is great for filtering sequences, but it limited:
you can only examine a single item at a time.
What if you need to keep track of some state
as you go over the sequence?

Takes an integer n, a predicate p, and a sequence.
It should return a lazy sequence of items in the list up to,
but not including, the nth item that satisfies the predicate.

(= [2 3 5 7 11 13]
   (__ 4 #(= 2 (mod % 3))
         [2 3 5 7 11 13 17 19 23]))
(= ["this" "is" "a" "sentence"]
   (__ 3 #(some #{\i} %)
         ["this" "is" "a" "sentence" "i" "wrote"]))
(= ["this" "is"]
   (__ 1 #{"a"}
         ["this" "is" "a" "sentence" "i" "wrote"]))

(fn t [n p coll]
 (lazy-seq
   (let [[x & xs] coll
         n (if (p x) (dec n) n)]
     (when (> n 0)
       (cons x (t n p xs))))))
