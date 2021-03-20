package re.sta.rt.Kotlin

fun main (array: Array<String>) {

    // 클래스(설명서)를 통해서 실체를 만드는 방법
    // 이것을 인스턴스라고하고, 이것을 만드는 과정을 인스턴스화라고 한다.
    Car("v8 engine", "big")
    var bigCar = Car("v8 engine", "big")
    // 우리가 만든 클래스(설명서)는 자료형이 될 수 있다.
    var bigCar1 : Car = Car("v8 engine", "big")

    val superCar : SuperCar = SuperCar("good engine", "big", "white")

    val runableCar : RunableCar = RunableCar("simple engine", "good body")
    runableCar.drive()
    runableCar.navi("부산")

    val runableCar2 : RunableCar2 = RunableCar2("nice engine", "short body")
    runableCar2.drive()

    println()

    val testClass = TestClass()
    testClass.test(1)
    testClass.test(1,2)

}
// 클래스 (설명서) 만드는 방법(1)
class Car (var engine : String, var body : String) {

}
// 클래스 (설명서) 만드는 방법(2)
class SuperCar {
    var engine: String
    var body: String
    var door: String

    constructor(engine: String, body: String, door: String) {
        this.engine = engine
        this.body = body
        this.door = door
    }
}
// 클래스(설명서) 만드는 방법(3) -> 1번 방법의 확장
class Car1(engine : String, body : String) {
    var door: String = ""

    // 생성자 (조립하는 것)
    constructor(engine: String, body: String, door: String) : this(engine, body) {
        this.door = door
    }
}

class Car2 {
    var engeine : String = ""
    var body : String = ""
    var door : String = ""

    constructor(engeine: String, body: String) {
        this.engeine = engeine
        this.body = body
    }

    constructor(engeine: String, body: String, door: String) {
        this.engeine = engeine
        this.body = body
        this.door = door
    }
}


class RunableCar(engine: String, body: String) {
    fun ride() {
        println("탑승 하였습니다.")
    }

    fun navi(destination : String) {
        println("$destination 으로 목적지가 설정되었습니다.")
    }

    fun drive() {
        println("달립니다 !")
    }
}

class RunableCar2 {
    var engine : String
    var body : String

    constructor(engine: String, body: String) {
        this.engine = engine
        this.body = body
    }

    init {
        // 초기세팅하기에 유용하다.
        println()
        println("RunableCar2가 가장 먼저 호출됩니다.")
    }

    fun ride() {
        println("탑승 하였습니다.")
    }

    fun navi(destination : String) {

        println("$destination 으로 목적지가 설정되었습니다.")
    }

    fun drive() {
        println("달립니다 !")
    }
}


// 오버로딩
// 이름이 같지만 받는 파라미터가 다른 함수
class TestClass() {
    val a : Int = 10
    fun test(a: Int) {
        println("UP")
    }
    fun test(a: Int, b: Int) {
        println("DOWN")
    }
}