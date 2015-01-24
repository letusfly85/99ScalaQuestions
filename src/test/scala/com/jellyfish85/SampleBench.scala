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

    def pack[T](list: List[T]):List[List[T]] = {
        def recur(elem: T, acc: List[List[T]]): List[List[T]] = {
            acc match {
                case x :: xs if (elem == x(0)) => (elem::x) :: acc.drop(1)
                case _ => List(elem) :: acc
            }
        }

        var initList: List[List[T]] = List()
        list.foldRight(initList)((elem, acc) => recur(elem, acc))
    }

   val sizes = Gen.range("size")(0, 10000, 1000)
   val lists = for (sz <- sizes) yield (0 until sz).toList

    measure method "mySum" in {
        using(lists) in {
            mySum(_)
        }
    }

    measure method "pack" in {
        using(lists) in {
            pack(_)
        }
    }
}
