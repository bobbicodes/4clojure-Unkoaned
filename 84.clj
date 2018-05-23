{:_id 84 :title "Transitive Closure"
:tests [
"(let [divides #{[8 4] [9 3] [4 2] [27 9]}]\n  (= (__ divides) #{[4 2] [8 4] [8 2] [9 3] [27 9] [27 3]}))"
"(let [more-legs\n      #{[\"cat\" \"man\"] [\"man\" \"snake\"] [\"spider\" \"cat\"]}]
(= (__ more-legs)
#{[\"cat\" \"man\"] [\"cat\" \"snake\"] [\"man\" \"snake\"]
[\"spider\" \"cat\"] [\"spider\" \"man\"] [\"spider\" \"snake\"]}))" "(let [progeny
#{[\"father\" \"son\"] [\"uncle\" \"cousin\"] [\"son\" \"grandson\"]}]
(= (__ progeny)
#{[\"father\" \"son\"] [\"father\" \"grandson\"]
[\"uncle\" \"cousin\"] [\"son\" \"grandson\"]}))"],
:description "Write a function which generates the 
<a href=\"http://en.wikipedia.org/wiki/Transitive_closure\">transitive closure</a> of a 
<a href=\"http://en.wikipedia.org/wiki/Binary_relation\">binary relation</a>.
The relation will be represented as a set of 2 item vectors."
:tags ["hard" "set-theory"]}

(let [divides #{[8 4] [9 3] [4 2] [27 9]}]
  (= (__ divides) #{[4 2] [8 4] [8 2] [9 3] [27 9] [27 3]}))
(let [more-legs
      #{["cat" "man"] ["man" "snake"] ["spider" "cat"]}]
  (= (__ more-legs)
     #{["cat" "man"] ["cat" "snake"] ["man" "snake"]
       ["spider" "cat"] ["spider" "man"] ["spider" "snake"]}))
(let [progeny
      #{["father" "son"] ["uncle" "cousin"] ["son" "grandson"]}]
  (= (__ progeny)
     #{["father" "son"] ["father" "grandson"]
       ["uncle" "cousin"] ["son" "grandson"]}))

#(loop [s %]
   (let [n (into s
                 (for [[a b] s [c d] s 
                       :when (= b c)] 
                   [a d]))]
      (if (= n s) n (recur n))))
