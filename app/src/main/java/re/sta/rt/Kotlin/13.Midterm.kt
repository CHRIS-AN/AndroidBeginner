package re.sta.rt.Kotlin

fun main(array: Array<String>) {
    first()
    println(second(89))
    gugudan()
}

fun first() {
    var list1 = MutableList(9, { 0 })
    val list2 = MutableList(9, { true })

    for (i in 0..8) {
        list1[i] = i + 1
    }
    println(list1)

    list1.forEachIndexed { i, value ->
        if (value % 2 == 0) {
            // 짝수
            list2[i] = true
        } else {
            // 홀수
            list2[i] = false
        }
    }
    println(list2)
}


fun second (score : Int) : String {
    when(score) {
        in 90..100 -> {
            return "A"
        }
        in 80..89 -> {
            return "B"
        }
        in 70..79 -> {
            return "C"
        }
        else -> {
            return "F"
        }
    }
}


fun thrid (number : Int) : Int {
    var a : Int = number / 10
    var b : Int = number % 10

    return a+b
}

fun gugudan() {
    for(x in 1..9) {

        for (y in 1..9) {
            println("$x x $y = ${x*y}")
        }
    }
}