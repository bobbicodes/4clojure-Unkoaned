;; 91 Graph Connectivity [h]

Given a graph, determines whether the graph is connected.
A connected graph is such that a path exists between
any two given nodes.

Returns true if the graph is connected and false otherwise.

We have a set of tuples representing the edges of a graph.
Each member of a tuple being a vertex/node in the graph.

-Each edge is undirected (can be traversed either direction). 
(= true (__ #{[:a :a]}))
(= true (__ #{[:a :b]}))
(= false (__ #{[1 2] [2 3] [3 1]
               [4 5] [5 6] [6 4]}))
(= true (__ #{[1 2] [2 3] [3 1]
              [4 5] [5 6] [6 4] [3 4]}))
(= false (__ #{[:a :b] [:b :c] [:c :d]
               [:x :y] [:d :a] [:b :e]}))
(= true (__ #{[:a :b] [:b :c] [:c :d]
              [:x :y] [:d :a] [:b :e] [:x :a]}))

(fn [g]
  ((fn f [e] 
     (#(if (= e %) (= % g) (f %)) 
        (reduce (fn [a b] (into a (filter #(some (set b) %) g))) 
                #{} 
                e))) 
   #{(first g)}))
