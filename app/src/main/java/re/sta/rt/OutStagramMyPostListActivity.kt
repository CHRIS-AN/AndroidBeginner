package re.sta.rt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList

class OutStagramMyPostListActivity : AppCompatActivity() {

    lateinit var myPostRecyclerView: RecyclerView
    lateinit var glide : RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_out_stagram_my_post_list)

        myPostRecyclerView = findViewById(R.id.myPost_recyclerview)
        glide = Glide.with(this@OutStagramMyPostListActivity)
        createList()

        findViewById<TextView>(R.id.user_info).setOnClickListener {
            startActivity(Intent(this, OutstagramUserInfo::class.java))
        }

        findViewById<TextView>(R.id.all__list).setOnClickListener {
            startActivity(Intent(this, OutStagramPostListActivity::class.java))
        }

        findViewById<TextView>(R.id.upload).setOnClickListener {
            startActivity(Intent(this, OutStagramUploadActivity::class.java))
        }


    }

    fun createList() {
        (application as MasterApplication).service.getUserPostList().enqueue(
            object : Callback<ArrayList<Post>>{
                override fun onResponse(
                    call: Call<ArrayList<Post>>,
                    response: Response<ArrayList<Post>>
                ) {
                    Log.d("123123", "error : " + response.body())
                    if(response.isSuccessful) {
                        val myPostList = response.body()
                        val adapter = MyPostAdapter(
                            myPostList!!,
                            LayoutInflater.from(this@OutStagramMyPostListActivity),
                            glide
                        )
                        myPostRecyclerView.adapter = adapter
                        myPostRecyclerView.layoutManager = LinearLayoutManager(
                            this@OutStagramMyPostListActivity)
                    }
                }

                override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {
                    Log.d("123123", "error")
                }
            })
    }
}


class MyPostAdapter(
    var postList : ArrayList<Post>,
    val inflater: LayoutInflater,
    val glide: RequestManager
): RecyclerView.Adapter<MyPostAdapter.ViewHolder>() {
    inner class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        val postOwner : TextView
        val postImage : ImageView
        val postContent : TextView
        init {
            postOwner = itemView.findViewById(R.id.post_owner)
            postContent = itemView.findViewById(R.id.post_content)
            postImage = itemView.findViewById(R.id.post_img)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.outstagram_item_view, parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.postOwner.setText(postList.get(position).owner)
        holder.postContent.setText(postList.get(position).content)
        //holder.postImage.setText(postList.get(position).image) 불가.
        glide.load(postList.get(position).image).into(holder.postImage) // 글라이드가 이미지를 불러워서 사진을 넣어준다.

    }

    override fun getItemCount(): Int {
        return postList.size
    }
}
