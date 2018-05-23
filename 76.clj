{:_id 76 :title "Intro to Trampoline"

(letfn
     [(foo [x y] #(bar (conj x y) y))
      (bar [x y] (if (> (last x) 10)
                   x
                   #(foo x (+ 2 y))))]
     (trampoline foo [] 1))
 
 :description "The trampoline function takes a function f and a variable number of parameters.
 Trampoline calls f with any parameters that were supplied.
 If f returns a function, trampoline calls that function with no arguments.
 This is repeated, until the return value is not a function, and then trampoline returns that non-function value.
 This is useful for implementing mutually recursive algorithms in a way that won't consume the stack."
 :tags ["medium" "recursion"]}

; Here is what is happening:
; foo is called with [] 1, returns #(bar [1] 1)
; #(bar [1] 1) returns #(foo [1] 3)
; #(foo [1] 3) returns #(bar [1 3] 3)
; #(bar [1 3] 3) returns #(foo [1 3] 5)
; and so on and so on until (> (last [x] 10))
[1 3 5 7 9 11]
