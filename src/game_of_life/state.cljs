(ns game-of-life.state
  (:require [game-of-life.game :refer [create-cells
                                       toggle-cell
                                       step]]
            [reagent.core      :as     r]))

(def default-state
  {:alive-cells (create-cells)
   :history     '()
   :actions     '()})

(defonce game-state-atom (r/atom default-state))

(defn- save-to-history
  [game-state]
  (if (= (:alive-cells game-state) (first (:history game-state)))
    game-state
    (update game-state :history conj (:alive-cells game-state))))

(defn- get-previous-state
  [game-state]
  (-> (assoc game-state :alive-cells (first (:history game-state)))
      (update :history rest)))

(defn clear-cells
  [game-state]
  (assoc game-state :alive-cells #{}))

(defn save-action
  [game-state action]
  (update game-state :actions conj action))

(defn next-step
  [game-state]
  (-> (save-to-history game-state)
      (update :alive-cells step)))

(defn toggle
  [game-state cell]
  (update game-state :alive-cells (fn [gs] (toggle-cell gs cell))))

(defn dispatch
  [{action :action value :value}]
  (swap! game-state-atom save-action {:action action :value value})
  (condp = action
    :step        (swap! game-state-atom next-step)
    :back        (swap! game-state-atom get-previous-state)
    :toggle-cell (swap! game-state-atom toggle value)
    :reset       (reset! game-state-atom default-state)
    :clear       (swap! game-state-atom clear-cells)))

(defn get-cells
  []
  (:alive-cells (deref game-state-atom)))

