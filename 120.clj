;; 120 Sum of squares

Takes coll of ints
Returns count of how many elements
are smaller than the sum
of their squared component digits.
Example:
10 is larger than 1 squared plus 0 squared
15 is smaller than 1 squared plus 5 squared
	
((fn sum-square [coll]
   (let [digits (fn [n] (map #(- (int %) 48) (str n)))
         square #(* % %)
         sum-digits (fn [n] (reduce + (map square (digits n))))]
     (count (filter #(< % (sum-digits %)) coll))))
  (range 10))
;;=> 8

((fn sum-square [coll] (let [digits (fn [n] (map #(- (int %) 48) (str n))) square #(* % %) sum-digits (fn [n] (reduce + (map square (digits n))))] (count (filter #(< % (sum-digits %)) coll)))) (range 30)) ;;=> 19
((fn sum-square [coll] (let [digits (fn [n] (map #(- (int %) 48) (str n))) square #(* % %) sum-digits (fn [n] (reduce + (map square (digits n))))] (count (filter #(< % (sum-digits %)) coll)))) (range 100))  ;;=> 50
((fn sum-square [coll] (let [digits (fn [n] (map #(- (int %) 48) (str n))) square #(* % %) sum-digits (fn [n] (reduce + (map square (digits n))))] (count (filter #(< % (sum-digits %)) coll)))) (range 1000)) ;;=> 50
