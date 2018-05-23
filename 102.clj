102 kebab-case to CamelCase

(= (__ "something") "something")
(= (__ "multi-word-key") "multiWordKey")
(= (__ "leaveMeAlone") "leaveMeAlone")

(fn name [s]
  (let [words (re-seq #"[a-zA-Z]+" s)
        words (cons (first words)
                    (map clojure.string/capitalize
                      (rest words)))]
    (apply str words)))

;; What's going on here?

Actually, only 1 thing:
(apply str words)

words is a binding created by let,
which takes our argument s
and calls re-seq on it.
This breaks a hyphenated string
into one word strings:

user> (re-seq #"[a-zA-Z]+"
        "make-this-camel-case")
("make" "this" "camel" "case")
