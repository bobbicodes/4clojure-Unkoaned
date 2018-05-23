;; 101 Levenshtein Distance [h]

Calculates minimum number of edits (insert/delete/replace)
needed to transform x into y.

(= (__ "kitten" "sitting") 3)
(= (__ "closure" "clojure") (__ "clojure" "closure") 1)
(= (__ "xyx" "xyyyx") 2)
(= (__ [1 2 3 4] [0 2 3 4 5]) 2)
(= (__ '(:a :b :c :d) '(:a :d)) 2)
(= (__ "ttttattttctg" "tcaaccctaccat") 10)
(= (__ "gaattctaatctc" "caaacaaaaaattt") 9)

(fn lev [[h & t :as a] [f & r :as b]]
    (cond (nil? h) (count b)
          (nil? f) (count a)
          (= f h) (recur t r)
          :else (min (inc (lev t r))
                     (inc (lev a r))
                     (inc (lev t b)))))
