package presentation.viewmodel

import getPlatform
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce

expect abstract class HelloWorldScreenViewModel() :
    CommonViewModel<HelloWorldScreenState, HelloWorldScreenSideEffect>,
    HelloWorldScreenIntents {
    final override val scope: CoroutineScope
    override val container: Container<HelloWorldScreenState, HelloWorldScreenSideEffect>
}

class HelloWorldScreenViewModelImpl : HelloWorldScreenViewModel() {
    private val platform = getPlatform()

    override fun onButtonClicked() = intent {
        reduce {
            state.copy(
                message = "Compose: Hello, ${platform.name}!",
                isImageDisplayed = !state.isImageDisplayed,
            )
        }
    }
}

data class HelloWorldScreenState(
    val message: String = "Hello World!",
    val isImageDisplayed: Boolean = false,
)

sealed class HelloWorldScreenSideEffect {
    data object Idle : HelloWorldScreenSideEffect()
}

interface HelloWorldScreenIntents {
    fun onButtonClicked(): Job
}
