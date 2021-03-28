package re.sta.rt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Listener : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listener)


        // java 방법) view 를 activity 로 가져오는 방법.
        //val textView : TextView = findViewById(R.id.hello)

        // kotlin 방법)  xml 를 import 해서 가져온다.
    }
}