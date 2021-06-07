(ns ^:figwheel-hooks game-of-life.core
  (:require
   [goog.dom :as gdom]
   [reagent.core :as reagent :refer [atom]]
   [reagent.dom :as rdom]
   [game-of-life.components.game-board :refer [game-board]]
   [game-of-life.components.controlls :refer [controlls]]))

(defn get-app-element []
  (gdom/getElement "app"))

(defn hello-world []
  [:div
   (game-board {:x 30 :y 30})
   (controlls)])

(defn mount [el]
  (rdom/render [hello-world] el))

(defn mount-app-element []
  (when-let [el (get-app-element)]
    (mount el)))

(mount-app-element)

(defn ^:after-load on-reload []
  (mount-app-element))


