(ns game-of-life.game
  (:require [clojure.set :refer [union
                                 intersection
                                 difference]]))

(defn create-cells
  []
  #{[0 0] [1 1] [1 0]})

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
                                 (union acc))) #{} alive-cells)))

(defn will-live?
  [alive-cells cell]
  (let [neighbours (get-neighbours cell)]
    (-> neighbours
        (intersection alive-cells)
        count
        (= 3))))

(defn step
  [alive-cells]
  (let [all-cells (get-all-cells alive-cells)]
    (-> (filter (fn [cell] (will-live? alive-cells cell)) all-cells)
        set)))
