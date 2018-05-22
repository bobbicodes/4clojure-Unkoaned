;; 44 Rotate seq in either direction

(defn shifter [n s]
  (take (count s) (drop (mod n (count s)) (cycle s))))

user=> (shifter 2 [1 2 3 4 5])
(3 4 5 1 2)
user=> (shifter -2 [1 2 3 4 5])
(4 5 1 2 3)
