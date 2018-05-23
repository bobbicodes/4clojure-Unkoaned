;; 97 Pascal's Triangle

First row = 1.
Each successive row is computed by adding together
adjacent numbers in the row above,
and adding a 1 to the beginning and end of the row.
Returns nth row of Pascal's Triangle. 
	
#(loop [n 1
        l [1]]
   (if (= n %) l
       (recur (inc n)(vec (map + (cons 0 l)(conj l 0))))))
	
((fn [n] (letfn [(pt [] (iterate (fn [r] (map #(apply + %) (partition 2 1 (concat [0] r [0])))) [1]))] (->> (pt) (take n) (last)))) 1) ;;=> [1]

(map (fn [n] (letfn [(pt [] (iterate (fn [r] (map #(apply + %) (partition 2 1 (concat [0] r [0])))) [1]))] (->> (pt) (take n) (last)))) (range 1 6)) ;;=>
   [     [1]
        [1 1]
       [1 2 1]
      [1 3 3 1]
     [1 4 6 4 1]]
	
((fn [n] (letfn [(pt [] (iterate (fn [r] (map #(apply + %) (partition 2 1 (concat [0] r [0])))) [1]))] (->> (pt) (take n) (last)))) 11) ;;=>
   [1 10 45 120 210 252 210 120 45 10 1]
