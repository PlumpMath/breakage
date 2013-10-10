(ns overtone-sandbox.step-seq
  (:use [overtone.live]
        [overtone.inst.synth]))

(def kick   (sample "samples/amen-break/kick1.wav"))
(def snare  (sample "samples/amen-break/snare2.wav"))
(def hat    (sample "samples/amen-break/chat2.wav"))
(def csnare (sample "samples/amen-break/csnare.wav"))
(def insts {:kick   kick
            :snare  snare
            :hat    hat
            :csnare csnare})
(def _ 0)
(def o 1)
(def k 1)
(def s 1)
(def h 1)
(def c 1)
              ;;  [X . . . X . . . X . . . X . . .]
(def pat {:kick   [k _ _ _ _ _ _ _ _ _ k _ _ _ _ _]
          :snare  [_ _ _ _ s _ _ _ _ _ _ _ s _ _ _]
          :hat    [_ _ h _ _ _ h _ h _ _ _ _ _ h _]
          :csnare [_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _]})

(def metro (metronome 194))

(defn play-pat [beat i]
  (let [t (mod beat 4)
        p (vec (take 4 (drop (* 4 t) (pat i))))]
    (if (= 1 (p 0)) (at (metro (+ 0.00 beat)) ((insts i))))
    (if (= 1 (p 1)) (at (metro (+ 0.25 beat)) ((insts i))))
    (if (= 1 (p 2)) (at (metro (+ 0.50 beat)) ((insts i))))
    (if (= 1 (p 3)) (at (metro (+ 0.75 beat)) ((insts i))))))

(defn player [beat]
  (doseq [i (keys insts)] (play-pat beat i))
  (apply-at (metro (inc beat)) #'player (inc beat) []))

(stop)
(player (metro))

;; (metro :bpm 160)
;; (metro :bpm 90)

;; (defn player [beat] "stop")
