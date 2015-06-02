(ns jumski.breakage.break-3
  (:require [overtone.midi :refer [midi-out]]
            [jumski.breakage.sequencer :refer [start-sequencing stop-sequencing]]
            [jumski.breakage.state :refer [defpatch reset-state!]]
            [jumski.breakage.helpers :refer [player-fn]]))

(reset-state!)
(def sink (midi-out "USB"))
(def midimap {})

(def x (atom 0))
(reset! x 10)

(comment
  (start-sequencing 160 #(player-fn sink midimap %))
  (stop-sequencing)
)


(def midimap { 1 :break1                                                               })
(def midimap { 1 :break1   2 :hats1                                                    })
(def midimap {             2 :hats1   3 :snares2                                       })

(def midimap { 1 :break1   2 :hats1   3 :snares1                                       })
(def midimap { 1 :break1   2 :hats1   3 :snares2                                       })
(def midimap { 1 :break1   2 :hats2   3 :snares2   4 :hard-snare                       })
(def midimap { 1 :break1   2 :hats2   3 :snares2   4 :hard-snare   7 :snare-pitch      })
(def midimap { 1 :break1   2 :hats2   3 :snares2   4 :hard-snare   7 :snare-pitch-fast })

(def midimap { 1 :kicks1   2 :hats1   3 :snares1                                       })
(def midimap { 1 :kicks1   2 :hats2   3 :snares2                                       })
(def midimap { 1 :kicks1   2 :hats2   3 :snares2   4 :hard-snare                       })
(def midimap { 1 :kicks1   2 :hats2   3 :snares2   4 :hard-snare   7 :snare-pitch      })
(def midimap { 1 :kicks1   2 :hats2   3 :snares2   4 :hard-snare   7 :snare-pitch-fast })


(defpatch :snare-pitch
  :c#3    + . . . + . . . + . . . + . . .
          + . . . + . . . + . . . + . . .
          + . . . + . . . + . . . + . . .
          + . . . + . . . + . . . + . 6 .
  :e2     + . . . + . 7 . + . . . + . . .
          + . . . + . . . + . . . + . . .
  )

(defpatch :snare-pitch-fast
  :c#3    + . . . + . . . + . . . + . . .
          + . . . + . . . + . . . + . . .
          + . . . + . . . + . . . + . . .
          + . . . + . . . 2 . 3 . 4 . 6 .
  :e2     2 . 3 . 4 . 6 . + . . . + . . .
          + . . . + . . . + . . . + . . .
  )

(defpatch :break1
  :kick-drop    6 . . .  +  . 6 . + .  .  . 6 .  .  .
  :snare-drop   + . . . 5.6 . . . + . 5.6 . + .  .  .
                + . . . 5.6 . . . + . 5.6 . + .  .  .
                + . . . 5.6 . . . + . 5.6 . + . 5.6 .
  )

(defpatch :hats1
  :chat-drop    + . 4 . + . 4 . 4 . . . . . 4 .
  )

(defpatch :hats2
  :chat-drop    + 3 . 3 + . 3 . 3 . . . 3 . 3 .
  :chat2        + . 3 . 3 . 3 . 3 . . . + 3 . 3
  )

(defpatch :snares1
  :c0           + . . . + . . . + . . . + . . .
  :snare6       . . . . . 4
  :snare5       . . 4 . . .
  :snare1       + . . . + . . . + . . . + . . .
                + . . . + . . + 5 . . . + . . .
  )

(defpatch :snares2
  :c0           + . . . + . . . + . . . + . . .
  ;; :snare6       . . . . . 4
  :snare5       . . 4 . . .
  :snare1       + . . . + 4 . . + 4 . . + . . .
                + . . . + . . + 5 . . . + . . .
  )

(defpatch :kicks1
  :c0       (repeat 16 nil)
  :kick2    9 . . . . .
  )

(defpatch :hard-snare
  :snare8 (repeat 48 nil)      + . . . + . . . 6 . . . + . . .
  :kick6 (repeat 48 nil)       + . . . + . . . 6 . . . + . . .
  ;; :kick1 (repeat 96 nil)      + . . . + . . . 8 . . . + . . .
  ;; :snare2 (repeat 96 nil)      + . . . + . . . 5 . . . + . . .
  ;; :snare3 (repeat 96 nil)      + . . . + . . . 5 . . . + . . .
  )
