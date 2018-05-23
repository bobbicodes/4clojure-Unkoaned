73 Analyze a Tic-Tac-Toe board

{:_id 73
:title "Analyze a Tic-Tac-Toe Board"
:tests [
"(= nil (__ [[:e :e :e]\n             [:e :e :e]\n            [:e :e :e]]))"
"(= :x (__ [[:x :e :o]\n           [:x :e :e]\n           [:x :e :o]]))"
"(= :o (__ [[:e :x :e]\n           [:o :o :o]\n           [:x :e :x]]))"
"(= nil (__ [[:x :e :o]\n            [:x :x :e]\n            [:o :x :o]]))"
"(= :x (__ [[:x :e :e]\n           [:o :x :e]\n           [:o :e :x]]))"
"(= :o (__ [[:x :e :o]\n           [:x :o :e]\n           [:o :e :x]]))"
"(= nil (__ [[:x :o :x]\n            [:x :o :x]\n            [:o :x :o]]))"]
:description "A <a href=\"http://en.wikipedia.org/wiki/Tic-tac-toe\">tic-tac-toe</a>
board is represented by a two dimensional vector.
X is represented by :x, O is represented by :o, and empty is represented by :e.
A player wins by placing three Xs or three Os in a horizontal, vertical, or diagonal row.
Write a function which analyzes a tic-tac-toe board and returns :x if X has won,
:o if O has won, and nil if neither player has won.", :tags ["medium" "game"]}


[[:e :e :e]
 [:e :e :e]
 [:e :e :e]]

return nil

[[:x :e :o]
 [:x :e :e]
 [:x :e :o]]

return :x

[[:e :x :e]
 [:o :o :o]
 [:x :e :x]]
 
return :o

#(some {[:x :x :x] :x [:o :o :o] :o}
       (concat % (apply map list %) 
               (for [d [[[0 0] [1 1] [2 2]] [[2 0] [1 1] [0 2]]]]
                 (for [[x y] d] ((% x) y)))))
