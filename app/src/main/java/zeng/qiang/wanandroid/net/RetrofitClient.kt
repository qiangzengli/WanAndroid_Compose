package zeng.qiang.wanandroid.net

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import me.jessyan.retrofiturlmanager.RetrofitUrlManager
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

private val json = Json {
    ignoreUnknownKeys = true
}

object RetrofitClient {
    private val okHttpClient: OkHttpClient = RetrofitUrlManager.getInstance()
        .with(
            OkHttpClient.Builder()
                .addInterceptor(
                    HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BASIC)
                )
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
        ).build()
    private val retrofit = Retrofit.Builder()
        .baseUrl(ApiService.URL)
        .addConverterFactory(
            json.asConverterFactory(
                "application/json".toMediaType()
            )
        )
        .client(okHttpClient)
        .build()
    val api: ApiService = retrofit.create(ApiService::class.java)

}