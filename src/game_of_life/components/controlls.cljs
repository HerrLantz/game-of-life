(ns game-of-life.components.controlls
  (:require [game-of-life.state :refer [dispatch]]))

(defn get-style
  []
  {:border-style "none"
   :padding "0.5rem 1rem"})

(defn controlls
  []
  [:div
   [:button {:style (get-style)
             :on-click #(dispatch {:action :step})}
    "step"]
   [:button {:style (get-style)
             :on-click #(dispatch {:action :reset})}
    "reset"]
   [:button {:style (get-style)
             :on-click #(dispatch {:action :clear})}
    "clear"]])
