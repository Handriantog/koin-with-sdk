package com.wsa.koinwithsdk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.wsa.koinwithsdk.ui.theme.KoinWithSDKTheme
import com.wsa.mysdk.MySdk
import com.wsa.mysdk.SecretGeneratorInterface
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    //private val secretGenerator: SecretGeneratorInterface by inject()
    private val secretGenerator: SecretGeneratorInterface = MySdk.koin.get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val customString = secretGenerator.getSecretKey()
        enableEdgeToEdge()
        setContent {
            KoinWithSDKTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        customMessage = customString,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(customMessage: String, modifier: Modifier = Modifier) {
    Text(
        text = customMessage,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KoinWithSDKTheme {
        Greeting("Android")
    }
}