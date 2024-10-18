(ns prime-factors-test
  (:require [speclj.core :refer :all]))


(defn prime-factors [n]
  (loop [ n n
          divisor 2
          factors []]
    (if (> n 1)
      (if (zero? (rem n divisor))
        (recur (quot n divisor) divisor (conj factors divisor))
        (recur n (inc divisor) factors))
      factors)))



(should= [] (prime-factors 1))
(should= [2] (prime-factors 2))
(should= [3] (prime-factors 3))
(should= [2 2] (prime-factors 4))
(should= [5] (prime-factors 5))
(should= [2 3] (prime-factors 6))
(should= [7] (prime-factors 7))
(should= [2 2 2] (prime-factors 8))
(should= [3 3] (prime-factors 9))