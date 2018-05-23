;; 92 Read Roman numerals [h]

Roman numerals are easy to recognize,
but not everyone knows all the rules necessary
to work with them. This will parse a Roman-numeral string
and return the number it represents. 

Input will be well-formed, in upper-case,
and follow the subtractive principle.
You don't need to handle any numbers greater than
MMMCMXCIX (3999), the largest number
representable with ordinary letters.

(= 14 (__ "XIV"))
(= 827 (__ "DCCCXXVII"))
(= 3999 (__ "MMMCMXCIX"))
(= 48 (__ "XLVIII"))

#(->> (map {\C 100 \D 500 \I 1 \L 50 \M 1000 \V 5 \X 10} %)
      (partition 2 1 [0])
      (map (fn [[a b]] (if (< a b) (- a) a)))
      (apply +))
