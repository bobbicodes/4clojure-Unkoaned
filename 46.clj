;; 46 Flip order of args

(fn [f] #(f %2 %))

(defn flipper [f]
  #(f %2 %))

user=> ((flipper nth) 2 [1 2 3 4 5])
3

user=> ((flipper >) 7 8)
true

user=> (((fn [f]
  (fn [& args]
    (apply f
      (reverse args)))) nth) 2 [1 2 3 4 5])
3

user=> (((fn [f]
    (fn [& args]
      (apply f (reverse args)))) nth) 2 [1 2 3 4 5])
3
