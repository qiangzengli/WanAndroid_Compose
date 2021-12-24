package zeng.qiang.wanandroid.ui.page

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation

@Composable
@ExperimentalFoundationApi
fun MinePage() {
    LazyColumn {
        item {
            Box(modifier = Modifier
                .fillMaxWidth()
                .clickable { }) {
                val modifier = Modifier
                    .align(Alignment.Center)
                    .padding(top = 10.dp)
                    .size(100.dp)
                Image(
                    painter = rememberImagePainter(
                        data = "https://www.wanandroid.com/resources/image/pc/default_project_img.jpg",
                        builder = {
                            transformations(CircleCropTransformation())
                        }
                    ),
                    contentDescription = null,
                    modifier = modifier,
                )


            }

        }

    }
}