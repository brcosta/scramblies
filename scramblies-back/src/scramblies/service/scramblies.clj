(ns scramblies.service.scramblies)

(defn scramblies?
  [str1 str2]
  (let [freq1 (frequencies str1)
        freq2 (frequencies str2)]
    (reduce #(and %1 (>= (get freq1 %2 0) (get freq2 %2 0))) true (keys freq2)))
  )