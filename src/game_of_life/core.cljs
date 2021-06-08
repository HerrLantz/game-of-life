(ns ^:figwheel-hooks game-of-life.core
  (:require
   [goog.dom :as gdom]
   [reagent.core :as reagent :refer [atom]]
   [reagent.dom :as rdom]
   [stylefy.core :as stylefy]
   [stylefy.reagent :as stylefy-reagent]
   [game-of-life.components.game-board :refer [game-board]]
   [game-of-life.components.controlls :refer [controlls]]))

(defn app
  []
  [:div
   (game-board {:x 30 :y 30})
   (controlls)])

(defn init-stylefy
  []
  (stylefy/init {:dom (stylefy-reagent/init)}))

(defn ^:export start
  []
  (init-stylefy)
  (->> (gdom/getElement "app")
       (rdom/render [app])))
