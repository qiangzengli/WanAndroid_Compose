package zeng.qiang.wanandroid.ui.page

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Article
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.ExperimentalSerializationApi
import zeng.qiang.wanandroid.ui.theme.WanAndroidTheme

val menuTitles = arrayListOf("首页", "文章", "我的")
val menuIcons = arrayListOf(
    Icons.Outlined.Home,
    Icons.Outlined.Article,
    Icons.Outlined.AccountCircle,
)

@ExperimentalSerializationApi
@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 记录当前选中的位置索引
            val selectedItem = remember {
                mutableStateOf(0)
            }
            // 导航控制器
            val navControllers = rememberNavController()
            //主题
            WanAndroidTheme {
                //Material 脚手架
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = menuTitles[selectedItem.value]) },
                            navigationIcon = {
                                Icon(
                                    imageVector = Icons.Filled.ArrowBack,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(30.dp)
                                        .clickable {

                                        }
                                )

                            }
                        )
                    },
                    bottomBar = {
                        BottomNavigation(
                            elevation = 5.dp,
                            modifier = Modifier.clip(
                                shape = RoundedCornerShape(10.dp)
                            )
                        ) {
                            items.forEachIndexed { index, s ->
                                BottomNavigationItem(
                                    selected = selectedItem.value == index,
                                    alwaysShowLabel = true,
                                    label = { Text(text = menuTitles[index]) },
                                    onClick = {
                                        selectedItem.value = index
                                        navControllers.navigate(s.route) {
                                            popUpTo(navControllers.graph.startDestinationId)
                                            launchSingleTop = true
                                        }
                                    },
                                    icon = {
                                        Icon(
                                            imageVector = menuIcons[index],
                                            contentDescription = menuTitles[index]
                                        )
                                    })
                            }
                        }
                    },
                    content = {
                        NavHost(
                            navController = navControllers,
                            startDestination = Screen.Home.route,
                        ) {
                            composable(Screen.Home.route) { MinePage() }
                            composable(Screen.Article.route) { ArticlePage() }
                            composable(Screen.Mine.route) { MinePage() }
                        }
                    }
                )

            }
        }
    }
}

/**
 * 使用密封类 减少Page创建
 */
sealed class Screen(
    val route: String,
) {
    object Home : Screen("home")
    object Article : Screen("article")
    object Mine : Screen("mine")
}

val items = listOf(
    Screen.Home,
    Screen.Article,
    Screen.Mine,
)

