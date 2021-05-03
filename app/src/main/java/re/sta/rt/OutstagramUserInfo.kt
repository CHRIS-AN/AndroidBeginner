package re.sta.rt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class OutstagramUserInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outstagram_user_info)

        findViewById<TextView>(R.id.all__list).setOnClickListener {
            startActivity(Intent(this, OutStagramPostListActivity::class.java)) }

        findViewById<TextView>(R.id.my_list).setOnClickListener {
            startActivity(Intent(this, OutStagramMyPostListActivity::class.java))
        }

        findViewById<TextView>(R.id.upload).setOnClickListener {
            startActivity(Intent(this, OutStagramUploadActivity::class.java))
        }
    }
}