;; 62 Re-implement Iterate

{:_id 62 :restricted ["iterate"]
:title "Re-implement Iteration"
:tests [
"(= (take 5 (__ #(* 2 %) 1)) [1 2 4 8 16])"
"(= (take 100 (__ inc 0)) (take 100 (range)))"
"(= (take 9 (__ #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3])))"]
:description "Given a side-effect free function f and an initial value x
write a function which returns an infinite lazy sequence of x, (f x), (f (f x)), (f (f (f x))), etc."
:tags ["easy" "seqs" "core-functions"]}

Takes func and an initial value,
returns infinite lazy sequence of
x, (f x), (f (f x)), (f (f (f x))), etc. as in iterate
	
(fn i [f x] (cons x (lazy-seq (i f (f x)))))
	
#(reductions (fn [i _] (% i)) %2 (range))

(fn it [f x] (lazy-cat [x] (it f (f x))))
	
(take 5
  ((fn spaz-out [f init]
     (cons init (lazy-seq (spaz-out f (f init))))) #(* 2 %) 1))
;;=>  (1 2 4 8 16)

(defn spaz-out [f init]
       (cons init
         (lazy-seq
           (spaz-out f (f init)))))
user>  (take 5  (spaz-out #(* 2 %) 1))
(1 2 4 8 16)

(take 5 ((fn iterate- [f init] (cons init (lazy-seq (iterate- f (f init))))) inc 0)) ;;=> (0 1 2 3 4)
(take 5 ((fn iterate- [f init] (cons init (lazy-seq (iterate- f (f init))))) #(inc (mod % 3)) 1)) ;;=> (1 2 3 1 2)
