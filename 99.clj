;; 99 Product Digits

Multiplies two numbers, returns the result as 
sequence of its digits.
	
#(map (comp read-string str) (str (* %1 %2)))
	
((fn [a b] (mapv #(Integer/parseInt (str %)) (str (* a b)))) 1 1) ;;=>[1]

((fn [a b] (mapv #(Integer/parseInt (str %)) (str (* a b)))) 99 9)
;;=>[8 9 1]

((fn [a b] (mapv #(Integer/parseInt (str %)) (str (* a b)))) 999 99)
;;=> [9 8 9 0 1]
