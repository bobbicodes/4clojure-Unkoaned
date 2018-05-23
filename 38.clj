{:_id 38 :restricted ["max" "max-key"], :title "Maximum value"
:tests ["(= (__ 1 8 3 4) 8)" "(= (__ 30 20) 30)" "(= (__ 45 67 11) 67)"]
:description "Write a function which takes a variable number of parameters and returns the maximum value."
:tags ["easy" "core-functions"]}

(defn get-highest [& all]
  (last
    (sort all)))
1 8 3 4
;;=> 8

(#(last (sort %&)) 30 20) ;;=> 30	
(#(last (sort %&)) 45 67 11) ;;=> 67
