package com.jellyfish85

object Q99 extends Runner {
    def main(args: Array[String]) {
        def e09(list: List[Symbol]) = (new P09).pack(list).foreach(println)
        run(e09)

        def e10(list: List[Symbol]) = (new P10).encode(list).foreach(println)
        run(e10)
    }
}
