package re.sta.rt.Kotlin

var number100 : Int = 10

fun main (array: Array<String>) {
    println(number100)

    val test = Test("gil dong hong")  // 클래스를 통해 실체화를 시킨다.
    test.testFun()
    test.name

    println(number100)
}

class Test(var name : String) {

    fun testFun() {
        var birth : String = "2000/3/1"
        name = "hong gil dong"
        number100 = 100
        fun testFun2() {
            var gener : String = "male"
        }
    }

}