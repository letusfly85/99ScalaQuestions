package com.jellyfish85

import org.scalameter.api._

class P09Bench extends PerformanceTest {
   lazy val executor  = LocalExecutor(new Executor.Warmer.Default, Aggregator.min, new Measurer.Default)
   lazy val persistor = Persistor.None
   lazy val reporter  = Reporter.Composite(
         new RegressionReporter(
                     RegressionReporter.Tester.OverlapIntervals(),
                     RegressionReporter.Historian.ExponentialBackoff()
                 ),
                 HtmlReporter(true)
               )
   //lazy val reporter = new LoggingReporter
   //lazy val reporter = ChartReporter(ChartFactory.XYLine())
   
   val p09 = new P09()

   val sizes = Gen.range("size")(0, 100000, 10000)
   val lists = for (sz <- sizes) yield (0 until sz).toList
   measure method "pack" in {
       using(lists) in {
           p09.pack(_)
        }
    }
}
