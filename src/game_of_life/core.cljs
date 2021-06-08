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
   (game-board {:x 50 :y 50})
   (controlls)])

(defn init-stylefy
  []
  (stylefy/init {:dom (stylefy-reagent/init)}))

(defn mount-app-element
  []
  (->> (gdom/getElement "app")
       (rdom/render [app])))

(defn ^:export start
  []
  (init-stylefy)
  (mount-app-element))

(defn ^:after-load on-reload []
  (mount-app-element))
