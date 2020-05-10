package udit.programmer.co.lec9_code1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import okhttp3.*
import org.json.JSONObject
import java.io.IOException
import kotlin.concurrent.thread
import kotlin.coroutines.CoroutineContext

class MainActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // okHttp Stuff
//        val okHttpClient = OkHttpClient()
//        val request = Request.Builder()
//            .url("https://api.github.com/users/uditjain100").build()
//        GlobalScope.launch(Dispatchers.Main) {
//            val response = withContext(Dispatchers.IO) {
//                okHttpClient.newCall(request).execute().body!!.string()
//            }
//            val obj = JSONObject(response)
//            val image = obj.getString("avatar_url")
//            val login = obj.getString("login")
//            val name = obj.getString("name")
//            Log.i("Networking", "$login   $name")
//            name_view.text = name
//            login_view.text = login
//            Picasso.get().load(image).into(image_view)
//        }

        //GSON Stuff
        val okHttpClient = OkHttpClient()
        val request = Request.Builder()
            .url("https://api.github.com/users/uditjain100").build()
        val gson =
            GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
        GlobalScope.launch(Dispatchers.Main) {
            val response = withContext(Dispatchers.IO) {
                okHttpClient.newCall(request).execute().body!!.string()
            }
            val user = gson.fromJson<Users>(response, Users::class.java)
            name_view.text = user.name
            login_view.text = user.login
            Picasso.get().load(user.avatarUrl).into(image_view)
        }

    }
}
