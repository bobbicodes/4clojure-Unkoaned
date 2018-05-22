;; 47 Contain Yourself
; The contains? function checks if a KEY is present in a given collection.
; This often leads beginner clojurians to use it incorrectly with numerically indexed collections like vectors and lists.

user=> (contains? #{4 5 6} 4)
true
user=> (contains? [1 1 1 1 1] 4)
true

user=> (contains? {4 :a 2 :b} 4)
true
user=> (not (contains? [1 2 4] 4))
true

user=> (source contains?)
(defn contains?
  "Returns true if key is in coll,
  false if not.
  For numerically indexed collections
  like vectors and Java arrays,
  this tests if the numeric key is
  within the range of indexes.
  'contains?' operates constant
  or logarithmic time;
  it won't do a linear search for a value.
  See also 'some'."
  [coll key]
  (. clojure.lang.RT
    (contains coll key)))
