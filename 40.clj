{:_id 40 :restricted ["interpose"], :title "Interpose a Seq"
:tests ["(= (__ 0 [1 2 3]) [1 0 2 0 3])"
"(= (apply str (__ \", \" [\"one\" \"two\" \"three\"])) \"one, two, three\")"
"(= (__ :z [:a :b :c :d]) [:a :z :b :z :c :z :d])"]
:description "Write a function which separates the items of a sequence by an arbitrary value."
:tags ["easy" "seqs" "core-functions"]}

user=> (source interpose)
(defn interpose
  "Returns lazy seq of
  elements of coll separated by sep.
  Returns stateful transducer when no colls provided"
  ([sep]
   (fn [rf]
     (let [started (volatile! false)]
       (fn
         ([] (rf))
         ([result] (rf result))
         ([result input]
          (if @started
            (let [sepr (rf result sep)]
              (if (reduced? sepr)
                sepr
                (rf sepr input)))
            (do
              (vreset! started true)
              (rf result input))))))))
  ([sep coll]
   (drop 1 (interleave (repeat sep) coll))))

(defn inject [x coll]
  (rest (interleave (repeat x) coll)))

user> (defn inject [x coll]
  (rest (interleave (repeat x) coll)))
#'user/inject
user> (inject 0 [1 2 3])
(1 0 2 0 3)

", " ["one" "two" "three"]
;;=> "one, two, three"
z [:a :b :c :d]
;;=>  [:a :z :b :z :c :z :d]
