import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import presentation.viewmodel.HelloWorldScreenIntents
import presentation.viewmodel.HelloWorldScreenSideEffect
import presentation.viewmodel.HelloWorldScreenState

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App(
    helloWorldScreenState: HelloWorldScreenState,
    helloWorldScreenSideEffect: HelloWorldScreenSideEffect,
    helloWorldScreenIntents: HelloWorldScreenIntents,
) {
    MaterialTheme {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = helloWorldScreenIntents::onButtonClicked) {
                Text(helloWorldScreenState.message)
            }
            AnimatedVisibility(helloWorldScreenState.isImageDisplayed) {
                Image(
                    painterResource("compose-multiplatform.xml"),
                    null,
                )
            }
        }
    }
}
