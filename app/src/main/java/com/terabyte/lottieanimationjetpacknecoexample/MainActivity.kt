package com.terabyte.lottieanimationjetpacknecoexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieClipSpec
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.terabyte.lottieanimationjetpacknecoexample.ui.theme.LottieAnimationJetpackNecoExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LottieAnimationJetpackNecoExampleTheme {
                val composition by rememberLottieComposition(
                    spec = LottieCompositionSpec.Asset("anim.json")
                )
                var isPlaying by remember {
                    mutableStateOf(false)
                }
                var isComplete by remember {
                    mutableStateOf(false)
                }
                val animSpec = LottieClipSpec.Progress(
                    max = if(isComplete) 1f else 0.397f
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    LottieAnimation(
                        modifier = Modifier
                            .height(200.dp)
                            .fillMaxWidth(),
                        contentScale = ContentScale.Crop,
                        composition = composition,
                        isPlaying = isPlaying,
                        speed = 1f,
                        iterations = if(isComplete) 1 else LottieConstants.IterateForever,
                        reverseOnRepeat = true,
                        clipSpec = animSpec,
                    )
                    Button(
                        onClick = {
                            isPlaying = true
                        }
                    ) {
                        Text(text = "Download")
                    }
                    Button(
                        onClick = {
                            isComplete = true
                        }
                    ) {
                        Text(text = "Finish")
                    }
                    Button(
                        onClick = {
                            isComplete = false
                        }
                    ) {
                        Text(text = "Restart")
                    }
                }
            }
        }
    }
}

