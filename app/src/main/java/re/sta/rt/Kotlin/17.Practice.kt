package re.sta.rt.Kotlin

fun main(array: Array<String>) {

    val channels = listOf<String>("K", "M", "S")
    val tv = TV(channels)
    println(tv.onOff)
    tv.switch()
    println(tv.onOff)

    tv.channelUp()
    println(tv.checkCurrentChannel())
    tv.channelDown()
    println(tv.checkCurrentChannel())
    tv.channelUp()
    println(tv.checkCurrentChannel())
    tv.channelUp()
    println(tv.checkCurrentChannel())
    tv.channelUp()
    println(tv.checkCurrentChannel())
    tv.channelDown()
    println(tv.checkCurrentChannel())
    tv.channelDown()
    println(tv.checkCurrentChannel())
    tv.channelDown()
    println(tv.checkCurrentChannel())
    tv.channelDown()
    println(tv.checkCurrentChannel())
    tv.channelDown()
    println(tv.checkCurrentChannel())

}

//class TV(val first : String, val second : String, val third : String) {}
class TV(val channels : List<String>) {

    var onOff : Boolean = false     //ture -> on false -> off
    var curruntChannelNumber = 0
        set(value) { // 변수를 할당할 때, 또는 할당 받을 때. 사용을 하게 된다.
            field = value
            if(field > 2) {
                field = 0
            }
            if(field < 0) {
                field = 2
            }
        }
        get() { // 변수를 불려 나갈 때
            println("호출되었습니다.")
            return field
        }

    fun switch() {
        onOff = !onOff
    }


    fun checkCurrentChannel() : String {
        return channels[curruntChannelNumber]
    }

    fun channelUp() {
        curruntChannelNumber = curruntChannelNumber + 1
//        channels.forEachIndexed { index, value ->
//            if(curruntChannelNumber == index) {
//                curruntChannelNumber = curruntChannelNumber + 1
//                return
//            }
//        }
    }

    fun channelDown() {
        curruntChannelNumber = curruntChannelNumber - 1
//        channels.forEachIndexed { index, value ->
//            if(curruntChannelNumber == index) {
//                curruntChannelNumber = curruntChannelNumber - 1
//                return
//            }
//        }
    }
}