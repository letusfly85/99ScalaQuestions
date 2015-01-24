package com.jellyfish85

import org.scalameter.api._

class P09Bench extends PerformanceTest.Microbenchmark {
   val p09 = new P09()

   val sizes = Gen.range("size")(0, 10000, 1000)
   val lists = for (sz <- sizes) yield (0 until sz).toList
   measure method "pack" in {
       using(lists) in {
           p09.pack(_)
        }
    }
}
