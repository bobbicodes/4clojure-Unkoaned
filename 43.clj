; Reverse Interleave into n subseqs [m]
; Write a function which reverses the interleave process into x number of subsequences

; most common/shortest answer:

#(apply map list (partition %2 %1))

(defn deinterleave [coll n]
  (apply map list (partition n coll)))

(defn deinterleave [coll n]
  (for [i (range n)] (take-nth n (drop i coll))))
user=> (deinterleave [1 2 3 4 5 6] 2)
((1 3 5) (2 4 6))
user=> (deinterleave (range 10) 5)
((0 5) (1 6) (2 7) (3 8) (4 9))