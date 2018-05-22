;; 54 Partition a Seq

:restricted "partition" "partition-all"
:title "Partition a Sequence"

(__ 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8)))
(= (__ 2 (range 8)) '((0 1) (2 3) (4 5) (6 7)))
(= (__ 3 (range 8)) '((0 1 2) (3 4 5)))

Write a function which returns a sequence of lists of x items each.
Lists of less than x items should not be returned.

user=> (__ 3 (range 9))
((0 1 2) (3 4 5) (6 7 8))

(= (__ 2 (range 8)) '((0 1) (2 3) (4 5) (6 7)))
 
(= (__ 3 (range 8)) '((0 1 2) (3 4 5)))

(fn f [n l]
  (when (>= (count l) n)
    (cons (take n l)(f n (drop n l)))))

(fn [n coll] (loop [c coll partitioned []] (if (< (count c) n) partitioned 
(recur (drop n c) (conj partitioned (take n c))))))

user=> ((fn [n coll] (loop [c coll partitioned []] (if (< (count c) n) partitioned (recur (drop n c) (conj partitioned (take n c)))))) 3 (range 9))

(defn partition-seq [n s]
  (loop [c s partitioned []] (if (< (count c) n) partitioned (recur (drop n c) (conj partitioned (take n c))))))

(loop [c s partitioned []]
  (if (< (count c) n)
    partitioned
    (recur (drop n c) (conj partitioned (take n c)))))

(loop [c s partitioned []]
  (if (< (count (range 9)) 3)
    partitioned
    (recur (drop n c) (conj partitioned (take n c)))))

=> (< (count (range 9)) 3)
false

=> (drop 3 '(0 1 2 3 4 5 6 7 8))
(3 4 5 6 7 8)

=> (take 3 '(0 1 2 3 4 5 6 7 8))
(0 1 2)

=> (conj [] '(0 1 2))
[(0 1 2)]

(recur '(3 4 5 6 7 8) ['(0 1 2)])

(loop [c '(3 4 5 6 7 8) partitioned ['(0 1 2)]]
  (if (< (count (range 9)) 3)
    partitioned
    (recur (drop n c) (conj partitioned (take n c)))))

=> (< (count '(3 4 5 6 7 8)) 3)
false

=> (drop 3 '(3 4 5 6 7 8))
(6 7 8)

=> (take 3 '(3 4 5 6 7 8))
(3 4 5)

=> (conj ['(0 1 2)] '(3 4 5))
[(0 1 2) (3 4 5)]

=> (< (count '(6 7 8)) 3)
false

=> (drop 3 '(6 7 8))
()

=> (take 3 '(6 7 8))
(6 7 8)

=> (conj ['(0 1 2) '(3 4 5)] '(6 7 8))
[(0 1 2) (3 4 5) (6 7 8)]
