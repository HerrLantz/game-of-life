(ns game-of-life.components.cell
  (:require [game-of-life.state :refer [dispatch]]))

(defn get-style
  [{alive :alive}]
  {:background-color (if alive "#67EF32" "#92a38c")
   :border-style     "solid"
   :border-color     "#909090"
   :border-width     "0.1rem"})

(defn cell
  [{alive :alive
    x     :x
    y     :y}]
  [:div {:style    (get-style {:alive alive})
         :id       (str x y)
         :on-click #(dispatch {:action :toggle-cell :value [x y]})
         :key      (str x y)}])
