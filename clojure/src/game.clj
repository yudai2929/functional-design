(ns game
  (:require [speclj.core :refer :all]))



(defn score [rolls] 0)

(should= 0 (score (repeat 20 0)))


(defn score [rolls] (reduce + rolls))

(should= 20 (score (repeat 20 1)))


(defn to-frames [rolls]
  (loop [remaining-rolls rolls
         frames []]
    (cond
      (empty? remaining-rolls) frames
      (= 10 (reduce + (take 2 remaining-rolls)))
      (recur (drop 2 remaining-rolls)
             (conj frames (take 3 remaining-rolls)))
      :else
      (recur (drop 2 remaining-rolls)
             (conj frames (take 2 remaining-rolls))))))

(defn add-frames [score frame]
  (+ score (reduce + frame)))

(defn score [rolls]
  (reduce add-frames 0 (to-frames rolls)))

(should= 24 (score (concat [5 5 7] (repeat 17 0))))



(defn to-frames [rolls]
  (loop [remaining-rolls rolls
         frames []]
    (cond
      (empty? remaining-rolls) frames
      (= 10 (first remaining-rolls))
      (recur (rest remaining-rolls)
             (conj frames (take 3 remaining-rolls)))
      (= 10 (reduce + (take 2 remaining-rolls)))
      (recur (drop 2 remaining-rolls)
             (conj frames (take 3 remaining-rolls)))
      :else
      (recur (drop 2 remaining-rolls)
             (conj frames (take 2 remaining-rolls))))))

(defn add-frames [score frame]
  (+ score (reduce + frame)))

(defn score [rolls]
  (reduce add-frames 0 (to-frames rolls)))


(should= 20 (score (concat [10 2 3] (repeat 16 0))))


(defn score [rolls]
  (reduce add-frames 0 (take 10 (to-frames rolls))))

(should= 300 (score (repeat 12 10)))