package re.sta.rt.Kotlin

fun main(array: Array<String>) {
    val member1 : Member1 = Member1()
    member1.sleep()

    val member2 : Member2 = Member2()
    member2.study()
}




interface  Perseon_ {
    fun eat() {
        println("나 먹는다")
    }
    fun sleep() {
        println("나 잔다")
    }
    abstract fun study()
}

class Member1() : Perseon_ {
    override fun study() {
        TODO("Not yet implemented")
    }

}

class Member2() : Perseon_{
    override fun study() {
        println("이건 걍 abstract 쪽이야..")
    }

}