package udit.programmer.co.lec9_code1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.itemview.*
import kotlinx.android.synthetic.main.itemview.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val id = intent.getStringExtra("ID")

        GlobalScope.launch(Dispatchers.Main) {
            val response = withContext(Dispatchers.IO) { Retrofit_Client.api.getUserById(id) }
            if (response.isSuccessful) {
                response.body()?.let {
                    name_view.text = it.name
                    login_view.text = it.login
                    Picasso.get().load(it.avatarUrl).into(image_view)

                }
            }
        }

    }
}
