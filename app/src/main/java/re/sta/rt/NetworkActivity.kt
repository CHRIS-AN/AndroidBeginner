package re.sta.rt

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatViewInflater
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class NetworkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)

        NetworkTask(
            findViewById(R.id.recycler_person),
            LayoutInflater.from(this@NetworkActivity)
        ).execute()
    }
}

class NetworkTask(
    val recyclerView: RecyclerView,
    val inflater: LayoutInflater
):AsyncTask<Any?, Any?, Array<PersonFromServer>?>() {

    // 뷰를 실행 시킬 땐 꼭 이걸 override를해야한다.
    override fun onPostExecute(result: Array<PersonFromServer>?) {
        // 여기는 UI 쓰레드에 접근 가능하기 때문에 여기에서 뷰를 그려준다.
        val adapter = PersonAdaper(result!!, inflater)
        recyclerView.adapter = adapter
       // recyclerView.layoutManager = LinearLayoutManager(context)
        super.onPostExecute(result)
    }

    override fun doInBackground(vararg params: Any?): Array<PersonFromServer>? {
        val urlString : String  = "http://mellowcode.org/json/students/"
        val url : URL = URL(urlString)
        val connection : HttpURLConnection = url.openConnection() as HttpURLConnection

        connection.requestMethod="GET"
        connection.setRequestProperty("Content-Type", "application/json")

        var buffer = ""
        if(connection.responseCode == HttpURLConnection.HTTP_OK) {
            //Log.d("connn", "inputStream : " + connection.inputStream)
            val reader = BufferedReader(
                InputStreamReader(
                    connection.inputStream,
                    "UTF-8"
                )
            )
            buffer = reader.readLine()
            //Log.d("connn", "inputStream : " + buffer)
        }

        // 이 곳에 들어온 데이터 정리
        val data = Gson().fromJson(buffer, Array<PersonFromServer>::class.java)
        val age = data[0].age
        //Log.d("conn" , " age : " + age)
        return data
    }
}

class PersonAdaper (
    val personList : Array<PersonFromServer>,
    val inflater: LayoutInflater
        ):RecyclerView.Adapter<PersonAdaper.ViewHolder>() {

            inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
                val name : TextView
                val age : TextView
                val intro : TextView

                init {
                    name = itemView.findViewById(R.id.person_name)
                    age = itemView.findViewById(R.id.person_age)
                    intro = itemView.findViewById(R.id.person_ment)
                }
            }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.person_list_item, parent, false)
        return  ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.setText(personList.get(position).name?:"")
        holder.age.setText(personList.get(position).age.toString())
        holder.intro.setText(personList.get(position).intro?:"")

    }
}