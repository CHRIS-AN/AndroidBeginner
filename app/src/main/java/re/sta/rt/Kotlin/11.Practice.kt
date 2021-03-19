package re.sta.rt.Kotlin

fun main (array : Array<String>) {

    val a= mutableListOf<Int>(1, 2, 3)
    a.add(4)
    println(a)
    // add를 사용했을 때, add의 인자로 들어간 index에 값이 있을 경우에
    // 우측으로 값을 밀고 index에 값을 넣습니다.
    a.add(0, 100)
    println(a)

    // set을 사용할 때는, index에 값을 변경을 해준다.
    a.set(0,200)
    println(a)

    a.removeAt(1)
    println(a)


    println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■")

    val b = mutableSetOf<Int>(1, 2, 3, 4)
    println()
    b.add(7)
    println(b)
    b.remove(2)
    println(b)

    // * 없는 값을 집합에서 삭제를 하려해도, 에러는 나지 않습니다
    b.remove(100)
    println(b)

    println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■")

    val c = mutableMapOf<String, Int>("one" to 1)
    println()
    c.put("two", 2)
    println(c)
    c.replace("two", 3)
    println(c)
    println(c.keys)
    println(c.values)
    c.clear()
    println(c)

}