;; 119 Win at Tic-Tac-Toe [h]

As in Problem 73, a tic-tac-toe board
is represented by a two dimensional vector.
X is represented by :x, O is represented by :o,
and empty is represented by :e.
Takes a game piece and board as arguments,
and returns a set (possibly empty)
of all valid board placements of the game piece
which would result in an immediate win.

Board coordinates should be as in calls to get-in.
For example, [0 1] is the topmost row, center position.

(= (__ :x [[:o :e :e] 
           [:o :x :o] 
           [:x :x :e]])
   #{[2 2] [0 1] [0 2]})
(= (__ :x [[:x :o :o] 
           [:x :x :e] 
           [:e :o :e]])
   #{[2 2] [1 2] [2 0]})
(= (__ :x [[:x :e :x] 
           [:o :x :o] 
           [:e :o :e]])
   #{[2 2] [0 1] [2 0]})
(= (__ :x [[:x :x :o] 
           [:e :e :e] 
           [:e :e :e]])
   #{})
(= (__ :o [[:x :x :o] 
           [:o :e :o] 
           [:x :e :e]])
   #{[2 2] [1 1]})

(fn [x b]
  (disj (set (mapcat
    (fn [p]
      (let [s (map #(get-in b %) p)]
        (when (= {:e 1 x 2} (frequencies s))
          (map #(when (= %2 :e) %) p s))))
    (partition 3 (map
      (juxt #(int (/ % 3)) #(mod % 3))
      [0 1 2 0 3 6 0 4 8 2 4 6 3 4 5 1 4 7 6 7 8 2 5 8]))))
    nil))
