package re.sta.rt.Kotlin

fun main(array: Array<String>) {

    // 배열을 생성하는 방법(1)
    var number: Int = 1
    var group1 = arrayOf<Int>(1, 2, 3, 4, 5)
    println(group1 is Array)


    // 배열을 생성하는 방법(2)
    var number1 = 10
    var group2 = arrayOf(1, 2, 3, 4, 5)
    var group3 = arrayOf(1, 2, 3, 4, 5, "123") // 여러가지 타입이 들어가는 방법은 좋은 방법은 아니다.

    // Index란? - > 순서(번째) , "0"부터 수가 시작한다.


    // 배열의 값을 꺼내는 방법(1)
    val test1 = group1.get(0)
    println(test1)

    // 배열의 값을 꺼내는 방법(2)
    val test2 = group1[3]
    println(test2)

    // 배열의 값을 바꾸는 방법(1)
    val test3 = group1.set(0, 100)
    println(test3)

    // 배열의 값을 바꾸는 방법(2)
    group1[0] = 200
    val test4 = group1[0]
    println(test4)
}