package re.sta.rt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class NullSafety : AppCompatActivity() {

    lateinit var lateCar: Car // 사용하는 것을 '비추'

    class Car(val number : Int) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_null_safety)


        lateCar = Car(10)
        Log.d("number", "late number :" + lateCar.number)


        val number : Int = 10 // number 에 10이라는 것이 들어간다.
        val number1 : Int? = 30 // '?'를 써주지 않다면 null 이 발생.

        //val number5 : Int = number1 + 10 // number1 이 null 일수도? number 일수도 있는데,
                                        // number5 는 number 여야하기 때문에 syntax  error
                                        // 이럴 때, !! 느낌표를 써주어면 된다.
        val number6 : Int = number1!! + 10 // 개발자가 null이 아님을 보장합니다.

        //val number3 = number + number1?      문법에 없다.
        val number3 = number1?.plus(number)
        //Log.d("number", "number3 : " + number3)

        // 삼항 연산자란 -> kotlin 에서는 굉장히 문법적으로 편하게 사용할 수 잇게 지원한다.
        // 엘비스 연산자가 삼항 연산자이다.
        val number4 = number1 ?: 10  // number가 null이 아닐 경우에는, 아닌 값이 null일 경우에는 10이 들어갑니다.
        //Log.d("number", "number4 : " + number4)

    }


    fun plus (a: Int, b: Int?): Int {
        if (b != null) // else 를 쓰지 않을 경우에 조건문인 모든 경우를 포함하지 않아서 error 가 발생.
            return a+b
        else return a
    }

    fun plus2(a: Int, b: Int?) : Int? {
        return b?.plus(a)
    }

}