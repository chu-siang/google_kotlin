package com.example.happybirthday

import android.graphics.BitmapRegionDecoder
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Checkbox
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ){
                    BirthdayGreetingWithImage(
                        message = stringResource(R.string.happy_birthday_text),
                        from = stringResource(R.string.birthday_sender_text)
                    )
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithImage(message: String, from: String){
    val image = painterResource(id = R.drawable.androidparty)
    Box{
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        BirthdayGreetingWithText(
            message = stringResource(R.string.happy_birthday_text),
            from = stringResource(R.string.birthday_sender_text)
        )
    }
}

@Composable
fun BirthdayGreetingWithText(message : String, from : String) {
    Column  {
        Text(
            text = message,
            fontSize = 36.sp,
            /*modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.Start)
                .padding(start = 16.dp, top = 16.dp)
            */
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = from,
            fontSize = 24.sp,
            /*
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.End)
                .padding(start = 16.dp, end = 16.dp)*/
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(start = 16.dp, end = 16.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun BirthdayGreetingWithImagePreview() {
    HappyBirthdayTheme {
        BirthdayGreetingWithImage(
            message = stringResource(R.string.happy_birthday_text),
            from = stringResource(R.string.birthday_sender_text)
        )
    }
}