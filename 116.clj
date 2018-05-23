;; 116 Prime Sandwich [m]

Tests if num is a prime number which is also the
mean of the primes directly before and after it
in the sequence of valid primes.

(defn balanced-prime? [n]
  (let [factors (cons 2 (iterate (partial + 2) 3)) 
        prime? (fn [n] (not-any? #(zero? (mod n %))
          (take-while #(<= % (inc (Math/sqrt n)))
            factors)))
        prime-step (fn [n s] (first (drop-while 
          (complement prime?) (rest (iterate
            (partial + s) n)))))]
    (and (> n 3)
         (prime? n)
         (= n (/ (+ (prime-step n 2) (prime-step n -2))
                  2)))))
#'user/balanced-prime?
user> (balanced-prime? 4)
false
user> (balanced-prime? 563)
true
user> (nth (filter balanced-prime? (range)) 15)
1103
