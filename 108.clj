;; 108 Lazy Searching [m]

Takes any number of seqs,
each sorted from smallest to largest,
finds the smallest single number which appears
in all of the sequences.
Seqs may be infinite, searches lazily.

(defn lazy-search [& colls]
  (if (= 1 (count colls))
    (first (first colls)) 
    (let [heads (map first colls) largest (apply max heads)]
      (if (apply = heads)
        largest
        (recur (map (fn [c] (drop-while #(< % largest) c)) 
                 colls))))))
#'user/lazy-search
user> (lazy-search [3 4 5])
3
user> (lazy-search [1 2 3 4 5 6 7] [0.5 3/2 4 19])
4
user> (lazy-search (range) (range 0 100 7/6) [2 3 5 7 11 13])
7
user> (lazy-search (map #(* % % %) (range))   (filter #(zero? (bit-and % (dec %))) (range))
          (iterate inc 20))
64

(= 64 (__ (map #(* % % %) (range)) ;; perfect cubes
          (filter #(zero? (bit-and % (dec %))) (range)) ;; powers of 2
          (iterate inc 20))) ;; at least as large as 20

#(let [a (map first %&)
       b (apply min a)]
   (if (apply = a)
     b
     (recur (map (fn [[x & y :as z]] (if (= x b) y z)) %&))))
