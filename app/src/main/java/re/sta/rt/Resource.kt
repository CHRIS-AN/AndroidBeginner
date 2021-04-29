package re.sta.rt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class Resource : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)

        val button : Button = findViewById(R.id.button3)

        // 1
        val ment = resources.getString(R.string.hello)
        Log.d("mentt", "ment : " + ment)

        // 2
        val ment2 = getString(R.string.hello)
        Log.d("mentt", "ment : " + ment2)

        // SDK 버전에 따른 분기 처리
        val color = getColor(R.color.textview_color)
        Log.d("mentt", "color : " + color)

        button.setBackgroundColor(resources.getColor(R.color.textview_color))

    }
}