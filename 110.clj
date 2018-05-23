;; 110 Sequence of pronunciations [m]

Returns infinite lazy seq consisting of
the num of repeated nums and the num itself.
[1 1] is pronounced as [2 1] ("two ones"),
which in turn is [1 2 1 1] ("one two, one one").

(defn seq-prons [s]
  (next (iterate #(mapcat (juxt count first)
                    (partition-by identity %)) s)))
#'user/seq-prons
user>  (take 3 (seq-prons [1]))
((1 1) (2 1) (1 2 1 1))
user> (first (seq-prons [1 1 1 4 4]))
(3 1 2 4)
user> (nth (seq-prons [1]) 6)
(1 1 1 3 2 1 3 2 1 1)
user> (count (nth (seq-prons [3 2]) 15))
338

(fn [col]
  (->> col (iterate #(->> (partition-by identity %)
                      (mapcat (fn [a]
                                  [(count a) (first a)]))))
           (drop 1)))

(fn [x] (rest (iterate #(mapcat (juxt count first) (partition-by identity %)) x)))
