;; 106 Number Maze [h]

Finds length of shortest path between 2 points
using only 3 operations: add 2, double, halve
odd numbers cannot be halved

(= 1 (__ 1 1))  ; 1
(= 3 (__ 3 12)) ; 3 6 12
(= 3 (__ 12 3)) ; 12 6 3
(= 3 (__ 5 9))  ; 5 7 9
(= 9 (__ 9 2))  ; 9 18 20 10 12 6 8 4 2
(= 5 (__ 9 12)) ; 9 11 22 24 12

(defn find-path [s e]
  (loop [opts [s] depth 1]
    (if (some #{e} opts)
      depth
      (letfn [(solutions [n]
                (concat 
                  [(* n 2) (+ n 2)]
                  (if (even? n) [(/ n 2)] [])))]
        (recur (mapcat solutions opts) (inc depth))))))
#'user/find-path
user> (find-path 1 1)
1
user> (find-path 3 12)
3
user> (find-path 12 3)
3
user> (find-path 5 9)
3
user> (find-path 9 2)
9
user> (find-path 9 12)
5
