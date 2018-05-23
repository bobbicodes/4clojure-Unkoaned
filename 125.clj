Gus' Quinundrum
Difficulty:	Hard
Topics:	logic fun brain-teaser

Create a function of no arguments which returns a string that is an exact copy of the function itself. 

Hint: read this if you get stuck (this question is harder than it first appears); but it's worth the effort to solve it independently if you can! 

Fun fact: Gus is the name of the 4Clojure dragon.	

(= (str '__) (__))

(fn [x] (str x x)) '(fn [x] (str x x))
