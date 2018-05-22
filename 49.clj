;; 49 Split seq in 2
; Write a function which will split a sequence into two parts

(= (__ 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]])
(= (__ 1 [:a :b :c :d]) [[:a] [:b :c :d]])
(= (__ 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]])


(fn [n coll] [(take n coll) (drop n coll)])

(juxt take drop)

user=> (source split-at)
(defn split-at
  "Returns vector of [(take n coll) (drop n coll)]"
  [n coll]
    [(take n coll) (drop n coll)])
