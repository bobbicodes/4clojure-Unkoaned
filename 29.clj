{:_id 29 :title "Get the Caps"
:tests ["(= (__ \"HeLlO, WoRlD!\") \"HLOWRD\")"
"(empty? (__ \"nothing\"))" "(= (__ \"$#A(*&987Zf\") \"AZ\")"]
:description "Write a function which takes a string and returns a new string containing only the capital letters."
:tags ["easy" "strings"]}

(#(apply str (re-seq #"[A-Z]" %)) "HeLlO, WoRlD!")
