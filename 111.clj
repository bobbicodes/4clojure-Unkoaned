;; 111 Crossword puzzle [h]

Tests if a word will fit
 
- may use empty spaces (underscores) 
- may use but not conflict with any pre-filled characters. 
- must not use any unusable spaces (hashes). 
- no empty spaces (underscores) or extra characters
  before or after the word
  (but may be bound by unusable spaces) 
- Not case-sensitive. 
- May be placed vertically (proceeding top-down only),
  or horizontally (proceeding left-right only).

(= true  (__ "the" ["_ # _ _ e"]))
(= false (__ "the" ["c _ _ _"
                    "d _ # e"
                    "r y _ _"]))
(= true  (__ "joy" ["c _ _ _"
                    "d _ # e"
                    "r y _ _"]))
(= false (__ "joy" ["c o n j"
                    "_ _ y _"
                    "r _ _ #"]))
(= true  (__ "clojure" ["_ _ _ # j o y"
                        "_ _ o _ _ _ _"
                        "_ _ f _ # _ _"]))

(fn [t b]
  (or
    (some #(= (seq t) %)
          (for [a [(map #(remove #{\ } %) b)]
                b [a (apply map list a)]
                r b
                w (partition-by #{\#} r)]
            (map #({\_ %2} % %) w (str t 0))))
    false))
