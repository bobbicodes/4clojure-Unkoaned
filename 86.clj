{:_id 86 :title "Happy numbers"
:tests [
"(= (__ 7) true)"
"(= (__ 986543210) true)"
"(= (__ 2) false)"
"(= (__ 3) false)"]

:description "Happy numbers are positive integers that follow a particular formula:
take each individual digit, square it, and then sum the squares to get a new number.
Repeat with the new number and eventually, you might get to a number whose squared sum is 1.
This is a happy number. An unhappy number (or sad number) is one that loops endlessly.
Write a function that determines if a number is happy or not."
:tags ["easy" "math"]}

(fn [x]
  (let [y (->> x str (map (comp #(* % %) read-string str)) (apply +))]
    (cond
      (= y 1) true
      (= y 42) false
      :else (recur y))))
