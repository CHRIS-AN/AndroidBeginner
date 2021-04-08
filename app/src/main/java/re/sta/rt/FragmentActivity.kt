package re.sta.rt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.FragmentManager

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        Log.d("life_cycle", "onCreate")

        val fragmentOne : FragmentOne = FragmentOne()

        // frgment 에 data를 넣어주는 방법.
        // bundle을 생성해서 끼어 넣어주어야한다.
        val bundle : Bundle = Bundle()
        bundle.putString("hello", "hello") // key value로 되어있다.
        fragmentOne.arguments = bundle // 얘한테 bundle을 할당한다고 생각하기.

        val button : Button = findViewById(R.id.button)
        button.setOnClickListener {
            // fragment 를 동적으로 작동하는 방법
            // fragment 붙이는 방법 replace/add
            val fragmentManager : FragmentManager = supportFragmentManager // Activity가 가지고있다.


            // Transaction 작업 단위라고 생각할 수 있다. ( 작업 단위는 시작과 끝이 존재한다. )
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, fragmentOne) // 앞과 뒤를 바꿔준다.
            // commit을 하지 않으면, 바뀌지 않는다.
            // 끝을 내는 방법에는 두 가지 방법이 존재한다.
            // 1. commit -> 시간 날 때 해
            // 2. commitnow -> 지금 당장 해

            fragmentTransaction.commit() // 대체로 이것을 사용합니다.
            //fragmentTransaction.commitNow()
            //fragmentTransaction.commitAllowingStateLoss() 액티비티가 어떤 상태를 복구를 할 때에는, commit 을 잃어버릴수도 있다

        val button2 : Button = findViewById(R.id.button2)
            button2.setOnClickListener{
            // Fragment remove/ detach 하는 방법
                val fragmentManager = supportFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()


                // remove  detach 차이를 파악하기.
                //fragmentTransaction.detach(fragmentOne)
                fragmentTransaction.remove(fragmentOne) // remove로 제거를 해주면, 떼우다가 다시 붙는다.
                fragmentTransaction.commit()
            }


        }

    }

    override fun onStart() {
        super.onStart()
        Log.d("life_cycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("life_cycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("life_cycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("life_cycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("life_cycle", "onDestroy")
    }
}