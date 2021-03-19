package re.sta.rt.Kotlin

/*
    14. Collection
    <종류>
    1. list
    2. set
    3. map


 */


fun main (args: Array<String>) {

    // Immutable Collections : 변경 불가능
    // List ( 중복 허용 )
    val numberList = listOf<Int>(1, 2, 3)
    println(numberList)
    println(numberList.get(0))
    println(numberList[0])

    println("■■■■■■■■■■■■■■■■■■■")
    // Set ( '집합' 은 동일 값을 허용하지 않습니다 ,
    //        순서가 없다. 따라서, get()을 사용x    )
    val numberSet = setOf<Int>(1, 2, 3, 2, 3, 4)
    println(numberSet)
    println()
    numberSet.forEach{
        println(it)
    }


    println("■■■■■■■■■■■■■■■■■■■")
    // Map ( key : value 방식으로 관리를 한다 )
    val numberMap = mapOf<String, Int>("one" to 1, "two" to 2)

    println(numberMap.get("one"))





    // Mutable Collection : 변경 가능

    val mNumberList = mutableListOf<Int>(1, 2, 3)
    mNumberList.add(3, 10)
    println()
    println(mNumberList)

    val mNumberSet = mutableSetOf<Int>(1, 3, 3, 2, 1,2, 4, 5)
    mNumberSet.add(10)
    println(mNumberSet)

    val mNumberMap = mutableMapOf<String, Int>("one" to 1)
    mNumberMap.put("two", 2)
    println()
    println(
        mNumberMap
    )


}