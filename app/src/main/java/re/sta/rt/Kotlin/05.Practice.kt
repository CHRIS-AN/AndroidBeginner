package re.sta.rt.Kotlin

fun plusThree (first : Int, second :Int, third :Int) : Int {
    return first + second + third
}

fun minusThree(first: Int,second: Int,third: Int) = first - second - third

fun multiplyThree (first: Int = 1, second: Int = 2, third: Int =3 ) : Int {
    return first * second * third
}


/*
    내부 함수
    - 함수 안에 함수가 있다.
 */
fun showMyPlus(first: Int, second: Int) : Int {

    println(first)
    println(second)
    fun plus ( first: Int, second: Int) : Int {
        return first + second
    }
    return plus(first,second)
}

fun main (array: Array<String>) {

    val result = showMyPlus(1,2)
    println(result)


}