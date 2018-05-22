;; 53 Longest Increasing subseq [h]
; Given a vector of integers, find the longest consecutive sub-sequence of increasing numbers.
; If two sub-sequences have the same length, use the one that occurs first.
; An increasing sub-sequence must have a length of 2 or greater to qualify.

(= (__ [1 0 1 2 3 0 4 5]) [0 1 2 3])
(= (__ [5 6 1 3 2 7]) [5 6])
(= (__ [2 3 3 4 5]) [3 4 5])
(= (__ [7 6 5 4]) [])

cljs.user=> (defn longest-subseq [s]
              (or (first (filter #(apply < %)
                (mapcat #(partition % 1 s)
                  (range (count s) 1 -1))))))
#'cljs.user/longest-subseq
cljs.user=> (longest-subseq [1 0 1 2 3 0 4 5])
(0 1 2 3)
cljs.user=> (longest-subseq [5 6 1 3 2 7])
(5 6)
cljs.user=> (longest-subseq [2 3 3 4 5])
(3 4 5)
cljs.user=> (longest-subseq [7 6 5 4])
nil
