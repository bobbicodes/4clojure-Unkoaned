;; 72 Rearranging Code: ->>

{:_id 72 :title "Rearranging Code: ->>"
:tests ["
(= (__ (map inc (take 3 (drop 2 [2 5 4 1 3 6]))))\n   (->> [2 5 4 1 3 6] (drop 2) (take 3) (map inc) (__))\n   11)"]
:description "The ->> macro threads an expression x through a variable number of forms.
First, x is inserted as the last item in the first form, making a list of it if it is not a list already.
Then the first form is inserted as the last item in the second form, making a list of that form if necessary.
This process continues for all the forms.  Using ->> can sometimes make your code more readable."
:tags ["elementary"]}

user=> (source ->>)
(defmacro ->>
  "Threads the expr through the forms. Inserts x as the
  last item in the first form, making a list of it if it is not a
  list already. If there are more forms, inserts the first form as the
  last item in second form, etc."
  {:added "1.1"}
  [x & forms]
  (loop [x x, forms forms]
    (if forms
      (let [form (first forms)
            threaded (if (seq? form)
              (with-meta `(~(first form) ~@(next form)  ~x) (meta form))
              (list form x))]
        (recur threaded (next forms)))
      x)))

(reduce + (map inc (take 3 (drop 2 [2 5 4 1 3 6])))) ;;=> 11
(->> [2 5 4 1 3 6] (drop 2) (take 3) (map inc) (reduce +)) ;;=> 11
