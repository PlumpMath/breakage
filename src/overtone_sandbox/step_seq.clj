(ns overtone-sandbox.step-seq
  (:use [overtone.live]
        [overtone.inst.synth])
  (:require [overtone-sandbox.kit :as kit]))

(def amen (kit/load-kit "samples/amen-break"))

(def _ 0)
(def o 1)
(def k 1)
(def s 1)
(def h 1)
(def c 1)
              ;;  [X . . . X . . . X . . . X . . .]
(def pattern {:kick1  [k _ _ _ _ _ _ k _ _ k _ _ _ _ _]
          :snare1 [_ _ _ _ s _ _ _ _ _ _ _ s _ _ _]
          :chat1  [_ _ h _ _ _ h _ h _ _ _ _ _ h _]
          :csnare [_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _]})

(def metro (metronome 194))

(defn play-pattern [beat hitname]
  (let [t (mod beat 4)
        p (vec (take 4 (drop (* 4 t) (pattern hitname))))]
    (if (= 1 (p 0)) (at (metro (+ 0.00 beat)) ((amen hitname))))
    (if (= 1 (p 1)) (at (metro (+ 0.25 beat)) ((amen hitname))))
    (if (= 1 (p 2)) (at (metro (+ 0.50 beat)) ((amen hitname))))
    (if (= 1 (p 3)) (at (metro (+ 0.75 beat)) ((amen hitname))))))

(defn player [beat]
  (doseq [hitname (keys pattern)] (play-pattern beat hitname))
  (apply-at (metro (inc beat)) #'player (inc beat) []))

(stop)
(player (metro))
