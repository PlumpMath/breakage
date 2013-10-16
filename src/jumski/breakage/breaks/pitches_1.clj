(ns jumski.breakage.breaks.pitches_1
  (:use [jumski.breakage.step-seq]
        [jumski.breakage.pattern])
  (:require [jumski.breakage.kit :as kit])
  (:require [overtone.live :as o]))

(def amen-break (kit/load-kit "samples/amen-break"))

(def base3 [
           ;[X _ _ _ X _ _ _ X _ _ _ X _ _ _]
  :kick1    [7 _ _ _ _ _ 7 _ _ _ _ _ _ _ _ _]
  :chat1    [_ _ 4 _ 4 _ 4 _ 4 _ 4 _ _ _ _ _]
  :stab     [_ _ _ _ _ _ _ _ _ _ 2 _ _ _ _ _]

  :ssnare1  [_ _ _ 4 _ 2 _ 2 _ 4 _ 2 _ _ 6 _]
            [_ _ _ 1 _ 2 _ 2 _ 1 _ 2 _ _ _ _]

  :snare4   [_ _ _ _ _ _ _ _ _ _ _ _ 2 1 _ 1]
            [_ _ _ _ _ _ _ _ _ _ _ _ 4 _ _ _]
            ])

(defn levery [qtrs vol]
  (->> vol
       (conj (repeat (- qtrs 1) _))
       cycle
       (take 16)
       vec))

(defn pattern [] base3)

(o/stop)
(o/volume 0.3)
(play amen-break #'pattern 194)
;; (play-pattern amen-break pattern :snare1 0)
