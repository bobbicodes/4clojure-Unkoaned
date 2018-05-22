;; 61 Map Construction

{:_id 61 :restricted ["zipmap"], :title "Map Construction"
:tests [
"(= (__ [:a :b :c] [1 2 3]) {:a 1, :b 2, :c 3})"
"(= (__ [1 2 3 4] [\"one\" \"two\" \"three\"]) {1 \"one\", 2 \"two\", 3 \"three\"})"
"(= (__ [:foo :bar] [\"foo\" \"bar\" \"baz\"]) {:foo \"foo\", :bar \"bar\"})"]
:description "Write a function which takes a vector of keys and a vector of values and constructs a map from them."
:tags ["easy" "core-functions"]}

Takes vec of keys, vec of vals
constructs map from them like zipmap
	
(defn make-map [keys vals]
  (apply hash-map (interleave keys vals)))
#'user/make-map
user> (make-map [:a :b :c] [1 2 3])
{:c 3, :b 2, :a 1}

[1 2 3 4] ["one" "two" "three"]
;;=> {1 "one", 2 "two", 3 "three"}

[:foo :bar] ["foo" "bar" "baz"]
;;=> {:foo "foo", :bar "bar"}
