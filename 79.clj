
{:_id 79 :title "Triangle Minimal Path"
:tests ["(= (__ [   [1]\n          [2 4]\n         [5 1 4]\n        [2 3 4 5]])\n   (+ 1 2 1 3)\n   7)"
"(= (__ [     [3]\n            [2 4]\n           [1 9 3]\n          [9 9 2 4]\n         [4 6 6 7 8]\n        [5 7 3 5 1 4]])\n   (+ 3 4 3 2 7 1)\n   20)"]
:description "Write a function which calculates the sum of the minimal path through a triangle. 
The triangle is represented as a vector of vectors. 
The path should start at the top of the triangle and move to an adjacent number on the next row
until the bottom of the triangle is reached."
:tags ["hard"]}

(= 7 (__ '([1]
          [2 4]
         [5 1 4]
        [2 3 4 5]))) ; 1->2->1->3
(= 20 (__ '([3]
           [2 4]
          [1 9 3]
         [9 9 2 4]
        [4 6 6 7 8]
       [5 7 3 5 1 4]))) ; 3->4->3->2->7->1

(fn [s]
    (first
     (reduce
      #(map + (map min (butlast %1) (rest %1)) %2)
      (reverse s))))
