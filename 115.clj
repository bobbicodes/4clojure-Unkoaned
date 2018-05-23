115 Balanced Number

Returns true iff int's component digits have
same sum on left and right halves.
user> (defn bal-num [n]
       (let [digits (map #(Integer/parseInt (str %)) (str n))
             size (int (/ (count digits) 2))
             f  (take size digits)
             l  (take-last size digits)]
             (= (reduce + f) (reduce + l))))
#'user/bal-num
user> (bal-num 11)
true
user> (bal-num 121)
true
user> (bal-num 123)
false
user> (bal-num 0)
true
user> (bal-num 88099)
false
user> (bal-num 89098)
true
user> (bal-num 89089)
true
user> (take 20 (filter bal-num (range)))
(0 1 2 3 4 5 6 7 8 9 11 22 33 44 55 66 77 88 99 101)

(fn [n]
    (let [s (str n), l (count s)]
      (= (reduce + (map int (take (Math/ceil (/ l 2)) s)))
         (reduce + (map int (drop (Math/floor (/ l 2)) s))))))
