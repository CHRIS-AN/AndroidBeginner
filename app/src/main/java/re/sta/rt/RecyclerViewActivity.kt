package re.sta.rt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val carList = ArrayList<CarForList>()
        for(i in 0 until 10) {
            carList.add(CarForList("" + i + "번째 자동차", "" + i + "순위 엔진"))
        }

        val adapter = RecyclerViewAdapter(carList, LayoutInflater.from(this@RecyclerViewActivity))
        findViewById<RecyclerView>(R.id.recycler_view).adapter = adapter

        // 리사이클러뷰는 레이아웃매니저를 통하기 때문에 유연하다.
          findViewById<RecyclerView>(R.id.recycler_view).layoutManager = LinearLayoutManager(this@RecyclerViewActivity)

        // Grid
//        findViewById<RecyclerView>(R.id.recycler_view).layoutManager = GridLayoutManager(this@RecyclerViewActivity, 2)

    }
}

// 리사이클러 뷰도 어댑터를 사용한다.

class RecyclerViewAdapter (
    val itemList : ArrayList<CarForList>,
    val inflater: LayoutInflater
): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
    class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView) {
        val carName : TextView
        val carEngine : TextView
        init {
            carName = itemView.findViewById(R.id.car_name)
            carEngine = itemView.findViewById(R.id.car_engine)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // 실제로 뷰를 만들어주는 곳
        val view = inflater.inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }
    // tag 같은 넉김.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // 뷰를 그려주는 부분입니다.
        holder.carName.setText(itemList.get(position).name)
        holder.carEngine.setText(itemList.get(position).engine)
    }


    override fun getItemCount(): Int {
        return itemList.size
    }
}