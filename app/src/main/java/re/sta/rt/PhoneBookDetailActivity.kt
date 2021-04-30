package re.sta.rt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class PhoneBookDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book_detail)
        val back : ImageView = findViewById(R.id.back)
        getPersonInfoAndDraw()
        back.setOnClickListener {
            onBackPressed()    // 핸드폰 안에 물리적인 뒤로가기 버튼이 있다.
                                // 뒤로가기 버튼을 눌렀을 때, 움직이는 것과 같은 똑같은 함수
        }
    }
    //val person_detail_name : TextView = findViewById(R.id.person_detail_name)
    //val person_detail_number : TextView = findViewById(R.id.person_detail_number)

    // intent 를 받는다.
    fun getPersonInfoAndDraw() {
        val name = intent.getStringExtra("name")
        val number = intent.getStringExtra("number")

        // id값을 호출하기 위해서는 이렇게해야한다.
        findViewById<TextView>(R.id.person_detail_name).setText(name)
        findViewById<TextView>(R.id.person_detail_number).setText(number)
        //person_detail_name.setText(name)
        //person_detail_number.setText(number)
    }
}