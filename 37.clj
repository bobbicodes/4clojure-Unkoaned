{:_id 37 :title "Regular Expressions" :tests ["(= __ (apply str (re-seq #\"[A-Z]+\" \"bA1B3Ce \")))"]
:description "Regex patterns are supported with a special reader macro."
:tags ["elementary" "regex" "syntax"]}

(apply str (re-seq #"[A-Z]+" "bA1B3Ce "))
;;=> "ABC"
