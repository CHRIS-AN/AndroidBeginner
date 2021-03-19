package re.sta.rt.Kotlin

fun main(array: Array<String>) {

    val array = arrayOf(1,2,3)
    //val arrayDiff = arrayOf<Int>(1,2,3)


    // get, set

    // Array를 만드는 방법(1)
    val number = array.get(0)
    println(number)
//    val number1 = array.get(100)
 //   println(number1)

    // Array를 만드는 방법(2)
    array.set(0, 100)
    val setNum = array.get(0)
    println(setNum)

    // array.set(100, 100) ????
    // Array 의 Bounds는 처음 만들 때 결정된다 !

    // Array를 만드는 방법(3)
    val a1 = intArrayOf(1, 2, 3)
    //val a2 = intArrayOf("hello")
    val a2 = charArrayOf('n','b')
    val a3 = doubleArrayOf(1.2 , 100.32)
    val a4 = booleanArrayOf(true, false, true)

    // Array를 만드는 방법(4) -> lambda를 활용한 방법
    var a5 = Array(10, {0})
    var a6 = Array(5, {1;2;3;4;5})

}