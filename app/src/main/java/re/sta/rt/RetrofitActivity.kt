package re.sta.rt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)


        // http://mellowcode.org/json/students/
        val retrofit =  Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // 이 service를 통해서 데이터를 송수신 할 수 있다.
        val service = retrofit.create(RetrofitService::class.java)


// Get 요청-----------------------------------------------------------------------------
        // enqueue 는 대기줄에 올려 놓았다 라는 의미를 갖는다.
        service.getStudentsList().enqueue(object : Callback<ArrayList<PersonFromServer>> {
            // 호출이 실채할 때.
            override fun onFailure(call: Call<ArrayList<PersonFromServer>>, t: Throwable) {
                Log.d("retrofitt", "ERROR")
            }

            override fun onResponse(
                call: Call<ArrayList<PersonFromServer>>,
                response: Response<ArrayList<PersonFromServer>>
            ) {
                if(response.isSuccessful) {
                    // 통신이 잘 된 경우에? 원하는 데이터 타입으로 변경해주기.
                    val personList = response.body()
                    Log.d("retrofitt", "res : " + personList?.get(0)?.age)
                    val code = response.code()
                    Log.d("retrofitt", "code : " + code)

                    val error = response.errorBody()
                    val header = response.headers()

                }
            }
        })//---------------------------------------------------------------------------

        // POST 요청 (1)
//        val params = HashMap<String, Any>()
//        params.put("name","dev.nuts")
//        params.put("age", 30)
//        params.put("intro", "Start 서막")
//        service.createStudent(params).enqueue(object : Callback<PersonFromServer> {
//            override fun onResponse(
//                call: Call<PersonFromServer>,
//                response: Response<PersonFromServer>
//            ) {
//                if(response.isSuccessful) {
//                    val person = response.body()
//                    Log.d("retrofitt", "name : " + person?.name)
//                }
//            }
//
//            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//        })


        // POST 요청 (2)
        val person = PersonFromServer(name = "데브넛츠", age = 1, intro = "2021/05/02")
        service.createStudentEasy(person).enqueue(object : Callback<PersonFromServer> {
            override fun onResponse(
                call: Call<PersonFromServer>,
                response: Response<PersonFromServer>
            ) {
                if(response.isSuccessful) {
                    val person = response.body()
                    Log.d("retrofitt", "name : " + person?.name)
                }
            }

            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}