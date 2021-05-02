package re.sta.rt

import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MasterApplication : Application() {

    lateinit var service : RetrofitService

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        createRetrofit()
    }

    fun createRetrofit() {
        // 헤더를 설정하는 부분
        val header = Interceptor {
            val original = it.request()

            if(checkIsLogin()) { // 로그인이 되었다면?
                getUserToken()?.let {token ->
                    val request = original.newBuilder()
                        .header("Authorization", "token " + token)
                        .build()
                    it.proceed(request) }
            }else {
                it.proceed(original)
            }
        }

        val client  = OkHttpClient.Builder()
            .addInterceptor(header)
            .addNetworkInterceptor(StethoInterceptor())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        service = retrofit.create(RetrofitService::class.java)
    }

    // 로그인을 체크하는 함수
    fun checkIsLogin() : Boolean {
        val sp = getSharedPreferences("login_sp", Context.MODE_PRIVATE)
        val token = sp.getString("login_sp", "null") // 디폴트 벨류는 null

        if (token != "null") return true
         else return false
        }


    fun  getUserToken() : String?  {
        val sp = getSharedPreferences("login_sp", Context.MODE_PRIVATE)
        val token = sp.getString("login_sp", "null") // 디폴트 벨류는 null

        if(token == "null") return null
        else return token
    }
}




















