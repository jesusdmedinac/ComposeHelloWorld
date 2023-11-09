import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.window.ComposeUIViewController
import presentation.viewmodel.HelloWorldScreenSideEffect
import presentation.viewmodel.HelloWorldScreenViewModel

fun MainViewController(
    helloWorldScreenViewModel: HelloWorldScreenViewModel,
) = ComposeUIViewController {
    with(helloWorldScreenViewModel) {
        val helloWorldScreenState by container
            .stateFlow
            .collectAsState()
        val helloWorldScreenSideEffect by container
            .sideEffectFlow
            .collectAsState(initial = HelloWorldScreenSideEffect.Idle)
        App(
            helloWorldScreenState,
            helloWorldScreenSideEffect,
            helloWorldScreenIntents = this,
        )
    }
}
