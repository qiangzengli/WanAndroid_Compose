package zeng.qiang.wanandroid.ui.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import kotlinx.serialization.ExperimentalSerializationApi
import zeng.qiang.wanandroid.entity.ArticleEntity
import zeng.qiang.wanandroid.ui.page.main.MainViewModel
import zeng.qiang.wanandroid.ui.page.main.Screen
import zeng.qiang.wanandroid.ui.theme.Pink

@ExperimentalSerializationApi
@Composable
fun ArticlePage(vm: MainViewModel = viewModel()) {
    vm.initData()
    val data = vm.liveData.observeAsState()
    val dataList = data.value?.datas ?: arrayListOf()
    // 导航控制器
    val navControllers = rememberNavController()
        .apply {
            //禁用返回
            enableOnBackPressed(false)
        }
    NavHost(
        navController = navControllers,
        startDestination = Screen.Home.route,
        //解决list item被bottomNavigation遮挡问题
        modifier = Modifier.padding(bottom = 56.dp)
    ) {

        composable(Screen.Mine.route) {
            composable(
                Screen.ArticleDetail.route,
                arguments = listOf(navArgument("article") {
                    type = NavType.ReferenceType
                })
            ) { entry -> ArticleDetailPage(entry.arguments?.getSerializable("article") as ArticleEntity) }
        }
    }

    LazyColumn {
        dataList.map {
            item {
                ArticleItem(it)
            }
        }


    }
}


@Composable
fun ArticleItem(articleEntity: ArticleEntity) {
    // 导航控制器
    val navControllers = rememberNavController()
        .apply {
            //禁用返回
            enableOnBackPressed(false)
        }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp)
            .clickable {
                navControllers.navigate(Screen.ArticleDetail.route)
            },
        elevation = 0.dp,
        backgroundColor = Pink,
    ) {
        Row(modifier = Modifier.padding(10.dp)) {
            // Advanced
            Image(
                painter = rememberImagePainter(
                    data = if (articleEntity.envelopePic.isEmpty()) "" else articleEntity.envelopePic,
                    builder = {
                        transformations(RoundedCornersTransformation(10f))
                    }
                ),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
            Text(
                text = articleEntity.title,
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .weight(1f),
            )
        }

    }

}