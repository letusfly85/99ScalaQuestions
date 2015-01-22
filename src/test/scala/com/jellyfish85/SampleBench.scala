package com.jellyfish85

import org.scalameter.api._

object SampleBench
extends PerformanceTest.Microbenchmark {
    def mySum(list: List[Int]): Int = {
        
        def mySum_(acc: Int, _list: List[Int]): Int = _list match {
            case (x :: xs)  => mySum_((x + acc), xs)
            case Nil => acc
        }

        mySum_(0, list)
    }

    val ranges = for {
        //size <- Gen.range("size")(300000, 1500000, 300000)
        size <- Gen.range("size")(3000, 15000, 3000)
    } yield 0 until size

    measure method "map" in {
        using(ranges) curve("Range") in {
            _.map(_ + 1)
        }
    }

    val list = for {
        //Gen.enumeration[T](axis: String)(xs: T*) 
        size <- Gen.enumeration("list")(List(1,2,3,4,5), List(2,1,2,3,4,5,6,3,2,4,5,6,3,2,34,4,5,3,4,5,3,2,34))
    } yield List(0)

    measure method "mySum" in {
        using(list) curve("List") in {
            mySum(_)
        }
    }
}
