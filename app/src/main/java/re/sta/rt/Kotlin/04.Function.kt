package re.sta.rt.Kotlin

/*
    04. Function
    - 함수
    어떤 input을 넣어주면 어떤 output이 나오는 것
    y = x +2

    - 함수를 선언하는 방법
    fun 함수명 (변수명 : 타입, 변수명: 타입 ...) : 반환형 {


        * 구현부

        return 반환값
    }

 */

fun plus(first: Int, second: Int): Int {
    println(first)
    println(second)
    println("------")
    val result: Int = first + second

    return result

}


/*
    디폴트 값을 갖는 함수 만들기
 */
fun plusFive(first: Int, second: Int = 5): Int {
    val result: Int = first + second
    return result
}


/*
    반환값이 없는 함수 만들기
 */
fun printPlus(first: Int, second: Int): Unit { // Unit 이라는 글자는 생략도 가능하고, 이렇게 적어 줄시  return 값이 없다.
    val result: Int = first + second
    println(result)
}

fun printPlus2(first: Int, second: Int) {
    val result: Int = first + second
    println(result)
}


/*
    간단하게 함수를 선언하는 방법
 */
fun plusShort(first: Int, second: Int) = first + second


/*
    가변인자를 갖는 함수 선언하는 방법
 */
fun plusMany(vararg numbers:Int) {
    for (number in numbers)
        println(number)
}


fun main(array: Array<String>) {
    val result = plus(1, 10)
    val result2 = plus(second = 30, first = 20) // 매개변수의 순서를 받고싶다면? 이렇게 사용할 수 있다.
    println(result)


    // 디폴트
    println("--디폴트--")
    val result4 = plusFive(10, 20)
    println(result4)
    val result5 = plusFive(10)  // 이 것이 디폴트 값 적용 함수이다.
    println(result5)

    println()
    val resultPlusShort = plusShort(10, 20)
    println(resultPlusShort)

    println()
    plusMany(1,2,3,4,5,6)


}