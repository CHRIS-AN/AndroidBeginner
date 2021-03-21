package re.sta.rt.Kotlin

fun main (array: Array<String>) {
    val night : Night = Night (20,4)
    val monster : Monster = Monster(15, 3)


    night.attack(monster)
    monster.attack(night)
    monster.attack(night)

    monster.attack(night)
    monster.attack(night)
    monster.attack(night)
    monster.attack(night)


}

class Night (private var hp : Int, private var power : Int) {
    fun attack(monster: Monster) {
        monster.defense(power)
    }
    fun defense(demage: Int) {
        hp-=demage
        println(hp)
        if( hp > 0) {
            println("기사 현재 체력은 $hp 입니다.")
        }else if ( hp <= 5) {
            println("heal 을 시현했습니다. 체력이 +3이 됩니다.")
            heal()
        } else println("기사가 죽었습니다.")
    }
    private fun heal() {
        println(hp)
        hp += 3
        var count : Int = 0
        count++
        println("현재 체력은 : $hp 가 되며, heal을 $count 번 시현했습니다.")
    }
}

class Monster(private var hp :Int, private var power : Int) {
    fun attack(night: Night) {
        night.defense(power)
    }
    fun defense(demage: Int) {
        hp-=demage
        if( hp > 0) println("몬스터 현재 체력은 $hp 입니다.")
        else println("몬스터가 죽었습니다.")
    }

}