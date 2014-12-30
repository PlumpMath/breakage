(ns jumski.breakage.breaks.pitches_2
  (:use [jumski.breakage.sequencer])
  (:require [jumski.breakage.kit :as kit])
  (:require [overtone.live :as o]))

(def amen-break (kit/load-kit "samples/amen-break"))

(def base3 [
  :kick3    [5 _ _ _ _ _ 5 _ _ _ _ _ _ _ _ _]
            [1 _ _ _ _ _ 1 _ _ _ _ _ _ _ _ _]
  :chat1    [_ _ 4 _ 4 _ 4 _ 4 _ 4 _ _ _ _ _]

  :csnare   [_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
             _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
             _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
             _ _ _ _ _ _ _ _ _ _ 3 _ _ _ _ _]

  :stab     [_ _ _ _ _ _ 2 1 1 _ _ _ _ _ _ _
             _ _ _ _ _ _ 2 1 1 _ _ _ _ _ _ _
             _ _ _ _ _ _ 2 1 1 _ _ _ _ _ _ _
             _ _ _ _ _ _ _ _ _ 2 _ _ 3 _ _ _]
            [_ _ _ _ _ _ 7 5 3 _ _ _ _ _ _ _
             _ _ _ _ _ _ 7 5 3 _ _ _ _ _ _ _
             _ _ _ _ _ _ 7 5 3 _ _ _ _ _ _ _
             _ _ _ _ _ _ _ _ _ 2 _ _ 1 _ _ _]

  :ssnare1  [_ _ 4 _ 2 _ 2 _ 4 _ 2 _ _ 6 _ _]
            [_ _ 1 _ 2 _ 2 _ 1 _ 2 _ _ _ _ _]

  :snare4   [_ _ _ _ _ _ _ _ _ _ _ _ 2 _ _ 1
             _ _ _ _ _ _ _ _ _ _ _ _ 2 1 _ 1
             _ _ _ _ _ _ _ _ _ _ _ _ 2 _ _ 1
             _ _ _ _ _ _ _ _ _ _ _ _ 2 _ _ _]
            [_ _ _ _ _ _ _ _ _ _ _ _ 4 _ _ _
             _ _ _ _ _ _ _ _ _ _ _ _ 4 _ _ _
             _ _ _ _ _ _ _ _ _ _ _ _ 4 _ _ _
             _ _ _ _ _ _ _ _ _ _ _ _ 4 _ _ _]

  :snare3   [_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
             _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
             _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
             _ _ _ _ _ _ _ _ 4 _ _ _ _ _ _ _]

  :rsnare   [_ 2 _ _ _ _ _ 2 _ _ _ _ _ _ _ 1]

  :ohat     [2 _ 2 _ 2 _ 2 _]
  :chat4 [_ 4 _ _ _ _ 4 _ _ _ _ _ _ _ _ _
          _ _ _ _ _ _ _ _ _ 1 2 3 4 5 6 7]

  ]
  )

(defn pattern [] base3)

(o/stop)
(o/volume 0.3)
(play amen-break #'pattern 178)
