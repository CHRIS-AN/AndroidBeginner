package re.sta.rt.Kotlin

// 23. 접근 제어자

/*
    private 은 외부에서 사용할 수 없게끔 만듭니다.
 */

fun main (array: Array<String>) {
    val testAccess : TestAccess = TestAccess("정민안")
    //testAccess.test()
//    println(testAccess.name)
//
//    testAccess.name = "아무개 투"
//    println(testAccess.name)

    val reward : Reward = Reward()
    reward.rewardAmount = 2000
    println(reward.rewardAmount)
}

class Reward() {
    var rewardAmount : Int = 1000
}

class TestAccess {
    private var name : String = "홍길동"

    constructor(name: String) {
        this.name = name
    }

    fun changName(newName:String) {
        this.name = newName
    }

    private fun test(){
        println("테스트입니다.")
    }
}