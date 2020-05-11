package udit.programmer.co.lec9_code1

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubServices {

    @GET("users")
    suspend fun getUser(): Response<List<Users>>

    @GET("users/{id}")
    suspend fun getUserById(@Path("id") id: String): Response<Users>

    @GET("search/users")
    suspend fun searchUsers(@Query("q") query: String): Response<UserResponse>

}