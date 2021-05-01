package re.sta.rt

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class SharedPreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)

        //SharedPreference

        // SharedPreference 저장하는 방법.
        //val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)

        /*
              Mode
                - MODE_PRIVATE : 생성한 application 에서만 사용 가능 (내가 만든 앱에서만 사용)
                - MODE_WORLD_READABLE : 다른 application 에서 사용 가능 (읽을 수 만 있다)
                - MODE_WORLD_WRITEABLE : 다른 application 에서 사용 가능 (기록도 가능하다)
                - MODE_MULTI_PROCESS : 이미 호출되어 사용중인지 체크
                - MODE_APPEND : 기존 preference 에 신규로 추가

         */
        // editor 를 통해서 데이터를 넣어준다.

//        val editor : SharedPreferences.Editor = sharedPreference.edit()
//        editor.putString("hello","안녕하세요.")
//        editor.commit() // 이것을 꼭 해주어야 데이터가 들어간다.

//--------------------------------------------------------------------------------------------------

        findViewById<Button>(R.id.save_btn).setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPreference.edit()
            editor.putString("hello","안녕하세요.")
            editor.putString("goodbye", "안녕히가세요")
            editor.commit() // 이것을 꼭 해주어야 데이터가 들어간다.

        }

        findViewById<Button>(R.id.load_button).setOnClickListener {
            // SharedPreference 에 값을 불러오는 방법
            val sharedPreference =getSharedPreferences("sp1", Context.MODE_PRIVATE)
            // 값을 꺼낸다.
            val value1 =sharedPreference.getString("hello", "데이터가 없습니다(hello).")
            val value2 =sharedPreference.getString("goodbye","데이터가 없습니다(goodbye).")
            Log.d("key-value", "Value : " + value1)
            Log.d("key-value", "Value : " + value2)
        }

        findViewById<Button>(R.id.delete_button).setOnClickListener {
            val sharedPreference =getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.remove("hello")
            editor.commit()

        }
        findViewById<Button>(R.id.delete_all_button).setOnClickListener {

            val sharedPreference =getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.clear() // 데이터 전부 다 지우기.
            editor.commit()
        }




    }
}