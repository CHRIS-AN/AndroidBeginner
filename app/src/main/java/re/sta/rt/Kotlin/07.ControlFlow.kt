package re.sta.rt.Kotlin

fun main (array: Array<String>) {
    val a : Int = 5
    val b : Int = 10


    if(a > b) {

    }else {

    }


    if(a > b) {

    }else if(a == b) {

    }else {

    }

    // 값을 리턴하는 if 사용 방법 !

    val max = if(a>b) {
        a
    }else {
        b
    }

    val maxAnother = if(a<b) a else b

    println(max)
    println(maxAnother)

}