(ns jumski.breakage.midifile
  (:import (java.io File)
           ;(java.util)
           (javax.sound.midi Sequence SysexMessage MidiEvent MetaMessage MidiSystem ShortMessage)))

  (let [midiseq   (Sequence. Sequence/PPQ 24)
        track     (.createTrack midiseq)

        sysex-msg (let [bts (byte-array [0xF0 0x7E 0x7F 0x09 0x01 0xF7])]
                    (doto (SysexMessage.) (.setMessage bts 6)))

        mm-tempo  (let [bts (byte-array [0x02 0x00 0x00])]
                    (doto (MetaMessage.) (.setMessage 0x51 bts 3)))

        file      (File. "midifile.mid")

        note-on1  (let [sm (doto (ShortMessage.) (.setMessage 0x90 0x3C 0x60))]
                    (MidiEvent. sm 0))

        note-off1 (let [sm (doto (ShortMessage.) (.setMessage 0x80 0x3C 0x40))]
                    (MidiEvent. sm 120))

        note-on2  (let [sm (doto (ShortMessage.) (.setMessage 0x90 0x3D 0x60))]
                    (MidiEvent. sm 0))

        note-off2 (let [sm (doto (ShortMessage.) (.setMessage 0x80 0x3D 0x40))]
                    (MidiEvent. sm 120))
        ]
    (.add track note-on1)
    (.add track note-off1)
    (.add track note-on2)
    (.add track note-off2)
    (MidiSystem/write midiseq 1 file)
        )
  ;; ;  note on - middle C  ****
  ;; mm = new ShortMessage();
  ;; mm.setMessage(0x90,0x3C,0x60);
  ;; me = new MidiEvent(mm,(long)1);
  ;; t.add(me);
  ;;
  ;; ;  note off - middle C - 120 ticks later  ****
  ;; mm = new ShortMessage();
  ;; mm.setMessage(0x80,0x3C,0x40);
  ;; me = new MidiEvent(mm,(long)121);
  ;; t.add(me);

;; MetaMessage mt = new MetaMessage();
;; byte[] bt = {0x02, (byte)0x00, 0x00};
;; mt.setMessage(0x51 ,bt, 3);
;; me = new MidiEvent(mt,(long)0);
;; t.add(me);
;;
;; ;  set track name (meta event)  ****
;; mt = new MetaMessage();
;; String TrackName = new String("midifile track");
;; mt.setMessage(0x03 ,TrackName.getBytes(), TrackName.length());
;; me = new MidiEvent(mt,(long)0);
;; t.add(me);
;;
;; ;  set omni on  ****
;; ShortMessage mm = new ShortMessage();
;; mm.setMessage(0xB0, 0x7D,0x00);
;; me = new MidiEvent(mm,(long)0);
;; t.add(me);
;;
;; ;  set poly on  ****
;; mm = new ShortMessage();
;; mm.setMessage(0xB0, 0x7F,0x00);
;; me = new MidiEvent(mm,(long)0);
;; t.add(me);
;;
;; ;  set instrument to Piano  ****
;; mm = new ShortMessage();
;; mm.setMessage(0xC0, 0x00, 0x00);
;; me = new MidiEvent(mm,(long)0);
;; t.add(me);
;;
;; ;  note on - middle C  ****
;; mm = new ShortMessage();
;; mm.setMessage(0x90,0x3C,0x60);
;; me = new MidiEvent(mm,(long)1);
;; t.add(me);
;;
;; ;  note off - middle C - 120 ticks later  ****
;; mm = new ShortMessage();
;; mm.setMessage(0x80,0x3C,0x40);
;; me = new MidiEvent(mm,(long)121);
;; t.add(me);
;;
;; ;  set end of track (meta event) 19 ticks later  ****
;; mt = new MetaMessage();
;; byte[] bet = {}; // empty array
;; mt.setMessage(0x2F,bet,0);
;; me = new MidiEvent(mt, (long)140);
;; t.add(me);
;;
;; ;  write the MIDI sequence to a MIDI file  ****
;; File f = new File("midifile.mid");
;; MidiSystem.write(s,1,f);

