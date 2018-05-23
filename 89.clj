;; 89 Graph Tour [h]

Starting with a graph, returns true if it is possible
to make a tour of the graph in which every edge
is visited exactly once.

The graph is represented by a vector of tuples,
where each tuple represents a single edge.
The rules are:

- You can start at any node.
- You must visit each edge exactly once.
- All edges are undirected.

(= true (__ [[:a :b]]))
(= false (__ [[:a :a] [:b :b]]))
(= false (__ [[:a :b] [:a :b] [:a :c] [:c :a]
               [:a :d] [:b :d] [:c :d]]))
(= true (__ [[1 2] [2 3] [3 4] [4 1]]))
(= true (__ [[:a :b] [:a :c] [:c :b] [:a :e]
              [:b :e] [:a :d] [:b :d] [:c :e]
              [:d :e] [:c :f] [:d :f]]))
(= false (__ [[1 2] [2 3] [2 4] [2 5]]))

#(boolean (or (#{1 11} (count %)) (= 1 (last (last %)))))

(fn [e]
  (if (#{0 2} (count (filter odd? (vals (frequencies (mapcat seq e))))))
    (not (next (reduce
                (fn [g e]
                  (let [[a b] (map (fn [n] (or (some #(if (% n) %) g) #{n})) e)]
                    (conj (disj g a b) (into a b))))
                #{}
                e)))
    false))

(fn eulerian [edges]
  (let [degrees (fn [edges]
                  (apply merge-with + {} (for [[a b] edges
                                               :when (not= a b)]
                                           {a 1 b 1})))
        gdeg (degrees edges)]
    (and
     (not (empty? gdeg))
     (->> (vals gdeg) (filter odd?) count (>= 2)))))
