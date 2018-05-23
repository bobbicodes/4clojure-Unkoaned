Intervals
Difficulty:	Medium
Topics:	

Write a function that takes a sequence of integers and returns a sequence of "intervals".
Each interval is a a vector of two integers, start and end,
such that all integers between start and end (inclusive) are contained in the input sequence.

(= (__ [1 2 3]) [[1 3]])

(= (__ [10 9 8 1 2 3]) [[1 3] [8 10]])

(= (__ [1 1 1 1 1 1 1]) [[1 1]])

(= (__ []) [])

(= (__ [19 4 17 1 3 10 2 13 13 2 16 4 2 15 13 9 6 14 2 11])
       [[1 4] [6 6] [9 11] [13 17] [19 19]])
 
(fn intervals [s]
  (reduce (fn [memo e]
            (let [memo (if (empty? memo) [[e e]] memo)
                  [l h] (nth memo (dec (count memo)))]
              (cond
               (= e h) memo
               (= e (inc h)) (assoc-in memo [(dec (count memo)) 1] e)
               :else (conj memo [e e])))) 
          [] (distinct (sort s))))
