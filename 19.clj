(defn get-last-item [coll]
  (if (next coll)
    (recur (next coll))
    (first coll)))

(get-last-item [1 2 3 4 5])
