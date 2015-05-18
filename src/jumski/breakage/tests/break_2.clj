(ns jumski.breakage.tests.break-2)

(comment


  (defpatch :drums/base
    :kick1    6 . . . 6 . . .
    :snare1   . . 4 . . . . 4
    )

  (defpatch :drums/fast
    {:resolution 1/32}
    )

  (defpatch :bass/intro
    :c#2      . 6 . . . . . .
    :g#2      . . . 3 . 3 . 3
    )

  (defpattern :intro
    0 :drums/base
    9 :bass/intro)

  (defpattern :breakdown
    9  :bass/intro
    10 :pad/breakdown)

  (defpattern :break1
    0 :drums/main
    1 :hats/fast
    9 :bass/main
    10 :pad/main)

  (defpattern :break2
    0 :drums/rolled
    1 :hats/fast
    9 :bass/main
    10 :pad/main)

  (defpattern :outro
    1  :hats/slow
    10 :pad/main)

  (defchain :song
    :intro :intro :intro :intro
    :breakdown :breakdown
    :break1 :break2 :break1 :break2 :break1 :break2 :break1 :break2
    :outro :outro :outro :outro)































  )
