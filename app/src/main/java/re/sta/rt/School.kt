package re.sta.rt

import io.realm.RealmObject


/*
    School 이라는 table 을 생성
    RealmObject 를 상속 받고
    객체, 객체타입을 적어두기.

 */
open class School : RealmObject() {
    var name : String? = null // 각 하나가 필드라고 한다.
    var location : String? = null
}