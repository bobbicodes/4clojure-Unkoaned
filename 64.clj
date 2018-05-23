;; 64 Reduce

{:_id 64 :title "Intro to Reduce" :tests [
"(= 15 (reduce __ [1 2 3 4 5]))"
"(=  0 (reduce __ []))"
"(=  6 (reduce __ 1 [2 3]))"]
:description "<a href='http://clojuredocs.org/clojure_core/clojure.core/reduce'>Reduce</a>
takes a 2 argument function and an optional starting value.
It then applies the function to the first 2 items in the sequence
(or the starting value and the first element of the sequence).
In the next iteration the function will be called on the previous return value and the next item from the sequence,
thus reducing the entire collection to one value. Don't worry, it's not as complicated as it sounds."
:tags ["elementary" "seqs"]}

user=> (source reduce)
(defn reduce
  "f is func of 2 args.
  If val not supplied,
  returns result of applying f to first 2 items in coll,
  then applying f to that result and the 3rd item, etc.
  If coll contains no items, f accepts no args,
  and reduce returns the result of calling f with no args.
  If coll has 1 item, it is returned and f is not called.
  If val is supplied, returns result of applying f to val
  and the first item in coll,
  then applying f to that result and 2nd item, etc.
  If coll contains no items, returns val and f is not called."
  ([f coll]
     (if (instance? clojure.lang.IReduce coll)
       (.reduce ^clojure.lang.IReduce coll f)
       (clojure.core.protocols/coll-reduce coll f)))
  ([f val coll]
     (if (instance? clojure.lang.IReduceInit coll)
       (.reduce ^clojure.lang.IReduceInit coll f val)
       (clojure.core.protocols/coll-reduce coll f val))))

(reduce + [1 2 3 4 5]) ;;=> 15 
(reduce + []) ;;=> 0
(reduce + 1 [2 3]) ;;=> 6
