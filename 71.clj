;; 71 Rearranging Code: ->

{:_id 71 :title "Rearranging Code: ->"
:tests ["(= (__ (sort (rest (reverse [2 5 4 1 3 6]))))\n   (-> [2 5 4 1 3 6] reverse rest sort __)\n   5)"]
:description "The -> macro threads an expression x through a variable number of forms.
First, x is inserted as the second item in the first form, making a list of it if it is not a list already.
Then the first form is inserted as the second item in the second form, making a list of that form if necessary.
This process continues for all the forms.  Using -> can sometimes make your code more readable."
:tags ["elementary"]}

user=> (source ->)
(defmacro ->
  "Threads the expr through the forms. Inserts x as the
  second item in the first form, making a list of it if it is not a
  list already. If there are more forms, inserts the first form as the
  second item in second form, etc."
  {:added "1.0"}
  [x & forms]
  (loop [x x, forms forms]
    (if forms
      (let [form (first forms)
            threaded (if (seq? form)
                       (with-meta `(~(first form) ~x ~@(next form)) (meta form))
                       (list form x))]
        (recur threaded (next forms)))
      x)))

(last (sort (rest (reverse [2 5 4 1 3 6])))) ;;=> 5
(-> [2 5 4 1 3 6] (reverse) (rest) (sort) (last)) ;;=> 5
