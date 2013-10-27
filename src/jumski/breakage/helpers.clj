(ns jumski.breakage.helpers)

(def _ nil)

(defn split-on-keyword
  "Splits input sequence when approched a keyword"
  [patt]
  (->> patt
       (partition-by keyword?)
       (partition 2)
       concat
       (map #(apply concat %))
       (map vec)
       vec))

(defn fill-with-blanks
  "Appends _ at the end of aseq and returns new sequence of length len"
  [len aseq]
  (let [aseq (if (nil? aseq) [] aseq)]
    (->> (repeat _) (concat aseq) (take len))))

(defn fixed-length
  "Fills all the seqs with _ up to the length of len"
  [len seqs]
  (map (partial fill-with-blanks len) seqs))

;; (defn make-same-length
;;   "Finds longest track and cycles the rest to make all have same length"
;;   [seqs]
;;   (let [maxlen (apply max (map count seqs))]
;;     (map #(take maxlen (cycle %)) seqs)
;;     ))

(defn find-maxlength
  "Returns maximum velocity/pitch length for a given pattern slice"
  [slice]
  (->>
    (for [[_ & vp] slice] (map count vp))
    flatten
    (apply max)))

(defn make-beat
  "For a given pattern pat outputs a map where keys are hit names
  and values are maps of velocities and pitches mapped to sequences of values"
  [pat]
  (->>
    (let [splitted (split-on-keyword pat)
          maxlength (find-maxlength splitted)]
      (for [[hitname vel pit] splitted]
        (let [[vel pit] (fixed-length maxlength [vel pit])]
          [hitname (map (fn [v p] {:vel v :pit p}) vel pit)])))
    (mapcat concat)
    (apply hash-map)))




