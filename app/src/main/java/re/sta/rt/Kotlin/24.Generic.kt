package re.sta.rt.Kotlin

/*
    Generic (제너릭)
    목적? 다양한 타입의 객체들을 다루는 메서드나 컬렉션 class에서 컴파일 시에 타입을 check하는 기능이다.


    제너릭은 만들기 어렵고, 실제로 만들일 거의 없어서 사용하는 방법만 숙지한다.
 */

fun main(args : Array<String>) {
    // 제너릭을 사용하지 않은 경우
    val list1 = listOf(1, 2, 3, "안안")
    val b: String = list1[2].toString() // 형병환 (타입 변환)

    // 제너릭을 사용하는 경우 -> 타입이 안정하다. (캐스팅을 하지 않아도 됨)
    val list2 = listOf<String>("a", "b", "c")
    val c: String = list2[2]

    // 강한 타입을 체크할 수 있다.
    val list3 = listOf(1,2,3,4,"가","나",3.0)
    //val list4 = listOf<Int>(1,2,3,"가") syntax오류. //강한타입으로 인해 error

    // 제너릭을 사용하지 않은 경우
    val list5 = listOf(1,2,3,"가") // -> Any 아무거나.......
    /*
        따라서,
        부모 : Any
        자식 : String, Int, Float
     */

}