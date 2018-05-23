{:_id 67 :title "Prime Numbers" :tests ["(= (__ 2) [2 3])" "(= (__ 5) [2 3 5 7 11])" "(= (last (__ 100)) 541)"]
:description "Write a function which returns the first x\nnumber of prime numbers.", :tags ["medium" "primes"]}

(= (__ 2) [2 3])
(= (__ 5) [2 3 5 7 11])
(= (last (__ 100)) 541)

#(take % ((fn sieve [s]
            (cons (first s)
              (lazy-seq (sieve (filter (fn [xx]
                                         (not= 0
                                           (mod xx
                                             (first s))))
                                 (rest s))))))
          (iterate inc 2)))

(fn [x] (take x (filter #(= (inc (mod (apply * (range 1N %)) %)) %) (iterate inc 2))))

(fn [n] 
  (->>
  (range)
  (drop 2)
  (filter (fn [x] (every? #(< 0 (mod x %)) (range 2 x))))
  (take n)))
