package udit.programmer.co.lec9_code1

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit_Client {
    val gson =
        GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
    val retrofitClient = Retrofit.Builder()
        .baseUrl("https://api.github.com/").addConverterFactory(GsonConverterFactory.create(gson))
        .build()
    val api = retrofitClient.create(GitHubServices::class.java)
}