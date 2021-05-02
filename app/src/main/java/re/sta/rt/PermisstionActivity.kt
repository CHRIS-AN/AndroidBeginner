package re.sta.rt

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class PermisstionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permisstion)



        findViewById<Button>(R.id.ask).setOnClickListener {
                // 권한 얻는 방법.
            val cameraPermissionCheck = ContextCompat.checkSelfPermission(
                this@PermisstionActivity,
                android.Manifest.permission.CAMERA
            )

            PackageManager.PERMISSION_GRANTED // 이건 상수로 박혀있다.

            if (cameraPermissionCheck != PackageManager.PERMISSION_GRANTED) {
                // 권한이 없는 경우
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.CAMERA),
                    1000
                )
            } else {
                // 권한이 있는 경우
                Log.d("permissions", "권한이 이미있음")
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 1000) {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // 승낙
                Log.d("permissions", "승낙")
            }else {
                // 거부
                Log.d("permissions", "거부")
            }
        }
    }
}