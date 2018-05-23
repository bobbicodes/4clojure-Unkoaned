118 Re-implement Map
Special Restrictions: map, map-indexed, mapcat, for

Takes a func and a seq, returns a lazy seq of (f x) for each element

(= [3 4 5 6 7]
   (__ inc [2 3 4 5 6]))
(= (repeat 10 nil)
   (__ (fn [_] nil) (range 10)))
(= [1000000 1000001]
   (->> (__ inc (range)) (drop (dec 1000000)) (take 2)))

(fn [f x] (rest (reductions #(f %2) nil x)))
