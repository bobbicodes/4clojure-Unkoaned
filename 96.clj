;; 96 Symmetry

A binary tree is "symmetric" if the left half
is the mirror image of the right.
This is a predicate to determine whether or not
a given binary tree is symmetric.
(see To Tree, or not to Tree for a reminder
on the tree representation we're using).
	
#(= % ((fn m [[v l r]] (if v [v (m r) (m l)])) %))
	
((fn [[_ l r]]
  (letfn [(mirror?
            [[lx ll lr :as l] [rx rl rr :as r]]
            (or (not (or l r))
                (and (= lx rx)
                     (and (mirror? ll rr)
                          (mirror? lr rl)))))]
    (mirror? l r))) '(:a (:b nil nil) (:b nil nil)))
;;=> true

((fn [[_ l r]]
  (letfn [(mirror?
            [[lx ll lr :as l] [rx rl rr :as r]]
            (or (not (or l r))
                (and (= lx rx)
                     (and (mirror? ll rr)
                          (mirror? lr rl)))))]
    (mirror? l r))) '(:a (:b nil nil) nil))
;;=> false

((fn [[_ l r]]
  (letfn [(mirror?
            [[lx ll lr :as l] [rx rl rr :as r]]
            (or (not (or l r))
                (and (= lx rx)
                     (and (mirror? ll rr)
                          (mirror? lr rl)))))]
    (mirror? l r))) '(:a (:b nil nil) (:c nil nil)))
;;=> false

((fn [[_ l r]]
  (letfn [(mirror?
            [[lx ll lr :as l] [rx rl rr :as r]]
            (or (not (or l r))
                (and (= lx rx)
                     (and (mirror? ll rr)
                          (mirror? lr rl)))))]
    (mirror? l r))) [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
          [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]]) ;;=> true
((fn [[_ l r]]
  (letfn [(mirror?
            [[lx ll lr :as l] [rx rl rr :as r]]
            (or (not (or l r))
                (and (= lx rx)
                     (and (mirror? ll rr)
                          (mirror? lr rl)))))]
    (mirror? l r))) [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
          [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]]) ;;=> false
((fn [[_ l r]]
  (letfn [(mirror?
            [[lx ll lr :as l] [rx rl rr :as r]]
            (or (not (or l r))
                (and (= lx rx)
                     (and (mirror? ll rr)
                          (mirror? lr rl)))))]
    (mirror? l r))) [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
          [2 [3 nil [4 [6 nil nil] nil]] nil]]) ;;=> false
