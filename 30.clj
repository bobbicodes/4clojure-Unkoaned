{:_id 30 :title "Compress a Sequence"
:tests ["(= (apply str (__ \"Leeeeeerrroyyy\")) \"Leroy\")"
"(= (__ [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))"
"(= (__ [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))"]
:description "Write a function which removes consecutive duplicates from a sequence."
:tags ["easy" "seqs"]}

(defn compress [s]
  (map first
    (partition-by identity s)))
#'user/compress
user=> (compress [1 1 2 3 3 2 2 3])
(1 2 3 2 3)
