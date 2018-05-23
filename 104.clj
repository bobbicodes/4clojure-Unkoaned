;; 104 (Inverse of 92)

Takes integer < 4000, returns roman numeral
(following subtractive principle)

(defn roman [x] (cond
  (<= 1000 x) (str "M" (roman (- x 1000)))
  (<= 900 x) (str "CM" (roman (- x 900)))
  (<= 500 x) (str "D" (roman (- x 500)))
  (<= 400 x) (str "CD" (roman (- x 400)))
  (<= 100 x) (str "C" (roman (- x 100)))
  (<= 90 x) (str "XC" (roman (- x 90)))
  (<= 50 x) (str "L" (roman (- x 50)))
  (<= 40 x) (str "XL" (roman (- x 40)))
  (<= 10 x) (str "X" (roman (- x 10)))
  (<= 9 x) (str "IX" (roman (- x 9)))
  (<= 5 x) (str "V" (roman (- x 5)))
  (<= 4 x) (str "IV" (roman (- x 4)))
  (<= 1 x) (str "I" (roman (- x 1)))
  true ""))
#'user/roman
user> (roman 1)
"I"
user> (roman 30)
"XXX"
user> (roman 4)
"IV"
user> (roman 3999)
"MMMCMXCIX"
