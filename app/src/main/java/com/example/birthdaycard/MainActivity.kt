package com.example.birthdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.birthdaycard.ui.theme.BirthdayCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayCardTheme{
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BirthdayGreetingWithImage(message = getString(R.string.happy_birthday_text), from = getString(R.string.from_signature) )
                }
            }
        }
    }
}


@Composable
fun BirthdayGreetingWithText(message: String, from: String, modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = message,
            fontSize = 32.sp,
            modifier = Modifier
                .padding(
                    top = 10.dp,
                    bottom = 10.dp
                )
        )

        Text(
            text = from,
            fontSize = 25.sp,
            modifier = Modifier
                .padding(end = 23.dp)
                .align(alignment = Alignment.End)
        )
    }

}

@Composable
fun BirthdayGreetingWithImage(message: String, from: String){
    val image = painterResource(id = R.drawable.androidparty)
    Box{
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        BirthdayGreetingWithText(message = message, from = from)
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BirthdayCardPreview(){
    BirthdayCardTheme{
        //BirthdayGreetingWithText(message = "Happy Birthday Shagun!", from = "- from Gaurav")
        BirthdayGreetingWithImage(message = stringResource(R.string.happy_birthday_text), from = stringResource(R.string.from_signature) )
    }
}