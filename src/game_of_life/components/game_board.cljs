(ns game-of-life.components.game-board
  (:require [game-of-life.components.cell :refer [cell]]
            [game-of-life.state           :refer [dispatch
                                                  get-cells]]))
(defn get-style
  [{x :x
    y :y}]
  {:display               "grid"
   :grid-template-columns (apply str (repeat y "1fr "))
   :grid-template-rows    (apply str (repeat x "1fr "))
   :width                 "35rem"
   :height                "35rem"
   :padding               "0"
   :margin                "0"})

(defn game-board
  [{rows :x
    cols :y}]
  (let [cells (get-cells)]
    [:div {:style (get-style {:x rows :y cols})}
     (map-indexed (fn [idx1 y]
                    (map-indexed (fn [idx2 x]
                                   (cell {:x x
                                          :y y
                                          :alive (contains? cells [x y])}))
                                 (range rows)))
                  (range cols))]))
