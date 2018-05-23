;; 112 Sequs Horribilis [m]

Takes an int and a nested coll of ints
Returns a seq which maintains the nested structure,
and which includes all elements starting from the head
whose sum is less than or equal to the input integer.

(=  (__ 10 [1 2 [3 [4 5] 6] 7])
   '(1 2 (3 (4))))
(=  (__ 30 [1 2 [3 [4 [5 [6 [7 8]] 9]] 10] 11])
   '(1 2 (3 (4 (5 (6 (7)))))))
(=  (__ 9 (range))
   '(0 1 2 3))
(=  (__ 1 [[[[[1]]]]])
   '(((((1))))))
(=  (__ 0 [1 2 [3 [4 5] 6] 7])
   '())
(=  (__ 0 [0 0 [0 [0]]])
   '(0 0 (0 (0))))
(=  (__ 1 [-10 [1 [2 3 [4 5 [6 7 [8]]]]]])
   '(-10 (1 (2 3 (4)))))

(fn d [n [h & t]]
   (cond
    (nil? h) []
    (coll? h)  [(d n h)]
    (>= n h) (concat [h] (d (- n h) t))
    :else []))
