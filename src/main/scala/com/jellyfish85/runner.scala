package com.jellyfish85

@serializable
trait Runner {
    val list = List('a, 'a, 'b, 'b, 'b, 'c, 'd, 'd, 'e, 'e, 'e, 'e)
    
    def run(function:(List[Symbol] => Unit)) {
        function(list)
    }
}
