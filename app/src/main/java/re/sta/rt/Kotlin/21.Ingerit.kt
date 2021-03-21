package re.sta.rt.Kotlin


/*
    21. 상속
 */

fun main(array: Array<String>) {
    val superCar100 : SuperCar100 = SuperCar100()
    println(superCar100.drive())
    superCar100.stop()

    val bus100 : Bus100 = Bus100()
    //bus100.driver()
}

open class Car100() {
    open fun drive() : String {
        return "달린다"
    }
    fun stop(){

    }
}

// 상속 o
class SuperCar100() : Car100(){
    override fun drive() : String {
        val run = super.drive()
        return  "빨리 $run"
    }
}
// 상속 x
class Bus100() {

}