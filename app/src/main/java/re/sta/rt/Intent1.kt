package re.sta.rt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Intent1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent1)

        val change_activity : Button = findViewById(R.id.change_activity)


        change_activity.setOnClickListener {
            val intent = Intent(this@Intent1, Intent2::class.java)

            // Key : Value 방식  - > Key 와 Value 를 쌍으로 만들어 저장
            // intent 에 값을 담아 넘긴다.
            intent.putExtra("number", 1)
            intent.putExtra("number2", 2)
            startActivity(intent)


            val intent2 = Intent(this@Intent1, Intent::class.java)
            // apply 란? kotlin 에서 굉장히 유용하다.
            intent2.apply {
                this.putExtra("number1", 1)
                this.putExtra("number2", 2)
            }
            startActivity(intent2)

        }



    }
}