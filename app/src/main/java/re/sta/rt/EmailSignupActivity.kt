package re.sta.rt


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmailSignupActivity : AppCompatActivity() {

    lateinit var usernameView: EditText
    lateinit var userPassword1View: EditText
    lateinit var userPassword2View: EditText
    lateinit var registerBtn: TextView
    lateinit var loginBtn: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            if((application as MasterApplication).checkIsLogin()){

                finish() // 이 액티비티는 이동하기 전에, 종료를해준다.
                startActivity(Intent(this, OutStagramPostListActivity::class.java))
            }else{
            setContentView(R.layout.activity_email_signup)

            initView(this@EmailSignupActivity)
            setupListenr(this)
            }
    }


    fun setupListenr(activity: Activity) {
        registerBtn.setOnClickListener {
            register(this@EmailSignupActivity)
        }
        loginBtn.setOnClickListener {

            startActivity(
                Intent(this@EmailSignupActivity, LoginActivity::class.java)
            )

        }
    }

    fun register(activity: Activity) {
        val username = getUserName()
        val password1 = getUserPassword1()
        val password2 = getUserPassword2()

        (application as MasterApplication).service.register(
            username, password1, password2
        ).enqueue(object :
            Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(activity, "가입에 실패 하였습니다.", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    Toast.makeText(activity, "가입에 성공하였습니다.", Toast.LENGTH_LONG).show()
                    val user = response.body()
                    val token = user!!.token!!
                    saveUserToken(token, activity)

                    // 처음에 호출할 때는, 가입 이전이여서 sharedpreference 에 토큰값이 없었기 때문에,
                    // 다시 호출을 해주어야한다.
                    (application as MasterApplication).createRetrofit()

                    // 로그인을 성공하면, postListActivity로 넘어가게 만든다.
                    activity.startActivity(
                        Intent(activity, OutStagramPostListActivity::class.java)
                    )

                }
            }
        })
    }

    fun saveUserToken(token: String, activity: Activity) {
        val sp = activity.getSharedPreferences("login_sp", Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString("login_sp", token)
        editor.commit()
    }


    fun initView(activity: Activity) {
        usernameView = activity.findViewById(R.id.username_inputbox)
        userPassword1View = activity.findViewById(R.id.password1_inputbox)
        userPassword2View = activity.findViewById(R.id.password2_inputbox)
        registerBtn = activity.findViewById(R.id.register)
        loginBtn = activity.findViewById(R.id.login_sp)
    }

    fun getUserName(): String {
        return usernameView.text.toString()
    }

    fun getUserPassword1(): String {
        return userPassword1View.text.toString()
    }

    fun getUserPassword2(): String {
        return userPassword2View.text.toString()
    }
}
