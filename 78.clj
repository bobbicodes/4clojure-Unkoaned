{:_id 78 :restricted ["trampoline"]
:title "Reimplement Trampoline"
:tests [
"(= (letfn [(triple [x] #(sub-two (* 3 x)))
     (sub-two [x] #(stop?(- x 2)))
       (stop? [x] (if (> x 50) x #(triple x)))]
         (__ triple 2))\n  82)"
"(= (letfn [(my-even? [x] (if (zero? x) true #(my-odd? (dec x))))
  (my-odd? [x] (if (zero? x) false #(my-even? (dec x))))]
    (map (partial __ my-even?) (range 6)))
    [true false true false true false])"]
:description "Reimplement the function described in <a href=\"76\"> \"Intro to Trampoline\"</a>."
:tags ["medium" "core-functions"]}

(fn t [f & x]
  (if (fn? f)
    (t (apply f x))
    f))
