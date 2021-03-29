package re.sta.rt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class Calculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val num1 : TextView = findViewById(R.id.one)
        val num2 : TextView = findViewById(R.id.two)
        val num3 : TextView = findViewById(R.id.three)
        val num4 : TextView = findViewById(R.id.four)
        val num5 : TextView = findViewById(R.id.five)
        val num6 : TextView = findViewById(R.id.six)
        val num7 : TextView = findViewById(R.id.seven)
        val num8 : TextView = findViewById(R.id.eight)
        val num9 : TextView = findViewById(R.id.nine)
        val num0 : TextView = findViewById(R.id.zero)
        val clear : TextView = findViewById(R.id.clear)
        val plus : TextView = findViewById(R.id.plus)
        val result : TextView = findViewById(R.id.result)
        // new -> old ( new + old )
        var init = ""
        var new = "0"
        var old = "0"


        num1.setOnClickListener{
            new = new + "1"
            result.setText(new)
        }
        num2.setOnClickListener{
            new = new + "2"
            result.setText(new)
        }
        num3.setOnClickListener{
            new = new + "3"
            result.setText(new)
        }
        num4.setOnClickListener{
            new = new + "4"
            result.setText(new)
        }
        num5.setOnClickListener{
            new = new + "5"
            result.setText(new)
        }
        num6.setOnClickListener{
            new = new + "6"
            result.setText(new)
        }
        num7.setOnClickListener{
            new = new + "7"
            result.setText(new)
        }
        num8.setOnClickListener{
            new = new + "8"
            result.setText(new)
        }
        num9.setOnClickListener{
            new = new + "9"
            result.setText(new)
        }
        num0.setOnClickListener{
            new = new + "0"
            result.setText(new)
        }


        clear.setOnClickListener{
            new = "0"
            old = "0"
            result.setText("0")
        }
        plus.setOnClickListener{
            old = (old.toInt() + new.toInt()).toString()
            new = "0" // 다시 수의 입력을 받을려고 new의 공간을 비어ㅈㅂ니다.
            result.setText(old)
        }


    }
}