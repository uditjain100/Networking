package udit.programmer.co.lec9_code1

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Retrofit

object Retrofit_Client {
    val retrofitClient = Retrofit.Builder()
        .baseUrl("https://api.github.com/").build()
    val gson =
        GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
    val api = retrofitClient.create(GitHubServices::class.java)
}