(ns jumski.breakage.break-3
  (:require [overtone.midi :refer [midi-out]]
            [jumski.breakage.sequencer :refer [start-sequencing stop-sequencing]]
            [jumski.breakage.state :refer [defpatch reset-state!]]
            [jumski.breakage.helpers :refer [player-fn]]))

; requires akai floppy "DROP OUT"

(reset-state!)
(def sink (midi-out "USB"))
(def midimap {})

(comment
  (start-sequencing 174 #(player-fn sink midimap %))
  (stop-sequencing)
)

(def midimap {7 :snare-pitch})
(def midimap {7 :snare-pitch-fast})
(def midimap {7 :snare-pitch-fast2})


(def midimap { 1 :break1                                                                })
(def midimap { 1 :break1   2 :hats1                                                     })
(def midimap {             2 :hats1   3 :snares2                                        })

(def midimap { 1 :break1   2 :hats1   3 :snares1                                        })
(def midimap { 1 :break1   2 :hats1   3 :snares2                                        })
(def midimap { 1 :break1   2 :hats2   3 :snares2   4 :hard-snare                        })
(def midimap { 1 :break1   2 :hats2   3 :snares2   4 :hard-snare   7 :snare-pitch       })
(def midimap {1 :test})
(def midimap { 1 :break1   2 :hats2   3 :snares2   4 :hard-snare   7 :snare-pitch-fast  })
(def midimap { 1 :break1   2 :hats2   3 :snares2   4 :hard-snare   7 :snare-pitch-fast2 })
(def midimap { 1 :break1   2 :hats2   3 :snares1   4 :hard-snare   7 :snare-pitch-fast2 })
(def midimap { 1 :break1   2 :hats2                                7 :snare-pitch-fast2 })
(def midimap {1 :test})

(def midimap { 1 :kicks1   2 :hats1   3 :snares1                                        })
(def midimap { 1 :kicks1   2 :hats2   3 :snares2                                        })
(def midimap { 1 :kicks1   2 :hats2   3 :snares2   4 :hard-snare                        })
(def midimap { 1 :kicks1   2 :hats2   3 :snares2   4 :hard-snare   7 :snare-pitch       })
(def midimap { 1 :kicks1   2 :hats2   3 :snares2   4 :hard-snare   7 :snare-pitch-fast  })
(def midimap { 1 :kicks1   2 :hats2   3 :snares2   4 :hard-snare   7 :snare-pitch-fast2 })
(def midimap { 1 :kicks1   2 :hats2   3 :snares1   4 :hard-snare   7 :snare-pitch-fast2 })
(def midimap { 1 :kicks1   2 :hats2                                7 :snare-pitch-fast2 })
(def midimap { 4 :hard-snare})
(def midimap {1 :test})

(def midimap (assoc midimap 3 :snares1))
(def midimap (assoc midimap 3 :snares2))

(defpatch :test
  :do-snare    7 3 2 . 2 . )


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
          + . . . + . . . 2 . . . 3 . 6 .
  :e2     2 . 3 . . . 6 . + . . . + . . .
          + . . . + . . . + . . . + . . .
  )
(defpatch :snare-pitch-fast2
  :c#3    + . . . + . . . + . . . + . . .
          + . 4 . + . . . 4 . . . + . . .
          + . . . + . . . + . . . + . . .
          + . . . + . . . 2 . 3 . 4 . 6 .
  :e2     2 . 3 . 4 . 6 . + . . . + . . .
          + . . . + . . . + . . . + . . .
  )

(defpatch :break1
  :do-kick      5 . . .  +  . 5 . + .  .  . 5 .  .  .
  :do-snare     + . . . 4.6 . . . + . 4.6 . + .  .  .
                + . . . 4.6 . . . + . 4.6 . + .  .  .
                + . . . 4.6 . . . + . 4.6 . + . 4.6 .
  )

(defpatch :hats1
  :do-chat      + . 3 . + . 3 . 3 . . . . . 3 .
  )

(defpatch :hats2
  :do-chat      + 3 . 3 + . 3 . 3 . . . 3 . 3 .
                + 3 . 3 + . 3 . 3 . 4 . 3 . 3 .
  :ab-chat2        + . 3 . 3 . 3 . 3 . 4 . + 3 . 3
                + . 3 . 3 . 3 . 3 . . . + 3 . 3
  )

(defpatch :snares1
  :ab-snare6       . .     . . 3.5
  :ab-snare5       . . 3.5 . .  .
  :ab-snare1       + .  .  . +  . . . + . . . + . . .
                + .  .  . +  . . + 5 . . . + . . .
  )

(defpatch :snares2
  :c0           + . . . + . . . + . . . + . . .
  ;; :ab-snare6       . . . . . 4
  :ab-snare5       . . 4 . . .
  :ab-snare1       + . . . + 4 . . + 4 . . + . . .
                + . . . + . . 2 + . . . + . . .
  )

(defpatch :kicks1
  :c0       (repeat 16 nil)
  :ab-kick2    6 . . . . .
  )

(defpatch :hard-snare
  :ab-snare8 (repeat 48 nil)      + . . . + . . . . 6 . . + . . .
  :ab-snare7 (repeat 48 nil)      + . . . + . . . . 6 . . + . . .
  )
