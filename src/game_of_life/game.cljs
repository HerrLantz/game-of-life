(ns game-of-life.game
  (:require [clojure.set :refer [union
                                 difference]]))

(defn create-cells
  []
  #{[0 0] [1 1] [1 0]})
