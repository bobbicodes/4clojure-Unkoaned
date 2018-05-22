;; 48 Intro to Some

; The some function takes a predicate function and a collection.
; It returns the first logical true value of (predicate x) where x is an item in the collection.

user=> (some #{2 7 6} [5 6 7 8])
6
user=> (some #(when (even? %) %) [5 6 7 8])
6

user=> (source some)
(defn some
  "Returns first logical true value of
  (pred x) for any x in coll, else nil.
  One way is to use a set as pred,
  for example, this will return :fred
  if :fred is in the sequence, otherwise nil:
  (some #{:fred} coll)"
  [pred coll]
    (when (seq coll)
      (or
        (pred (first coll))
        (recur pred (next coll)))))
