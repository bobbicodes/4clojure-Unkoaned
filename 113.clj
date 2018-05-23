;; 113 Making Data Dance [h]

Takes a variable number of integer arguments.
If the output is coerced into a string,
returns a comma (and space) separated list of
the inputs sorted smallest to largest.
If the output is coerced into a sequence,
it should return a seq of unique input elements
in the same order as they were entered.

(= "1, 2, 3" (str (__ 2 1 3)))
(= '(2 1 3) (seq (__ 2 1 3)))
(= '(2 1 3) (seq (__ 2 1 3 3 1 2)))
(= '(1) (seq (apply __ (repeat 5 1))))
(= "1, 1, 1, 1, 1" (str (apply __ (repeat 5 1))))
(and (= nil (seq (__)))
     (=  "" (str (__))))

-------------------------
clojure.core/proxy
([class-and-interfaces args & fs])
Macro
  class-and-interfaces - a vector of class names args -
  a (possibly empty) vector of arguments
  to the superclass constructor.
  f => (name [params*] body) or
  (name ([params*] body) ([params+] body) ...)
  Expands to code which creates a instance of a proxy class
  that implements the named class/interface(s)
  by calling the supplied fns.
  A single class, if provided, must be first.
  If not provided it defaults to Object.

  The interfaces names must be valid interface types.
  If a method fn is not provided for a class method,
  the superclass methd will be called.
  If a method fn is not provided for an interface method,
  an UnsupportedOperationException will be
  thrown should it be called.
  Method fns are closures and can capture
  the environment in which proxy is called.
  Each method fn takes an additional implicit first arg,
  which is bound to 'this.
  Note that while method fns can be provided
  to override protected methods,
  they have no other access to protected members,
  nor to super, as these capabilities cannot be proxied.

#(when %&
   (reify
     clojure.lang.ISeq
     (seq [_] (distinct %&))
     (toString [_] (apply str (interpose ", " (sort %&))))))

#(let [args %&]
   (reify clojure.lang.Seqable
     (toString [this] (clojure.string/join ", " (sort args)))
     (seq [this] (seq (distinct args)))))

#(reify clojure.lang.Seqable
     (seq [t] (not-empty (distinct %&)))
     (toString [t] (clojure.string/join ", " (sort %&)) ))
