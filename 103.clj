;; 103 k-combinations [m]

Takes seq of n elements, returns all possible sets
consisting of k distinct elements taken from S.
The number of k-combinations for a seq is equal to
the binomial coefficient.

(defn k-comb [k S]
(if (zero? k)
    #{#{}}
    (set (mapcat (fn [e]
    (map (fn [t] (conj t e))
      (k-comb (dec k) (disj S e)))) S))))
#'user/k-comb
user> (k-comb 1 #{4 5 6})
#{#{6} #{5} #{4}}
user> (k-comb 10 #{4 5 6})
#{}
user> (k-comb 2 #{0 1 2})
#{#{0 1} #{1 2} #{0 2}}
user> (k-comb 3 #{0 1 2 3 4})
#{#{0 4 3} #{0 1 4} #{4 3 2} #{0 1 2} #{0 1 3} #{1 3 2} #{0 3 2} #{1 4 3} #{1 4 2} #{0 4 2}}
user> (k-comb 4 #{[1 2 3] :a "abc" "efg"})
#{#{"efg" "abc" [1 2 3] :a}}
user> (k-comb 2 #{[1 2 3] :a "abc" "efg"})
#{#{[1 2 3] :a} #{"efg" :a} #{"abc" :a} #{"abc" [1 2 3]} #{"efg" "abc"} #{"efg" [1 2 3]}}
