{:_id 27 :title "Palindrome Detector"
:tests ["(false? (__ '(1 2 3 4 5)))"
"(true? (__ \"racecar\"))"
"(true? (__ [:foo :bar :foo]))"
"(true? (__ '(1 1 3 3 1 1)))" "(false? (__ '(:a :b :c)))"]
:description "Write a function which returns true if the given sequence is a palindrome.<br/><br>
Hint: \"racecar\" does not equal '(\\r \\a \\c \\e \\c \\a \\r)"
:tags ["easy" "seqs"]}
(defn mypal [s]
  (= (seq s) (reverse (seq s))))
#'user/mypal
user=> (mypal [1 2 3 4 5])
false
user=> (mypal [1 2 3 2 1])
true
