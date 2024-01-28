package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Article(
                        articleImage = R.drawable.bg_compose_background,
                        heading = stringResource(R.string.Heading),
                        background = stringResource(R.string.Background),
                        main = stringResource(R.string.Main)
                    )
                }
            }
        }
    }
}

@Composable
fun ArticleMain(main: String){
    Text(
        text = main,
        textAlign = TextAlign.Justify,
        modifier = Modifier
            .padding(16.dp)
    )
}

@Composable
fun ArticleBackground(background: String){
    Text(
        text = background,
        textAlign = TextAlign.Justify,
        modifier = Modifier
            .padding(16.dp)
    )
}


@Composable
fun ArticleHeading(heading: String){
    Text(
        text = heading,
        fontSize = 24.sp,
        modifier = Modifier
            .padding(16.dp)
    )
}

@Composable
fun ArticleImage(articleImage: Int){
    Image(
        painter = painterResource(id = articleImage),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
    )
}

@Composable
fun Article(articleImage: Int, heading: String,background: String, main: String){
    Column {
        ArticleImage(articleImage = articleImage)
        ArticleHeading(heading = heading)
        ArticleBackground(background = background)
        ArticleMain(main = main)
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Compose Article App"
)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        Article(
            articleImage = R.drawable.bg_compose_background,
            heading = stringResource(R.string.Heading),
            background = stringResource(R.string.Background),
            main = stringResource(R.string.Main)
        )
    }
}