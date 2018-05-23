;; 94 Game of Life [h]

The game of life is a cellular automaton
devised by mathematician John Conway. 

The 'board' consists of both live (#) and dead ( ) cells.
Each cell interacts with its eight neighbours
(horizontal, vertical, diagonal),
and its next state is dependent on the following rules:

1) Any live cell with fewer than two live neighbours dies,
as if caused by under-population.
2) Any live cell with two or three live neighbours
lives on to the next generation.
3) Any live cell with more than three live neighbours dies,
as if by overcrowding.
4) Any dead cell with exactly three live neighbours
becomes a live cell, as if by reproduction.

Given a board, returns a board representing
the next generation of cells.

(= (__ ["      "  
        " ##   "
        " ##   "
        "   ## "
        "   ## "
        "      "])
   ["      "  
    " ##   "
    " #    "
    "    # "
    "   ## "
    "      "])
(= (__ ["     "
        "     "
        " ### "
        "     "
        "     "])
   ["     "
    "  #  "
    "  #  "
    "  #  "
    "     "])
(= (__ ["      "
        "      "
        "  ### "
        " ###  "
        "      "
        "      "])
   ["      "
    "   #  "
    " #  # "
    " #  # "
    "  #   "
    "      "])


(fn [d]
    (for [i (range (count d))]
      (apply
       str
       (for [j (range (count (d i)))]
         (let [z (= \# (get-in d [i j]))
               v [-1 0 1]
               u (count (filter #(= \# (get-in d %)) (for [a v, b v] [(+ i a) (+ j b)])))]
           (if (or (== 3 u) (and z (== 4 u))) \# " "))))))
