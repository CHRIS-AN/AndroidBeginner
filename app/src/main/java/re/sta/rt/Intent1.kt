package re.sta.rt

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class Intent1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent1)

        val change_activity : Button = findViewById(R.id.change_activity)


        change_activity.setOnClickListener {
//            val intent = Intent(this@Intent1, Intent2::class.java)
//            // Key : Value 방식  - > Key 와 Value 를 쌍으로 만들어 저장
//            // intent 에 값을 담아 넘긴다.
//            intent.putExtra("number1", 1)
//            intent.putExtra("number2", 2)
//            startActivity(intent)


//            val intent2 = Intent(this@Intent1, Intent2::class.java)
//            // apply 란? kotlin 에서 굉장히 유용하다.
//            intent2.apply {
//                this.putExtra("number1", 1)
//                this.putExtra("number2", 2)
//            }
            //startActivity(intent2) 전달만하는 애

            // 전달하고 결과도 받아볼 애애
//           startActivityForResult(intent2, 200) // requestcode의 이름을 지정해준다.
            // 왜 requestCode 를 작성하냐면, 결과를 받아볼 때, 내가 받은 결과가 맞는지 비교를 해주기 위해서 인수 이름을 지정해준다.




            // * 암시적 인텐트
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"))
            startActivity(intent)



        }
    }
    // Intent의 결과 값을 받으려면, 이 함수를 override를 해야한다.
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if(requestCode == 200) {
            Log.d("number", ""+requestCode)
            Log.d("number", ""+resultCode)
            // 200 이라는 인수이름이 맞다면? 데이터를 꺼내본다.
            val result = data?.getIntExtra("result", 0)
            Log.d("number", ""+result)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}






