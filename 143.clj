dot product
Difficulty:	Easy
Topics:	seqs math

Create a function that computes the dot product of two sequences. You may assume that the vectors will have the same length.

(= 0 (__ [0 1 0] [1 0 0]))

(= 3 (__ [1 1 1] [1 1 1]))

(= 32 (__ [1 2 3] [4 5 6]))

(= 256 (__ [2 5 6] [100 10 1]))

#(reduce + (map * %1 %2))
