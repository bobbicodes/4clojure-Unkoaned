;; 60 Sequence Reductions
{:_id 60 :restricted ["reductions"]
:tests [
"(= (take 5 (__ + (range))) [0 1 3 6 10])"
"(= (__ conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]])"
"(= (last (__ * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120)"]
:description "Write a function which behaves like reduce, but returns each intermediate value of the reduction.
Your function must accept either two or three arguments, and the return sequence must be lazy."
:tags ["medium" "seqs" "core-functions"]}

(= (take 5 (__ + (range))) [0 1 3 6 10])	
(= (__ conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]])
(= (last (__ * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120)

(fn g
  ([f [x & s]] (g f x s))
  ([f a [x & s]] 
    (lazy-seq       
        (cons a (if x (g f (f a x) s))))))
        
user=> (take 5 ((fn g
  ([f [x & s]] (g f x s))
  ([f a [x & s]] 
    (lazy-seq       
        (cons a (if x (g f (f a x) s)))))) + (range)))
(0 1 3 6 10)

user=> ((fn g
  ([f [x & s]] (g f x s))
  ([f a [x & s]] 
    (lazy-seq       
        (cons a (if x (g f (f a x) s)))))) conj [1] [2 3 4])
([1] [1 2] [1 2 3] [1 2 3 4])

user=> (last ((fn g
  ([f [x & s]] (g f x s))
  ([f a [x & s]] 
    (lazy-seq       
        (cons a (if x (g f (f a x) s)))))) * 2 [3 4 5]))
120

