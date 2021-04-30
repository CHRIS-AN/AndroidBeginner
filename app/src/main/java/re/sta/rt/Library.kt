package re.sta.rt

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

class Library : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        //val glide : Button = findViewById(R.id.glide)

        Glide.with(this)
            .load("http://www.thelec.kr/news/photo/201911/4163_3843_2749.jpg")
            .centerCrop()
            .into(findViewById(R.id.glide))

    }
}

