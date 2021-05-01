package re.sta.rt

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import java.lang.Exception
import java.lang.Thread
import java.lang.Thread.sleep

class AsyncActivity : AppCompatActivity() {
    var task : BackgroundAsyncTask? = null
    //var task2 : BackgroundAsyncTask? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)

       // val progressbar = findViewById<ProgressBar>(R.id.progressbar)
       // val ment = findViewById<TextView>(R.id.ment)


        // 재사용이 불편하다.. 따라서, 매번 이렇게 클릭할 때마다 AsyncTask 를 매번 만들어주게끔 해줘야한다.
        findViewById<Button>(R.id.start).setOnClickListener {
            task = BackgroundAsyncTask(
                findViewById(R.id.progressbar),
                findViewById(R.id.ment))

           // task2 = BackgroundAsyncTask( findViewById(R.id.progressbar), findViewById(R.id.ment))
            task?.execute()
          //  task2?.execute()
        }
        findViewById<Button>(R.id.stop).setOnClickListener {
           // task?.cancel(true)
            startActivity(Intent(this, Intent2::class.java))
        }
    }
        override fun onPause() {
            task?.cancel(true)
            super.onPause()
        }
}





class BackgroundAsyncTask(
    val progressBar: ProgressBar,
    val progressText : TextView
):AsyncTask<Int, Int, Int>(){

    // params -> doIntBackground 에서 사용할 타입
    // progress -> onProgressUpdate 에서 사용할 타입
    // result -> onPostExcute 에서 사용할 타입

    var percent : Int = 0

    override fun onPreExecute() {//-1
        percent = 0
        progressBar.setProgress(percent)
    }
    override fun doInBackground(vararg params: Int?): Int {//-2
        while (isCancelled() == false) {

            percent++
            Log.d("async", "percent : " + percent)
            if(percent > 100) {
                break
            }else {
                publishProgress(percent)
            }

            try {
                Thread.sleep(100)
            }catch (e: Exception) {
                e.printStackTrace()
            }

        }
        return percent
    }
    override fun onProgressUpdate(vararg values: Int?) {//-3(중간중간)
        progressBar.setProgress(values[0] ?: 0) // 얘가 null 일 경우에는 0
        progressText.setText("Percent(%) : " + values[0])
        super.onProgressUpdate(*values)
    }
    override fun onPostExecute(result: Int?) {//- 2가 끝나고 4로. 들어온다.
        progressText.setText("작업이 완료 되었습니다.")
    }

    override fun onCancelled() {
        progressBar.setProgress(0)
        progressText.setText("작업이 취소 되었습니다.")
    }
}