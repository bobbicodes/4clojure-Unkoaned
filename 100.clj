;; 100 Least Common Multiple

Accepts variable num of positive ints or ratios 
	
(defn lcm [& args]
   (let [gcd (fn [a b] (if (zero? b) a (recur b (mod a b))))]
     (/ (reduce * args) (reduce gcd args))))
 2 3
6

To calculate the LCM,
first we need the GCD.

;Here's that func:

(fn [a b]
          (if
              (zero? b)
               a
              (recur b 
                       (mod a b))))

; Start with
(mod a b)

; Plug in our test args:

user> (mod 2 3)
2
user> (source mod)
(defn mod
  "Modulus of num and div.
   Truncates toward negative infinity."
  [num div] 
  (let [m (rem num div)] 
    (if (or (zero? m) (= (pos? num) (pos? div)))
      m 
      (+ m div))))

; 2 divided by 3 is 0 r2.

; Here's the GCD function:

(fn [a b]
          (if
              (zero? b)
               a
              (recur b 
                       (mod a b))))

; Just the body:

          (if
              (zero? b)
               a
              (recur b 
                       (mod a b)))

; With args:

          (if
              (zero? 3)
               2
              (recur 3 
                       (mod 2 3)))

3 is not zero, so we recur with:
a = 3
b = (mod 2 3) which is 2.
2 is also not= 0.

user> (mod 3 2)
1

          (if
              (zero? b)
               a
              (recur b 
                       (mod a b)))

So we recur with:
a = 2
b = 1

again 1 is not 0, so recur with 1 and 0.
this time, b = 0.
So we return a, which is 1.

; now that we've determined the GCD,
here's the original func again:

(defn lcm [& args]
  (let
    [gcd
      (fn [a b]
        (if (zero? b)
           a
           (recur b 
             (mod a b))))]
    (/
      (reduce * args)
      (reduce gcd args))))

; Rewritten as gcd = 1:

(defn lcm [& args]
  (let [gcd 1]
    (/
      (reduce * args)
      (reduce gcd args)))) 
 
***it multiplies them all,
   and divides it by the gcd.***

;; check it out... let's define gcd as 
its own func:

(defn gcd [a b]
        (if (zero? b)
           a
           (recur b 
             (mod a b))))

Then we need a new lcm function that will call it.

(defn lcm [& args]
    (/
      (reduce * args)
      (reduce gcd args)))

; We'll try it with 5 3 7.
; The final answer we are looking for,
; their LCM, is 105.

user> (reduce * [5 3 7])
105
user> (reduce gcd [5 3 7])
1

***Done!***

((fn [& args] (let [gcd (fn [a b] (if (zero? b) a (recur b (mod a b))))] (/ (reduce * args) (reduce gcd args)))) 5 3 7)
;;=> 105

((fn [& args] (let [gcd (fn [a b] (if (zero? b) a (recur b (mod a b))))] (/ (reduce * args) (reduce gcd args)))) 1/3 2/5)
;;=> 2

((fn [& args] (let [gcd (fn [a b] (if (zero? b) a (recur b (mod a b))))] (/ (reduce * args) (reduce gcd args)))) 3/4 1/6)
;;=> 3/2

((fn [& args] (let [gcd (fn [a b] (if (zero? b) a (recur b (mod a b))))] (/ (reduce * args) (reduce gcd args)))) 7 5/7 2 3/5)
;;=> 210
