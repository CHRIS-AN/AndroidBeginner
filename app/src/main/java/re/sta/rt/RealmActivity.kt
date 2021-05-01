package re.sta.rt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import io.realm.Realm
import io.realm.RealmConfiguration

class RealmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm)

        Realm.init(this@RealmActivity)

        // Builder 패턴에 있는 메소드 체이닝.


        //  Realm 을 얻는 과정. --◑1◐
        val config : RealmConfiguration = RealmConfiguration.Builder()
            .allowWritesOnUiThread(true)
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)
        val realm = Realm.getDefaultInstance()


        // 테이블을 만들고 온다. --◑2◐


        // --◑3◐
        findViewById<Button>(R.id.button_save).setOnClickListener {

            realm.executeTransaction {
                with(it.createObject(School::class.java)) {
                    this.name = "어떤 대학교"
                    this.location = "서울"
                }
            }
        }

        findViewById<Button>(R.id.button_load).setOnClickListener {
            realm.executeTransaction {
                val data = it.where(School::class.java).findFirst()
                Log.d("dataa", "data : " + data)
            }
        }

        findViewById<Button>(R.id.button_delete).setOnClickListener {
            realm.executeTransaction {
                it.where(School::class.java).findAll().deleteAllFromRealm()
                //it.where(School::class.java).findAll().deleteFirstFromRealm()
            }
        }

    }
}