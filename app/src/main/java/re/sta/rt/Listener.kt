package re.sta.rt

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class Listener : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listener)

        val textView : TextView = findViewById(R.id.helloEveryOne)
        val image : ImageView = findViewById(R.id.image)
        var number = 10
        // 익명함수 !!!!!!!!


        //java 방법) view 를 activity 로 가져오는 방법.
        // 1 : 람다 방식
            textView.setOnClickListener{
                Log.d("click", "Click !!")
            }

        // 2 : 익명 함수 방식
        textView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("click", "Click !!")
            }
        })

        // 3 : 이름이 필요한 경우
        val click = object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("click", "Click !!")
                textView.setText("안녕하세요")
                image.setImageResource(R.drawable.water)
                number += 10
                Log.d("number", ""+number)
            }
        }
        textView.setOnClickListener(click)





        // 뷰를 조작하는 함수들






    }
}