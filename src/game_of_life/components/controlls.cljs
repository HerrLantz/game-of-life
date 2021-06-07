(ns game-of-life.components.controlls
  (:require [game-of-life.state :refer [dispatch]]))

(defn controlls
  []
  [:div
   [:button {:on-click #(dispatch {:action :step})}
    "step"]
   [:button {:on-click #(dispatch {:action :reset})}
    "reset"]
   [:button {:on-click #(dispatch {:action :clear})}
    "clear"]])
