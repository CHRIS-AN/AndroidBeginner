package re.sta.rt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import android.util.Log.d as d1

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val carList = ArrayList<CarForList>()

        for(i in 0 until 30) {
            carList.add(CarForList("" + i + "번째 자동차", "" + i + "순위 엔진"))
        }
        val adapter = ListViewAdapter(carList, LayoutInflater.from(this@ListViewActivity))
        findViewById<ListView>(R.id.listView).adapter = adapter
        findViewById<ListView>(R.id.listView).setOnItemClickListener { parent, view, position, id ->
            // 아이템을 클릭을 했을 때, 원하는 동작을 구현하기 위함.
            val carName = (adapter.getItem(position) as CarForList).name // casting 해주기
            val carEngine = (adapter.getItem(position) as CarForList).engine

            Toast.makeText(this@ListViewActivity, carName + "" + carEngine, Toast.LENGTH_SHORT).show()
        }


    }
}

// Adapter 생성.
class ListViewAdapter(
    val carforList : ArrayList<CarForList>,
    val layoutInflater: LayoutInflater
) : BaseAdapter() {
    override fun getCount(): Int {
        // 내가 가지고 있는 '리스트' 의 숫자(몇 개가 있는지?)를 알려줘야한다.
        return carforList.size
    }

    override fun getItem(position: Int): Any {
        // '리스트' 포지션의 하나를 알려주면 된다.
        return carforList.get(position) // 인덱스에 해당하는 아이템 정보를 알려주면 된다.
    }

    override fun getItemId(position: Int): Long {
        // List를 그리게 되면, 아이디를 부여해주어야하는데?
        // 해당 position 위치 해 있는 아이템 뷰의 id를 설정
        return position.toLong()

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        /*

        val view = layoutInflater.inflate(R.layout.item_view, null)
                                //findViewById 는 무겁다.
        val carNameTextView = view.findViewById<TextView>(R.id.car_name)
        val carEngineTextView = view.findViewById<TextView>(R.id.car_engine)
        carNameTextView.setText(carforList.get(position).name)
        carEngineTextView.setText(carforList.get(position).engine)
        return view

         */

        // 위에 있는 findViewById 함수를 쓰는 게 많이 무겁다보니, 다른 방법을 추천.
        val view : View
        val holder : ViewHolder


        // ★ 중요.
        if(convertView == null) {
            Log.d("convert : ",  "1")
            view = layoutInflater.inflate(R.layout.item_view, null)
            holder = ViewHolder()
            // 우리가 만들어 놓은 view에 findViewById로 찾은 다음에, holder에 넣는다.
            holder.carName = view.findViewById(R.id.car_name)
            holder.carEngine = view.findViewById(R.id.car_engine)

            view.tag = holder //여기서 tag 를 했기 때문에 찾을 수가 있다.
        }else {
            Log.d("convert : ",  "2")
            holder = convertView.tag as ViewHolder
            view = convertView
        }
        holder.carName?.setText(carforList.get(position).name)
        holder.carEngine?.setText(carforList.get(position).engine)

        return view
    }

}


class ViewHolder {
    var carName : TextView? = null
    var carEngine : TextView? = null
}