Squares Squared
Difficulty:	Hard
Topics:	data-juggling

Create a function of two integer arguments: the start and end, respectively.
You must create a vector of strings which renders a 45° rotated square of integers
which are successive squares from the start point up to and including the end point.
If a number comprises multiple digits, wrap them around the shape individually.
If there are not enough digits to complete the shape, fill in the rest with asterisk characters.
The direction of the drawing should be clockwise, starting from the center of the shape and working outwards,
with the initial direction being down and to the right.

(= (__ 2 2) ["2"])

(= (__ 2 4) [" 2 "
             "* 4"
             " * "])

(= (__ 3 81) [" 3 "
              "1 9"
              " 8 "])

(= (__ 4 20) [" 4 "
              "* 1"
              " 6 "])

(= (__ 2 256) ["  6  "
               " 5 * "
               "2 2 *"
               " 6 4 "
               "  1  "])

(= (__ 10 10000) ["   0   "
                  "  1 0  "
                  " 0 1 0 "
                  "* 0 0 0"
                  " * 1 * "
                  "  * *  "
                  "   *   "])
                  
(fn [start end]
  (let [s (->> (iterate #(* % %) start) (take-while #(<= % end)) (mapcat str))
        d (int (Math/ceil (Math/sqrt (count s))))
        xs (concat s (repeat (- (* d d) (count s)) \*))
        cp [(if (even? d) (- d 2) (dec d)) (dec d)]
        dr (mapcat #(repeat (* % 2) (if (even? %) -1 1)) (range))
        dc (mapcat #(repeat (inc (* % 2)) (if (even? %) 1 -1)) (range))
        dp (map #(vector %1 %2) dr dc)
        pp (reductions #(vector (+ (first %1) (first %2)) (+ (last %1) (last %2))) cp dp)
        len (dec (* 2 d))
        eb (vec (repeat len (vec (repeat len \ ))))
        cal (fn [b xs pp]
              (if xs
                (recur (assoc-in b (first pp) (first xs)) (next xs) (next pp))
                b))
        ]
    (mapv #(apply str %) (cal eb xs pp))))
