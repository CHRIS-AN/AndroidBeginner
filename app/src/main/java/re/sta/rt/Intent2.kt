package re.sta.rt

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class Intent2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent2)


        val result : Button = findViewById(R.id.result)

        result.setOnClickListener {
            val number1 = intent.getIntExtra("number1", 0)
            val number2 = intent.getIntExtra("number2", 0)

            Log.d("number", ""+number1)
            Log.d("number", ""+number2)

            val result = number1 + number2


            val resultIntent = Intent() // 인텐트를 생성 후,
            resultIntent.putExtra("result", result) // 생성한 인텐트에다가 결과값을 넣어준다.


            // 결과를 보내는 쪽에서 이 함수를 통해서 보낸다.
            setResult(Activity.RESULT_OK, resultIntent) // 결과를 설정해주는 것이다. -1
            finish() // -> Activity 종류 중 하나.

                // Stack 이라는 개념 ( 위로 쌓는다 )
                // Intent2 --> 종료 시킴 finish() 로 인하여.
                // Intent1
        }

    }
}






