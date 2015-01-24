package com.jellyfish85

@serializable
class P09 {

    /*
    def pack[T](list: List[T]):List[(Int, T)] = {
        def recur(elem: T, acc: List[(Int, T)]): List[(Int, T)] = {
            acc match {
                case x :: xs if (elem == x._2) => (x._1 + 1, elem) :: acc.drop(1)
                case x :: xs => (1, elem) :: acc
                case Nil => List((1, elem))
            }
        }

        var initList: List[(Int, T)] = List()
        list.foldRight(initList)((elem, acc) => recur(elem, acc))
    }
    */
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
}
