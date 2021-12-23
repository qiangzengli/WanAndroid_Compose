package zeng.qiang.wanandroid.entity

data class BaseEntity<T>(
    val Result: T?,
    val errorCode: Int,
    val errorMsg: String,
)