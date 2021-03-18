package re.sta.rt.Kotlin

// 10 제어흐름
// When


fun main(args : Array<String>) {
    val value : Int = 3

    when(value) {
        1 ->println("value is 1")
        2 ->println("value is 2")
        3 ->println("value is 3")
        else -> println("I do not know value")
    }


    val value2 = when (value) {
        1->10
        2->20
        3->30
        else->100
    }

    println(value2)

// WHEN 의 다양한 조건식(1)
    val value4: Int = 10
    when(value4) {
        is Int -> {
            println("value4 is int")
        }
        else -> {
            println("value4 is not int")
        }
    }
// WHEN 의 다양한 조건식(2)
    val value5 : Int = 87
    when(value5) {
        in 60..70 -> {
            println("value is in 60...70")
        }
        in 70..80 -> {
            println("value is in 70...80")
        }
        in 80..90 -> {
            println("value is in 80...90")
        }
    }



}