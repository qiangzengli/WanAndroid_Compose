package zeng.qiang.wanandroid.entity

import kotlinx.serialization.Serializable

@Serializable
data class BaseEntity<T>(
    val data: T,
    val errorCode: Int,
    val errorMsg: String,
)