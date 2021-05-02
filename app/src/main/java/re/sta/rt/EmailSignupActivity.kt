package re.sta.rt

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmailSignupActivity : AppCompatActivity() {

    // 아이디와 패스워드를 가져 올 수 있는
    lateinit var usernameView : EditText
    lateinit var userPassword1View : EditText
    lateinit var userPassword2View: EditText
    lateinit var registerBtn : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_signup)


        initView(this@EmailSignupActivity)
        setupListener()
    }

    fun setupListener() {
        registerBtn.setOnClickListener {
            register(this@EmailSignupActivity) // 여기서 액티비티를 전달해줘야한다.
        }
    }

    fun register(activity: Activity) {
        // 가입 절차 진행
        val username = usernameView.text.toString()
        val password1 = userPassword1View.text.toString()
        val password2 = userPassword2View.text.toString()

        // 마스터 액티비티에서 만든 서비스를 가져와야한다.
        (application as MasterApplication).service.register(
            username,
            password1,
            password2
        ).enqueue(object :
            Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if(response.isSuccessful) {
                Toast.makeText(activity, "가입에 성공하였습니다.", Toast.LENGTH_LONG).show()
                val user = response.body()
                val token = user!!.token!! // 좋은 습관은 아니다..
                saveUserToken(token, activity)
                }
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                // 실패 했을 경우, 토스트를 띄어준다.
                Toast.makeText(activity, "가입에 실패하였습니다.", Toast.LENGTH_LONG).show()
            }
        })
    }

    // 이 함수는 토큰을 받아서, 받은 토큰은 sharedPerference 에 저장하기로 함.
    fun saveUserToken(token : String, activity: Activity) {
        val sp = activity.getSharedPreferences("login_sp", Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString("login_sp", token)
        editor.commit()
    }


    fun initView(activity : Activity) {
        usernameView = activity.findViewById(R.id.username_inputobox)
        userPassword1View = activity.findViewById(R.id.password1_inputobox)
        userPassword2View = activity.findViewById(R.id.password2_inputobox)
        registerBtn = activity.findViewById(R.id.register)
    }

    fun getUserName() : String {
        return usernameView.text.toString()
    }

    fun getUserPassword1() : String {
        return userPassword1View.text.toString()
    }

    fun getUserPassword2() : String {
        return userPassword2View.text.toString()
    }


}
