package re.sta.rt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import org.w3c.dom.Text

class PhoneBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book)

        val phoneBook = createFakePhoneBook(30  )
        createPhoneBookList(phoneBook)


    }                                           // 폰북을 넣어주지 않을경우, 폰북을 생성해준다.
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
    fun createPhoneBookList (phoneBook: PhoneBook) {
        val layoutInflater = LayoutInflater.from(this@PhoneBookActivity)
        val container = findViewById<LinearLayout>(R.id.phonebook_list_container)
        for (i in 0 until phoneBook.personList.size) {
            // 인플레이터로, 아이템 하나가 들어갈 뷰를 inflater 시키겠습니다.
            val view = layoutInflater.inflate(R.layout.phonebook_item, null)
            val personNameView = view.findViewById<TextView>(R.id.person_name)
            personNameView.setText(phoneBook.personList.get(i).name)
            container.addView(view)

        }
    }
}

class PhoneBook() {
    // 전화 번호부
    val personList = ArrayList<Person>()

    fun addPerson(person : Person) {
        personList.add(person)
    }
}

class Person(val name : String, var number : String) {

}