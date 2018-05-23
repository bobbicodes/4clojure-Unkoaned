{:_id 77 :title "Anagram Finder"
:tests [
"(= (__ [\"meat\" \"mat\" \"team\" \"mate\" \"eat\"])\n   #{#{\"meat\" \"team\" \"mate\"}})"
"(= (__ [\"veer\" \"lake\" \"item\" \"kale\" \"mite\" \"ever\"])\n   #{#{\"veer\" \"ever\"} #{\"lake\" \"kale\"} #{\"mite\" \"item\"}})"],
:description "Write a function which finds all the anagrams in a vector of words.
A word x is an anagram of word y if all the letters in x can be rearranged in a different order to form y.
Your function should return a set of sets, where each sub-set is a group of words which are anagrams of each other.
Each sub-set should have at least two words.  Words without any anagrams should not be included in the result."
:tags ["medium"]}

#(->> % (group-by set) vals (filter next) (map set) set)
