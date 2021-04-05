package re.sta.rt

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText

class OpenInternet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open_internet)


        val address_edit_text : EditText = findViewById(R.id.address_edit_text)

        val open : Button = findViewById(R.id.open)
        open.setOnClickListener {
            val address = address_edit_text.text.toString()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(address))
            startActivity(intent)
        }

        address_edit_text.addTextChangedListener(object  : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if(s.toString() == "abc") {
                    Log.d("edit","text is abc")
                }
                    Log.d("edit","afterTextChagned : " + s)

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.d("edit","beforeTextChagned : " + s)
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("edit","onTextChagned : " + s)
            }
        })

    }
}