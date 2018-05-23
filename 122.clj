Read a binary number
Difficulty:	Easy
Topics:	

Convert a binary number, provided in the form of a string, to its numerical value.
test not run	

(= 0     (__ "0"))
test not run	

(= 7     (__ "111"))
test not run	

(= 8     (__ "1000"))
test not run	

(= 9     (__ "1001"))
test not run	

(= 255   (__ "11111111"))
test not run	

(= 1365  (__ "10101010101"))
test not run	

(= 65535 (__ "1111111111111111"))

#(Integer/parseInt % 2)
