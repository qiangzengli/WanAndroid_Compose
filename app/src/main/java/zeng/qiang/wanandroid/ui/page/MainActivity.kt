package zeng.qiang.wanandroid.ui.page

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import zeng.qiang.wanandroid.entity.ArticleEntity
import zeng.qiang.wanandroid.ui.theme.WanAndroidTheme

class MainActivity : ComponentActivity() {
    val model: MainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launchWhenResumed {

            model.initData()

        }
        setContent {
            WanAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, vm: MainViewModel = viewModel()) {
    val data = vm.liveData.observeAsState()
    val datas = data.value?.datas ?: arrayListOf()
    LazyColumn() {
        item {
            datas.map { articleItem(name = it.desc) }
        }

    }
}

@Composable
fun articleItem(name: String) {
    Text(text = "Hello ${name}!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WanAndroidTheme {
        Greeting("Android")
    }
}