package re.sta.rt

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


// Fragment를 만들기.
class FragmentOne : Fragment() {

    interface OnDataPassListener {
        fun onDataPass(data : String?)
    }
    private lateinit var dataPassListener : OnDataPassListener
    private lateinit var pass : Button

    override fun onAttach(context: Context) {
        Log.d("life_cycle", "F onAttach")
        super.onAttach(context)
        dataPassListener = context as OnDataPassListener // "adfdf".toInt() 이런느낌!!
        // context를 OnDataPassListener 로 바꾸겠다라는 뜻.
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d("life_cycle", "F onCreate")
        super.onCreate(savedInstanceState)

    }


    // 뷰를 그리는 라이프 사이클
    override fun onCreateView(
        inflater: LayoutInflater,  // 뷰를 그려주는 애
        container: ViewGroup?,     // 부모뷰를 의미한다.
        savedInstanceState: Bundle?
    ): View? {
        Log.d("life_cycle", "F onCreateView")
        // fragment 가 인터페이스를 처음으로 그릴 때 호출된다.
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("life_cycle", "F onViewCreated")
        super.onViewCreated(view, savedInstanceState)

        // Activity의 Oncreate 에서 했던 작업을 여기에서 한다.
        pass = view.findViewById(R.id.pass)
        pass.setOnClickListener {
                dataPassListener.onDataPass("Good Bye")
        }


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("life_cycle", "F onActivityCreated")

        val data = arguments?.getString("hello")
        //Log.d("data",)
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d("life_cycle", "F onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("life_cycle", "F onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("life_cycle", "F onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("life_cycle", "F onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("life_cycle", "F onDestroyView")
        super.onDestroyView()
    }

    override fun onDetach() {
        Log.d("life_cycle", "F onDetach")
        super.onDetach()

    }
}