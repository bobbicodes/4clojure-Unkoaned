{:_id 46 :title "Flipping out"
 :tests ["(= 3 ((__ nth) 2 [1 2 3 4 5]))"
         "(= true ((__ >) 7 8))"
         "(= 4 ((__ quot) 2 8))"
         "(= [1 2 3] ((__ take) [1 2 3 4 5] 3))"]
 :description "Write a higher-order function which flips the order of the arguments of an input function."
 :tags ["medium" "higher-order-functions"]}

(fn [f] #(f %2 %))

(defn flipper [f]
  #(f %2 %))

user=> ((flipper nth) 2 [1 2 3 4 5])
3

user=> ((flipper >) 7 8)
true

user=> ((flipper quot) 2 8)
4

user=> ((flipper take) [1 2 3 4 5] 3)
(1 2 3)

; this one will take more than 2 args

user=> (((fn [f]
  (fn [& args]
    (apply f
      (reverse args)))) nth) 2 [1 2 3 4 5])
3

user=> (((fn [f]
    (fn [& args]
      (apply f (reverse args)))) nth) 2 [1 2 3 4 5])
3

(fn flip [f]
  #(apply f (reverse %&)))
