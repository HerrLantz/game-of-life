(ns game-of-life.state
  (:require [game-of-life.game :refer [create-cells
                                       toggle-cell
                                       step]]
            [reagent.core      :as     r]))

(defonce game-state-atom (r/atom (create-cells)))


(defn dispatch
  [{action :action value :value}]
  (condp = action
    :step        (swap! game-state-atom step)
    :toggle-cell (swap! game-state-atom toggle-cell value)
    :reset       (reset! game-state-atom (create-cells))
    :clear       (reset! game-state-atom #{})))

(defn get-cells
  []
  (deref game-state-atom))
