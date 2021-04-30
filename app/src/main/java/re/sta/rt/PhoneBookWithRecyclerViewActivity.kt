package re.sta.rt

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PhoneBookWithRecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book_with_recycler_view)
        // 가짜 데이터를 만들어준다 -  여섯 번째 할 행동
        val phoneBook = createFakePhoneBook(fakeNumber = 30)
        // Adapter 생성하기 - 일곱 번쨰 할 행동.

        // *tip : 안에 파라미터값이 많이질 경우에는 파라미터이름을 적어주는 것이 좋다. - 열 두번째 행동
        val phoneBookRecyclerAdapter = PhoneBookRecyclerAdapter(
                    phonebookList = phoneBook,
                    inflater = LayoutInflater.from(this@PhoneBookWithRecyclerViewActivity),
                    activity = this) // 생성한 activity 를 adapter다가 넣어주기.  - 열 한 번째


        // 여덟 번째 할 행동를 리팩토링 한 것
        with(findViewById<RecyclerView>(R.id.phonebook_recycler_view)) {
            this.adapter = phoneBookRecyclerAdapter
            this.layoutManager = LinearLayoutManager(this@PhoneBookWithRecyclerViewActivity)
        }
        // 여덟 번째 할 행동
        //findViewById<RecyclerView>(R.id.phonebook_recycler_view).adapter = phoneBookRecyclerAdapter
        //findViewById<RecyclerView>(R.id.phonebook_recycler_view).layoutManager = LinearLayoutManager(this@PhoneBookWithRecyclerViewActivity)
    }


    // 가짜데이터.
    fun createFakePhoneBook(fakeNumber : Int = 30, phoneBook: PhoneBook = PhoneBook())
            : PhoneBook {    // 폰북을 return 시키겠다.
        for (i in 0 until fakeNumber) { // 따로 넣어주지 않으면 기본 10명
            phoneBook.addPerson(
                Person(
                    name = "" + i + "번째 사람",
                    number = "" + i + "번째 사람의 전화번호"
                )
            )
        }
        return phoneBook
    }


}

// Adapter 만들기 ! -- 첫 번째 할 행동.
class PhoneBookRecyclerAdapter (
    val phonebookList : PhoneBook,
    val inflater : LayoutInflater,
    // 인텐트 안에 activity를 넣어줘야해서 activity를 하나 받는다. 열 번째 할 행동
    val activity : Activity
    ):RecyclerView.Adapter<PhoneBookRecyclerAdapter.ViewHolder>() {

    // Holder 만들기 -- 두 번째 할 행동
    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val personName : TextView
        init {
            personName = itemView.findViewById(R.id.person_name)
            // 클릭해서 보내는 것 아이템 클릭!!- 아홉 번째 할 행동
            itemView.setOnClickListener {
                val intent = Intent(activity, PhoneBookDetailActivity::class.java)
                // 열 세번째 행동
                intent.putExtra("name", phonebookList.personList.get(adapterPosition).name)
                intent.putExtra("number", phonebookList.personList.get(adapterPosition).number)

                // 열 네번째 행동 startActivity가 자동완성으로 나오지 않는 것을 파악
                // 그 이유는 ? 이 곳은 어댑터를 만든 class이며, 위에서 메인 class에서 받은 상속을 받지 않기 때문이다.
                // activity를 상속 받아야하는데, 상속받을 수 없었고, 현재는 이 class에서 매개변수로 activity를 받았기 때문에
                // 그것으로 startActivity를 할 수 있다.
                activity.startActivity(intent)
            }
        }
    }
    // View를 직접 만든다 -- 세 번째 할 행동
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.phonebook_item, parent , false)
        // 뷰를 홀더에 넣어서 리턴을 합니다 ★ 그래야 재활용이 된다.
        return ViewHolder(view)
    }
    // 다섯 번째 할 행동
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.personName.setText(phonebookList.personList.get(position).name)
    }
    // 네 번째 할 행동
    override fun getItemCount(): Int {
         return  phonebookList.personList.size
    }
}