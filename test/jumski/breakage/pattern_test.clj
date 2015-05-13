(ns jumski.breakage.pattern-test)
(use 'clojure.test)
(use 'midje.repl)
(require '[jumski.breakage.pattern :as p] :reload)

(defn mkdummy [len]
  (take len (iterate inc 0)))

(facts "beat-to-play cycles a pattern and selects proper beat"
  (p/beat-to-play 1 (mkdummy 8)) => [0 1 2 3]
  (p/beat-to-play 9 (mkdummy 8)) => [0 1 2 3]
  (p/beat-to-play 2 (mkdummy 8)) => [4 5 6 7]
  (p/beat-to-play 10 (mkdummy 8)) => [4 5 6 7])

(fact "split-on-keyword returns list of lists splitted on keyword"
  (p/split-on-keyword [:k 1 2 :s 3]) => [[:k 1 2] [:s 3]])

(fact "cycle-to-same-length cycles all collections to equal size"
  (p/cycle-to-same-length [1 2 3 4] [9 7 8] [1])
    => [[1 2 3 4] [9 7 8 9] [1 1 1 1]])

(fact "cycle-to-same-length treats nils as list with single nil"
  (p/cycle-to-same-length [1 2] nil)
    => [[1 2] [nil nil]])

(fact "force-same-length"
  (p/force-same-length [1 2] [1]) => [[1 2] [1 nil]])

(fact "make-pattern extracts tracks and merges them"
      (p/make-pattern .flat.) => .merged.
      (provided
        (p/make-tracks .flat.) => [.trk1. .trk2.]
        (p/merge-tracks .trk1. .trk2.) => .merged.))

(fact "make-tracks normalizes tracks and returns list of tracks"
      (p/make-tracks .flat.) => [.map1. .map2.]
      (provided
        (p/normalize-tracks .flat.) => [.trk1. .trk2.]
        (p/make-track .trk1.) => .map1.
        (p/make-track .trk2.) => .map2.))

(fact "merge-tracks concatenates all steps when mergind"
      (p/merge-tracks {:k [1 2] :s [9 8]} {:s [7 6] :h [5 5]})
        => {:k [1 2] :s [9 8 7 6] :h [5 5]})

(fact "normalize-tracks splits tracks and makes all velocities same length"
      (p/normalize-tracks .flat.) => [[.k1. .nv1. .p1.]
                                      [.k2. .nv2. .p2.]]
      (provided
        (p/split-on-keyword .flat.) => [[.k1. .v1. .p1.]
                                        [.k2. .v2. .p2.]]
        (p/cycle-to-same-length .v1. .v2.) => [.nv1. .nv2.]))

(fact
  "make-track builds a map of hit to steps"
  (p/make-track [.hit. .vels. .pits.]) => {.hit. .steps.}
  (provided
    (p/build-steps .vels. .pits.) => .steps.))

(fact
  "build map of velocities and pitches to its values"
  (p/build-steps [.v1. .v2.] [.p1.])
    => [{:v .v1. :p .p1.} {:v .v2. :p .p1.}]
  (provided
    (p/cycle-to-same-length [.v1. .v2.] [.p1.])
      => [[.v1. .v2.] [.p1. .p1.]]))

(fact
  "make-pattern works on real data"
  (p/make-pattern [:k [1 2 3 4] [1 2] :s [4 5 6] [9 8]])
    => {:k [{:v 1 :p 1} {:v 2 :p 2}
            {:v 3 :p 1} {:v 4 :p 2}]
        :s [{:v 4 :p 9} {:v 5 :p 8}
            {:v 6 :p 9} {:v 4 :p 8}]})

(facts
  "bugs"
  (p/make-pattern [:kick1 [5 nil nil nil nil nil nil nil]])
    => {:kick1 (take 8 (concat [{:v 5 :p nil}] (repeat {:v nil :p nil})))}

  (p/make-pattern [:kick1 [5 nil] :snare [1]])
    => {:kick1 [{:v 5 :p nil} {:v nil :p nil}]
        :snare [{:v 1 :p nil} {:v 1 :p nil}]})

(require '[jumski.breakage.pattern :as p] :reload)
