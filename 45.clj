;; 45 Iterate

user=> (source iterate)
(defn iterate
  "Returns a lazy sequence of x, (f x), (f (f x)) etc.
  f must be free of side-effects"
  [f x] (clojure.lang.Iterate/create f x) )

user=> (take 5 (iterate #(+ 3 %) 1))
(1 4 7 10 13)
