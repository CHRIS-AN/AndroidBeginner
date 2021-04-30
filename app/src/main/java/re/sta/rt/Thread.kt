package re.sta.rt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import java.lang.Thread

class Thread : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)

        val button : Button = findViewById(R.id.button)


        val runnable : Runnable = object : Runnable {
            override fun run() {
                Log.d("Thread-1", "Thread is made")
            }
        }
        // T1
        val thread  : Thread = Thread(runnable)

        button.setOnClickListener {
            thread.start()
        }

        // T2
        Thread(object : Runnable {
            override fun run() {
                Log.d("Thread-2", "Thread is made")
            }
        }).start()

        // T3
        Thread(Runnable {
            Thread.sleep(2000)
            Log.d("Thread-3", "Thread is made")

            runOnUiThread {
                button.setBackgroundColor(getColor(R.color.black) )
            }

        }).start()











    }
}