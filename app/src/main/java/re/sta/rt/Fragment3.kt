package re.sta.rt

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class Fragment3 : Fragment() {
    // 뷰를 그리는 라이프 사이클
    override fun onCreateView(
        inflater: LayoutInflater,  // 뷰를 그려주는 애
        container: ViewGroup?,     // 부모뷰를 의미한다.
        savedInstanceState: Bundle?
    ): View? {
        Log.d("life_cycle", "F onCreateView")
        // fragment 가 인터페이스를 처음으로 그릴 때 호출된다.
        return inflater.inflate(R.layout.fragment_three, container, false)
    }

}