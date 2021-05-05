package re.sta.rt

import android.app.Activity
import android.app.DownloadManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyTubeActivity : AppCompatActivity() {

    lateinit var glide : RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_tube)

        (application as MasterApplication).service.getYoutubeList()
            .enqueue(object: Callback<ArrayList<Youtube>>{
                override fun onResponse(
                    call: Call<ArrayList<Youtube>>,
                    response: Response<ArrayList<Youtube>>
                ) {
                    if(response.isSuccessful){
                        // 성공을하면 glide를 만들어주기로 한다.
                        glide = Glide.with(this@MyTubeActivity)
                        val youtubeList = response.body()
                        val adapter = MytubeAdapter(
                            youtubeList!!,
                            LayoutInflater.from(this@MyTubeActivity),
                            glide,
                            this@MyTubeActivity
                        )
                        findViewById<RecyclerView>(R.id.youtube_list_recycler).adapter = adapter
                    }
                }

                override fun onFailure(call: Call<ArrayList<Youtube>>, t: Throwable) {

                }

            })
    }
}

class MytubeAdapter(
    var youtubeList : ArrayList<Youtube>,
    val inflater: LayoutInflater,
    val glide: RequestManager,
    val activitiy : Activity
): RecyclerView.Adapter<MytubeAdapter.ViewHolder>() {
    inner class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        val title : TextView
        val content : TextView
        val thumbnail : ImageView
        init {
            title = itemView.findViewById(R.id.youtube_title)
            content = itemView.findViewById(R.id.youtube_content)
            thumbnail = itemView.findViewById(R.id.youtube_Thumbnail)

            itemView.setOnClickListener {
                val position : Int = adapterPosition
                val intent = Intent(Intent(activitiy, MytubeDetailActivity::class.java))
                intent.putExtra("video_url", youtubeList.get(position).video)
                activitiy.startActivity(intent)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.youtube_item_view, parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.title.setText(youtubeList.get(position).title)
        holder.content.setText(youtubeList.get(position).content)
        //holder.postImage.setText(postList.get(position).image) 불가.
        glide.load(youtubeList.get(position).thumbnail).into(holder.thumbnail) // 글라이드가 이미지를 불러워서 사진을 넣어준다.

    }

    override fun getItemCount(): Int {
        return youtubeList.size
    }
}