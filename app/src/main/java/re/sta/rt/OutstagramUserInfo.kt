package re.sta.rt

import android.content.Context
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

        findViewById<TextView>(R.id.logout).setOnClickListener {
            val sp = getSharedPreferences("login_sp", Context.MODE_PRIVATE)
            val editor = sp.edit()
            editor.putString("login_sp", "null")
            editor.commit()

            // header 에 있는 인증 번호를 빼주어야한다.
            (application as MasterApplication).createRetrofit()
            finish()
            startActivity(Intent(this, LoginActivity::class.java))
        }



    }
}