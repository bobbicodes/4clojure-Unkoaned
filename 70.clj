;; 70 Word Sorting [m]

{:_id 70 :title "Word Sorting"
:tests [
"(= (__  \"Have a nice day.\")\n   [\"a\" \"day\" \"Have\" \"nice\"])"
"(= (__  \"Clojure is a fun language!\")\n   [\"a\" \"Clojure\" \"fun\" \"is\" \"language\"])"
"(= (__  \"Fools fall for foolish follies.\")\n   [\"fall\" \"follies\" \"foolish\" \"Fools\" \"for\"])"]
:description "Write a function which splits a sentence up into a sorted list of words.
Capitalization should not affect sort order and punctuation should be ignored."
:tags ["medium" "sorting"]}

(= (__  "Have a nice day.")
   ["a" "day" "Have" "nice"])	
(= (__  "Clojure is a fun language!")
   ["a" "Clojure" "fun" "is" "language"])
(= (__  "Fools fall for foolish follies.")
   ["fall" "follies" "foolish" "Fools" "for"])

(fn [s] (sort-by #(.toLowerCase %) (re-seq #"\w+" s)))
