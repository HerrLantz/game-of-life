(ns game-of-life.game
  (:require [clojure.set :refer [union
                                 intersection
                                 difference]]))

(defn create-cells
  []
  #{[12 12] [13 12] [14 12] [14 11] [13 10]})

(defn toggle-cell
  [alive-cells cell]
  (if (contains? alive-cells cell)
    (difference alive-cells #{cell})
    (union alive-cells #{cell})))

(defn get-neighbours
  [[x y]]
  #{[(inc x)      y]
    [x       (inc y)]
    [(inc x) (inc y)]
    [(dec x)      y]
    [x       (dec y)]
    [(dec x) (dec y)]
    [(dec x) (inc y)]
    [(inc x) (dec y)]})

(defn get-all-cells
  [alive-cells]
  (-> (reduce (fn [acc curr] (-> (get-neighbours curr)
                                 (union acc))) alive-cells alive-cells)))

(defn will-live?
  [alive-cells cell condition]
  (as-> (get-neighbours cell) $
        (intersection $ alive-cells)
        (count $)
        (condition $)))

(defn filter-cells
  [alive-cells cells condition]
  (set (filter (fn [cell] (will-live? alive-cells cell condition)) cells)))

(defn step
  [alive-cells]
  (let [all-cells (get-all-cells alive-cells)
        dead-cells (difference all-cells alive-cells)]
    (union (filter-cells alive-cells alive-cells (fn [c] (or (= c 2) (= c 3))))
           (filter-cells alive-cells dead-cells  (fn [c] (= c 3))))))
