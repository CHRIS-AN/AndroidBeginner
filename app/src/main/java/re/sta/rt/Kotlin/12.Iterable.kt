package re.sta.rt.Kotlin

fun main(array: Array<String>) {

     val a = mutableListOf<Int>(1,2,3,4,5,6,7)

    // 반복하는 방법(1)

    for(item in a) {
        if(item == 5) {
            println("item is Five")
        }else {
            println("item is not Five")
        }
    }

    println()

    // 반복하는 방법(2)
    for((index, item) in  a.withIndex()) {
        println("index : " + index + ", value : " + item);
    }


}