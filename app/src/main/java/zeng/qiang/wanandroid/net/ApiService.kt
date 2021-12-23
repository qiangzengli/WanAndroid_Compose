package zeng.qiang.wanandroid.net

import retrofit2.http.GET
import retrofit2.http.Query
import zeng.qiang.wanandroid.entity.ArticleEntity
import zeng.qiang.wanandroid.entity.BaseEntity

interface ApiService {
    companion object {
        const val URL = "https://www.wanandroid.com"
    }

    @GET("article/list/{index}/json")
    suspend fun getWxArticle(@Query("index") index: Int): BaseEntity<ArticleEntity>

}