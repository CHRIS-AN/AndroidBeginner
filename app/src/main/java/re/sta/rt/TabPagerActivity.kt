package re.sta.rt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

/*

상호 연동을 위해서는 리스너가 필요합니다.
Adapter는 페이저를 위한 것이다.

item 이 여러개를 붙여 놓으면 ListView 이다.
페이저도 이와 동일하다. 수평으로 여러 페이지를
한 화면에 하나만 보여주게끔 하는 것이다. 안 보이는 곳에
다른 화면이 붙어있는 것이다.

*/
class TabPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_pager)

        val tab_layout : TabLayout = findViewById(R.id.tab_layout)
        val view_pager : ViewPager = findViewById(R.id.view_pager)


        // Add Tab 에서 새로운 Tab을 만든 다음에 그 Tab의 이름을 One이라고 짓는다. -- ◈_2_◈
        tab_layout.addTab(tab_layout.newTab().setText("ONE"))
        tab_layout.addTab(tab_layout.newTab().setText("TWO"))
        tab_layout.addTab(tab_layout.newTab().setText("THREE "))

        // Adapter 연결 시켜주기기 -- ◈_3_◈
       val pagerAdapter = FragmentPagerAdapter(supportFragmentManager, 3)
        view_pager.adapter = pagerAdapter

        // tabLayout 와 pager 를 연동해주는 작업 -- ◈_4_◈
        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                // 탭 순번과 맞는 프라그먼트를 보여줘야한다. -- ◈_5_◈
                view_pager.currentItem = tab!!.position // 느낌표 두 개로 tab 이 무조건 있다고 해야한다.
                // why? 매개변수 상 tab 이 null 이 올 수 있기 때문에

                // 코드를 추가 작성하는 게 아니라, fragment1,2,3 을 생성해서 background를 달리하여 스와프의 변화를 주기-- ◈_6_◈

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
        // 페이지를 스와프 할 때, 탭이 이동하는 것을 볼 수 있다. -- ◈_7_◈
        view_pager.addOnPageChangeListener(
            TabLayout.TabLayoutOnPageChangeListener(tab_layout))

    }
}


// 페이저의 리스트는 fragment 로 구성되어있다.   -- ◈_1_◈
class FragmentPagerAdapter (
            fragmentManager : FragmentManager,
            val tabCount : Int
        ):FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0-> {
                return Fragment1()
            }
            1-> {
                return Fragment2()
            }
            2-> {
                return Fragment3()
            }
            else -> return Fragment1()
        }
    }

    override fun getCount(): Int {

        return tabCount
    }
}