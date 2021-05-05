package re.sta.rt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.MediaController
import android.widget.VideoView

class MytubeDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mytube_detail)
        val video_view: VideoView = findViewById(R.id.video_view)
        val url = intent.getStringExtra("video_url")

        val mediaController = MediaController(this@MytubeDetailActivity)
        video_view.setVideoPath(url)
        video_view.requestFocus()
        video_view.start()

        mediaController.show()
        //Exoplayer 안드로이드에서 영상을 전문적으로 다룰 떄 사용하는,
    }
}