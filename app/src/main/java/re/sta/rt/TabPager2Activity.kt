package re.sta.rt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class TabPager2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_pager2)

        val tab_layout : TabLayout = findViewById(R.id.tab_layout)
        val view_pager : ViewPager = findViewById(R.id.view_pager)

        tab_layout.addTab(tab_layout.newTab().setText("ONE"))
        tab_layout.addTab(tab_layout.newTab().setText("TWO"))
        tab_layout.addTab(tab_layout.newTab().setText("THREE "))
    }
}

class ThreePageAdapter (
    val layoutInflater : LayoutInflater
): PagerAdapter() {

    // 실질적으로 뷰를 그려준다.
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        when (position) {
            1-> {
                val view = layoutInflater.inflate(R.layout.fragment_one, container, false)
                container.addView(view)
                return view
            }

            2-> {
                val view = layoutInflater.inflate(R.layout.fragment_two, container, false)
                container.addView(view)
                return view
            }

            3-> {
                val view = layoutInflater.inflate(R.layout.fragment_three, container, false)
                container.addView(view)
                return view

            }else -> {
                val view = layoutInflater.inflate(R.layout.fragment_one, container, false)
                container.addView(view)
                return view

            }
        }
    }

    // 여러 페이지가 스와프 할 때, 페이지가 넘어갈 때 보이지 않는 것이 파기가 되어져야할 때, 호출
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        // 아이템이 사라질테니, 컨테이너에서 뷰를 떼어줘야한다.
        container.removeView(`object` as View) // 이 오브젝트를 뷰로 바꿔준다음에, 컨테이너에서 떼어주면 된다.
    }                                           // any 를 view 로 casting 한다 고 생각.
    // 만들고 싶은 페이지의 카운트를 넣어주면 된다.
    override fun getCount(): Int {
        return 3
    }

    // 화면에 나와있는 게 너가 만들게 맞니? true / false..
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as View
    }


}