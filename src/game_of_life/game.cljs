(ns game-of-life.game
  (:require [clojure.set :refer [union
                                 difference]]))

(defn create-cells
  []
  #{[0 0] [1 1] [1 0]})

(defn get-neighbours
  [[x y]]
  #{[(inc x)      y]    ;; x+1 y
    [x       (inc y)]   ;; x   y+1
    [(inc x) (inc y)]   ;; x+1 y+1
    [(dec x)      y]    ;; x-1 y
    [x       (dec y)]   ;; x   y-1
    [(dec x) (dec y)]   ;; x-1 y-1
    [(dec x) (inc y)]   ;; x-1 y+1
    [(inc x) (dec y)]})
