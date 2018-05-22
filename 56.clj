{:_id 56 :restricted ["distinct"]
 :title "Find Distinct Items"
 :tests ["(= (__ [1 2 1 3 1 2 4]) [1 2 3 4])"
         "(= (__ [:a :a :b :b :c :c]) [:a :b :c])"
         "(= (__ '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3]))"
         "(= (__ (range 50)) (range 50))"]
 :description "Write a function which removes the duplicates from a sequence. Order of the items must be maintained."
 :tags ["medium" "seqs" "core-functions"]}

(defn deduper [coll]
  (loop [seen #{} s (seq coll) res []]
    (if (empty? s)
      res
      (let [f (first s)]
        (recur
          (conj seen f)
          (rest s)
          (if (contains? seen f)
            res
            (conj res f)))))))
#'user/deduper
user=> (deduper [1 2 1 3 1 2 4])
[1 2 3 4]

; what's going on here?

loop creates 3 bindings: seen, s, and res.
seq is called on our input coll.
if it is empty returns res, initially an empty vector.
Otherwise we continue by binding f to the first item of s, which is 1:
(let [f (first [1 2 1 3 1 2 4])]
We call recur. we conj seen, an empty set, with f, and that becomes the first new binding, then comes the rest of s and finally the result of the 2nd if, which tests if 1 is in the set. of course it is, so res is returned, the empty vector. so now:

(loop [seen #{1} s [2 1 3 1 2 4] res []]
(loop [seen #{1, 2} s [1 3 1 2 4] res []]

reduce (fn [s e] (if (some #(= % e) s) s (conj s e))) []

(fn [coll] (reduce #(if (some #{%2} %) % (conj % %2)) [] coll))	

reduce #({%2 %} ((set %) %2) (conj % %2)) []
