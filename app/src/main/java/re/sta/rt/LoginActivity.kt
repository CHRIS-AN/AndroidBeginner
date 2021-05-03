package re.sta.rt

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<TextView>(R.id.register).setOnClickListener {
            val intent= Intent(this, EmailSignupActivity::class.java)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.login_sp).setOnClickListener {
            val username = findViewById<TextView>(R.id.username_inputbox).text.toString()
            val password = findViewById<TextView>(R.id.password_inputbox).text.toString()

            // 통신을 보내기.
            (application as MasterApplication).service.login(
                username, password
            ).enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    // 성공.
                    if(response.isSuccessful) {
                        val user = response.body()
                        val token = user!!.token!!

                        // 저장하기 !
                        saveUserToken(token, this@LoginActivity)
                        // 로그인이 된다.
                        (application as MasterApplication).createRetrofit()
                        Toast.makeText(this@LoginActivity, "로그인 하셨습니다.", Toast.LENGTH_LONG).show()
                        startActivity(
                            Intent(this@LoginActivity, OutStagramPostListActivity::class.java)
                        )
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    // 실패.
                 }

              })
            }
        }

        fun saveUserToken(token : String, activity: Activity) {
            val sp = activity.getSharedPreferences("login_sp", Context.MODE_PRIVATE)
            val editor = sp.edit()
            editor.putString("login_sp", token)
            editor.commit()

    }
}