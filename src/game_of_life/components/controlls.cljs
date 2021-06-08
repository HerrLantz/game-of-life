(ns game-of-life.components.controlls
  (:require [stylefy.core :as stylefy :refer [use-style]]
            [game-of-life.state       :refer [dispatch]]))

(defn get-style
  []
  {:box-sizing         "border-box"
   :-webkit-box-sizing "border-box"
   :padding            "0.5rem 1rem"
   :border-style       "solid"
   :border-width       "0.1rem"
   :border-color       "#f1f1f1"
   :background-color   "#e3e3e3"
   ::stylefy/mode      {:hover {:background-color "#a3a3a3"}}})

(defn controlls
  []
  [:div
   [:button (use-style (get-style)
                       {:on-click #(dispatch {:action :step})})
    "step"]
   [:button (use-style (get-style)
                       {:on-click #(dispatch {:action :reset})})
    "reset"]
   [:button (use-style (get-style)
                       {:on-click #(dispatch {:action :clear})})
    "clear"]])
