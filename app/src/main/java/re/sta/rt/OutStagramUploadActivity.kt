package re.sta.rt


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class OutStagramUploadActivity : AppCompatActivity() {

    lateinit var filePath: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_out_stagram_upload)

        findViewById<TextView>(R.id.view_pictures).setOnClickListener {
            getPicture()
        }
        findViewById<TextView>(R.id.upload_post).setOnClickListener {
            uploadPost()
        }

        findViewById<TextView>(R.id.all__list).setOnClickListener {
            startActivity(Intent(this, OutStagramPostListActivity::class.java))
        }
        findViewById<TextView>(R.id.my_list).setOnClickListener {
            startActivity(Intent(this, OutStagramMyPostListActivity::class.java))
        }
        findViewById<TextView>(R.id.user_info).setOnClickListener {
            startActivity(Intent(this, OutstagramUserInfo::class.java))
        }
    }


    fun getPicture() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.setType("image/*")
        startActivityForResult(intent, 1000)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1000) {
            val uri: Uri = data!!.data!!
            filePath = getImageFilePath(uri)
        }
    }

    fun getImageFilePath(contentUri: Uri): String {
        var columnIndex = 0
        val projection = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = contentResolver.query(contentUri, projection, null, null, null)
        if (cursor!!.moveToFirst()) {
            columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        }
        return cursor.getString(columnIndex)
    }

    fun uploadPost() {
        val file = File(filePath)
        val fileRequestBody = RequestBody.create(MediaType.parse("image/*"), file)
        val part = MultipartBody.Part.createFormData("image", file.name, fileRequestBody)
        val content = RequestBody.create(MediaType.parse("text/plain"), getContent())

        (application as MasterApplication).service.uploadPost(
            part, content
        ).enqueue(object : Callback<Post> {
            override fun onFailure(call: Call<Post>, t: Throwable) {
            }

            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful) {
                    finish()
                    startActivity(
                        Intent(
                            this@OutStagramUploadActivity,
                            OutStagramMyPostListActivity::class.java
                        )
                    )
                }
            }
        })
    }

    fun getContent(): String {
        return findViewById<TextView>(R.id.content_input).text.toString()
    }

}






