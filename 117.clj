;; 117 For Science! [h]

hashes (#) = maze walls, M = starting point, C = cheese
Can go only up/down/left/right
Returns true iff the maze is solvable by the mouse.

(= true  (__ ["M   C"]))
(= false (__ ["M # C"]))
(= true  (__ ["#######"
              "#     #"
              "#  #  #"
              "#M # C#"
              "#######"]))
(= false (__ ["########"
              "#M  #  #"
              "#   #  #"
              "# # #  #"
              "#   #  #"
              "#  #   #"
              "#  # # #"
              "#  #   #"
              "#  #  C#"
              "########"]))
(= false (__ ["M     "
              "      "
              "      "
              "      "
              "    ##"
              "    #C"]))
(= true  (__ ["C######"
              " #     "
              " #   # "
              " #   #M"
              "     # "]))
(= true  (__ ["C# # # #"
              "        "
              "# # # # "
              "        "
              " # # # #"
              "        "
              "# # # #M"]))

(fn f [a b c]
  (and (not= a c)
    (if (re-seq #"CM|MC" (pr-str c))
      true
      (f b c (apply map str (map #(.replaceAll % " M|M " "MM") c))))))
0
0
