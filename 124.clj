Analyze Reversi
Difficulty:	Hard
Topics:	game

Reversi is normally played on an 8 by 8 board. In this problem, a 4 by 4 board is represented as a two-dimensional vector with black, white, and empty pieces represented by 'b, 'w, and 'e, respectively. Create a function that accepts a game board and color as arguments, and returns a map of legal moves for that color. Each key should be the coordinates of a legal move, and its value a set of the coordinates of the pieces flipped by that move.

Board coordinates should be as in calls to get-in. For example, [0 1] is the topmost row, second column from the left.

(= {[1 3] #{[1 2]}, [0 2] #{[1 2]}, [3 1] #{[2 1]}, [2 0] #{[2 1]}}
   (__ '[[e e e e]
         [e w b e]
         [e b w e]
         [e e e e]] 'w))

(= {[3 2] #{[2 2]}, [3 0] #{[2 1]}, [1 0] #{[1 1]}}
   (__ '[[e e e e]
         [e w b e]
         [w w w e]
         [e e e e]] 'b))

(= {[0 3] #{[1 2]}, [1 3] #{[1 2]}, [3 3] #{[2 2]}, [2 3] #{[2 2]}}
   (__ '[[e e e e]
         [e w b e]
         [w w b e]
         [e e b e]] 'w))

(= {[0 3] #{[2 1] [1 2]}, [1 3] #{[1 2]}, [2 3] #{[2 1] [2 2]}}
   (__ '[[e e w e]
         [b b w e]
         [b w w e]
         [b w w w]] 'b))
         
(fn [G b c]
  (reduce (fn [m p]
            (if-let [f (seq (mapcat
                             (fn [d]
                               (let [[f e] (split-with #(not (#{'e c} (G b %)))
                                                       (rest (take-while (fn [[y x]] (and (< -1 y 4) (< -1 x 4)))
                                                                         (iterate #(map + % d) p))))]
                                 (if (and (> (count f) 0)
                                          (= (G b (first e)) c))
                                   f)))
                             (for [y [-1 0 1] x [-1 0 1] :when (not= 0 x y)] [y x])))]
              (assoc m p (set f))
              m))
          {}
          (for [y [0 1 2 3] x [0 1 2 3] :when (= (G b [y x]) 'e)] [y x])))
get-in

(fn [b c]
  (let [m map g get-in e #{} s [-1 0 1]
        f (fn [v] (reduce clojure.set/union
                          (m #((fn [v d]
                                 (loop [r e
                                        p (m + v d)]
                                   (condp = (g b p)
                                     ({'b 'w 'w 'b} c) (recur (conj r p) (m + p d))
                                     c r
                                     e))) v %)
                             (for [y s x s] [y x]))))
        r [0 1 2 3]
        o (for [y r x r :when (and (= 'e (g b [y x])) (seq (f [y x])))] [y x])]
    (zipmap o (m f o))))
