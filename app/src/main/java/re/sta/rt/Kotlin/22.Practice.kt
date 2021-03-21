package re.sta.rt.Kotlin

/*
    Mission

Night, Monster (부모)
SuperNight, SuperMonster (자식)

 */

fun main(array: Array<String>) {
    val monster = SuperMonster(100, 10)
    val night = SuperNight(130,8)
    monster.attack(night)
    monster.bite(night)
}

open class Charator(var hp :Int, val power: Int) {
    open fun attack(charator: Charator, power: Int = this.power) {
        charator.defence(power)
    }
    open fun defence(damage : Int) {
        hp -= damage
        if(hp > 0) println("${javaClass.simpleName}의 남은 체력 $hp 입니다.")
        else println("사망 했습니다.")
    }
}
// 자식 클래스가 인스턴스화 되기 위해서 부모 클래스 선행되서 인스턴스화 되어야한다.
class SuperMonster(hp : Int, power: Int) : Charator(hp, power) {
    fun bite(charator : Charator) {
        super.attack(charator, power + 2)
    }
}

class SuperNight(hp : Int, power: Int) : Charator(hp,power) {
    val defensePower = 2
    override fun defence(damage: Int) {
        super.defence(damage - defensePower)
    }
}