{:_id 28 :restricted ["flatten"], :title "Flatten a Sequence"
:tests ["(= (__ '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))"
"(= (__ [\"a\" [\"b\"] \"c\"]) '(\"a\" \"b\" \"c\"))"
"(= (__ '((((:a))))) '(:a))"]
:description "Write a function which flattens a sequence."
:tags ["easy" "seqs" "core-functions"]}

user=> (source flatten)
(defn flatten
  "Takes any nested combination
  of sequential things
  (lists, vectors, etc.)
  and returns their contents
  as a single, flat sequence.
  (flatten nil)
  returns an empty sequence."
  [x]
  (filter (complement sequential?)
          (rest
            (tree-seq sequential? seq x))))

(defn makeflat [s]
  (filter (complement sequential?)
    (rest (tree-seq sequential? seq s)))) 
#'user/makeflat
user=> (makeflat '((1 2) 3 [4 [5 6]]))
(1 2 3 4 5 6)

user=> (source tree-seq)
(defn tree-seq
  "Returns a lazy sequence of the nodes in a tree, via a depth-first walk. branch? must be a fn of one arg that returns true if passed a node that can have children (but may not).  children must be a fn of one arg that returns a sequence of the children. Will only be called on nodes for which branch? returns true. Root is the root node of the tree."
   [branch? children root]
   (let [walk (fn walk [node]
                (lazy-seq
                 (cons node
                  (when (branch? node)
                    (mapcat walk (children node))))))]
     (walk root)))

user=> (tree-seq sequential? seq '((1 2) 3 [4 [5 6]]))
(((1 2) 3 [4 [5 6]]) (1 2) 1 2 3 [4 [5 6]] 4 [5 6] 5 6)

user=> (rest '(((1 2) 3 [4 [5 6]]) (1 2) 1 2 3 [4 [5 6]] 4 [5 6] 5 6))
((1 2) 1 2 3 [4 [5 6]] 4 [5 6] 5 6)

user=> (filter (complement sequential?) '((1 2) 1 2 3 [4 [5 6]] 4 [5 6] 5 6))
(1 2 3 4 5 6)
