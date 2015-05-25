(ns jumski.breakage.break-1
  (:require [overtone.midi :refer [midi-out]]
            [jumski.breakage.sequencer :refer [start-every-sequencing
                                               stop-every-sequencing]]
            [jumski.breakage.state :refer [defpatch]]
            [jumski.breakage.helpers :refer [player-fn]]))

(comment
  (start-every-sequencing 154 #(player-fn sink midimap %))
  (stop-every-sequencing)
  )

(def sink (midi-out "USB"))

(def midimap {})
(def midimap {1 :intro  9  :synth})
(def midimap {1 :intro 2 :break1  9 :synth})
(def midimap {1 :intro 2 :break1 3 :break2 9 :synth})
(def midimap {3 :break2})

(def midimap {1 :intro  10 :synth2})
(def midimap {1 :break1 10 :synth2})
(def midimap {1 :intro  9  :synth 10 :synth2})
(def midimap {1 :break1 9  :synth 10 :synth2})
(def midimap {1 :break1 2 :intro })
(def midimap {1 :break1 2 :intro 10 :intro})
(def midimap {1 :break1 2 :intro 7 :snare:pitch 10 :intro})
(def midimap {7 :snare:pitch} )
(def midimap {7 :snare:pitch 9 :snare:pitch} )
(def midimap {8 :snare:pitch2} )
(def midimap {1 :break1 7 :snare:pitch} )
(def midimap {1 :break1 2 :intro 7 :snare:pitch} )
(def midimap {1 :break1 2 :intro 7 :snare:pitch 8 :break1 10 :snare:pitch} )
(def midimap {1 :break1 2 :intro 7 :snare:pitch 8 :break1} )
(def midimap {1 :break1 2 :intro 7 :snare:pitch 8 :break1 10 :synth2} )
(def midimap {1 :break1 2 :intro 3 :break2 7 :snare:pitch 10 :synth2} )
(def midimap {1 :break1 2 :intro 3 :break2 7 :snare:pitch 10 :intro-delayed} )
(def midimap {1 :break1 2 :intro 3 :break2 7 :snare:pitch 10 :intro-delayed} )
(def midimap {1 :break1 2 :intro 3 :break2 7 :snare:pitch 9 :synth} )
(def midimap {1 :break1 2 :intro 3 :break2 7 :snare:pitch 9 :intro-delayed} )
(def midimap {9 :intro-delayed} )
(def midimap {7 :snare:pitch 9 :snare:pitch} )
(def midimap {1 :break1 2 :intro 3 :break2  9 :snare:pitch} )
(def midimap {9 :synth})

(defpatch :snare:pitch
  :c#5    + . . . + . . . + . . . + . . .    + . . . + . 7 . + . . . + . . .
  :c#4    + . . . + . 6 . + . . . + . . .    + . . . + . . . + . . . + . . .

  :c#3    7 . . . 7 . . . + . . . + . . .    4 . . . 8 . . . + . . . + . . .    7 . . . 7 . . . + . . . + . . .    4 . . . 8 . . . + . . . + . . .
  :c3     + . . . + . . . + . . . + . . .    + . . . + . . . + . . . + . . .    + 5 . . + . . . + . . . + . . .    + . . . + . . . + . . . + . . .
  :b2     + . 7 . + . . . + . . . + . . .    + . 5 . + 3 . . + . . . + . . .    + . 5 . + . . . + . . . + . . .    + . 5 . + 3 . . + . . . + . . .
  :a#2    + . . . + . . 7 + . . . + . . .    + . . . + . . 5 + . . . + . . .    + . . . + 3 . 5 + . . . + . . .    + . . . + . . 5 + . . . + . . .
  :a2     + . . . + . . . + . . . + . . .    + . . . + . . . + . . . + . . .    + . . . + . . . + . . . + . . .    + . . . + . . . + . . . + . . .
  :g#2    + . . . + . . . + . . . + . . .    + . . . + . . . + . . . + . . .    + . . . + . . . + . . . + . . .    + . . . + . . . + . . . + . . .
  :g2     + . . . + . . . + . . . + . . .    + . . . + . . . + . . . + . . .    + . . . + . . . + . . . + . . .    + . . . + . . . + . . . + . . .
  :f#2    + . . . + . . . + . . . + . . .    + . . . + . . . + . . . + . . .    + . . . + . . . + . . . + . . .    + . . . + . . . + . . . + . . .
  :f2     + . . . + . . . 7 . . . 7 . . .    + . . . + . . . 8 . . . 5 . . .    + . . . + . . . 8 . . . 8 . . .    + . . . + . . . 8 . . . 5 . . .
  :e2     + . . . + . . . + . . . + 7 . .    + . . . + . . . + . . . + 3 . .    + . . . + . . . + 7 . . + 3 . .    + . . . + . . . + . . . + 3 . .
  :d#2    + . . . + . . . + . 7 . + . . .    + . . . + . . . + 2 3 . + . 3 .    + . . . + . . . + . 3 . + . 3 .    + . . . + . . . + 2 3 . + . 3 .
  :d2     + . . . + . . . + . . 7 + . . 7    + . . . + . . . + . . 8 + . . 5    + . . . + . . . + . . 5 + . . 8    + . . . + . . . + . . 8 + . . 5
  :c#2    + . . . + . . . + . . . + . . .    + . . . + . . . + . . . + . . .    + . . . + . . . + . . . + . . .    + . . . + . . . + . . . + . . .
  :c2     + . . . + . . . + . . . + . . .    + . . . + . . . + . . . + . . .    + . . . + . . . + . . . + . . .    + . . . + . . . + . . . + . . .
  )

(defpatch :snare:pitch
  :c#3    + . . . + . . . + . . . + . . .
  :c3     + . . . + . . . + . . . + . . .

  :b2     + . . . + . . . + . . . + . . .
          + . . . + . . . + . 7 . + . . .

  :a#2    + . . . + . . . + . . . + . . .
  :a2     + . . . + . . . + . . . + . . .
  :g#2    + 7 . . + . . . + . . . + . . .
  :g2     + . . . + . . . + . . . + . . .
  :f#2    + . . . + . . . + . . . + . . .
  :f2     + . . . + . . . + . . . + . . .
  :e2     + . . . + 6 . . 6 . . 6 + . . .
  :d#2    + . . . + . . . + . . . + . . .
  :d2     + . . . + . . . + . . . + . . .
  :c#2    + . . . + . . . + . . . + . . .

  :c2     + . . . + . . . + . . . + . . .
          + . . . + . . . + . . . + . 5 .
  )

(defpatch :break2
  :chat1     + . . . + . . . + . . . + . . .
  :chat2     + . . . + . . . + . . . + . . .
  :chat3     + . . . + . . . + . . . + . . .
  :chat4     + . . . + . . . + . . . + . . .
  :chat5     + . . . + . . . + . . . + . . .
  :kick1     + . . . + . . . + . . . + . . .
  :kick2     + . . . + . . . + . . . + . . .
  :kick3     + . . . + . . . + . . . + . . .
  :kick4     + . . . + . . . + . . . + . . .
  ;; :kick5     8 . 8 . 8 . . 8 + . . 8 + . 8 .
  :kick6     + . . . + . . . + . . . + . . .
  :snare1    + . . . + . . . + . . . + . . .
  :snare2    + . . . + . . . + . . . + . . .
  :snare3    + . . 8 + . . . + 5 . . + . . .
  :snare4    + . . . + . . . + . . . + . . .
  :snare5    + . . . + . . . + . . . + . . .
  :snare6    + . . . + . . . + . . . + . . .
  :snare7    + . . . + . . . + . . . + . . .
  :snare8    + . . . + . . . + . . . + . . .
  )
;; (defpatch :snare:pitch
;;
;;   :c3   + . . . + 7 . .
;;   :c#3  + 1 . 3 + 3 . 3 + . . 3 + 3 . 3
;;   :e2   + . . . + . . . + 1 . 2 + 3 . 4
;;
;;   :d#2  + . . 7 + . . . + . . . + . . .
;;         + . . . + . . . + . . . + . . .
;;
;;   :d2   + . . . + . . . + . . . + . . .
;;   :c2   + . 3 . + . . . + . 3 . + . . .
;;   )

(defpatch :synth2
  :e2 . 4 . . 4 . . 4
  :c3 . . . 3 . . . .
      . . . . . . . .
      . . . . . . 4 .
      . . . . . . . .
  )

(defpatch :intro-delayed
  :kick5    . 6 . 6 9 . . 6
            . . . . . . 9 .
  :snare4   . . . . . 6 . .
            . . 5 . . 6 . .
  :chat3    . . . . . . 5 .
            . . . . . . . .
            . . . . . 5 . .
            . . . . . . . .
  )

(defpatch :break1
  :kick1     8 . . . 8 . . .
  ;; :kick2     . . 6 . . . 6 .
  :chat3     . . . 1 . . . 1
  :snare1    . . . . . . . .
             . . . . . . . .
             . . . . . . . .
             . . 9 . . . . .
  :chat5     . 1 . 1 . 1 1 .
  :snare2    . . . . . . . .
             . . . . . . . .
             . . . . . . . .
             . . 2 3 4 5 6 7
  )

(defpatch :intro
  :chat1 7 . . .)

(defpatch :synth
  :e2 + . 5 . 2 . 2 . 5 . . . + . 5 . + . . . 5 . . .
      + . 5 . + . . . 5 . . 3 + . 5 . + . . . 5 . 4 .
  )

(defpatch :intro
  :kick5    9 . . . . . 1 .
            . . 9 . . . . .
  :snare4   . 1 . . 8 . . .
  :chat1    . . 2 . . . . .
            . . . . . . 2 .
            . 2 . . . . . .
            . . . . . . . 2
  :snare5   . . 3
  )

(comment
(defpatch :intro
  :e3   2 . . . 4 . . .
  ;; :f3   . 1
  :g#3  . . 4
  :c4   . . . . . . . .
        . . . . . . 4 .
  :e#3  . 3 .
  ;; :g#3  . . . . . 6
  )

(defpatch :intro
  :kick2    9 . . . . . . .
  :snare1   . . . . . 9 . .
  )

(defpatch :intro
  :kick5     6 . 3 . 8 . 4 .
  :snare1    . . . . 5 . . .   . . . . . . . .
  :snare7    . . . . . . . .   . 9 . . 9 . . 9
             . . . . . . . .   . 9 . . . . . .
  :snare8    . 9 . . 9 . . 9   . . . . . . . .
             . 9 . . . . . .   . . . . . . . .
  )

  ;; :kick1  9 . 3 9 . . 9 .
  ;;
  ;; :snare1 . . . . . 9 . .
  ;;         . . . . . 1 . .
  ;; :snare3 . . . . 5
  ;; :snare1 . . 7
  ;; :snare1 . 2 . 3 . 7 . .
  ;;         . 2 . 3 . 7 . .
  ;;         . 2 . 3 . 7 . .
  ;;         . . 5 . . 7 . .
  ;; :chat1  2 . 4 . . 3
  ;; :chat3  . . . . 4 . . .
  ;; ;; :chat3  . 2 .
  ;; ;; :chat2  . 4
  ;; :kick6
  ;;         4 4 4 4 4 . . .
  ;;         . . . . . . . .
  ;;         . . . . . . . .
  ;;         . . . . . . . .
  ;; ;; :chat1 3 2 1
  ;; ;; :csnare . 3 . 3
  ;; )
  )

(comment


  (defpatch :intro-delayed {:parser parse-drumkit :length 32}
    :kick5    . . . . 9 . . .
              . . . . . . 9 .
    :snare4   . . . . . 1 . .
              . . 2 . . 1 . .
    :chat1    . . . . . . 2 .
              . . . . . . . .
              . . . . . 2 . .
              . . . . . . . .
    )



  )
