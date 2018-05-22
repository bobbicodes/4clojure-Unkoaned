;; 46 Flipping Out
; "Write a higher-order function which flips the order of the arguments of an input function."

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
