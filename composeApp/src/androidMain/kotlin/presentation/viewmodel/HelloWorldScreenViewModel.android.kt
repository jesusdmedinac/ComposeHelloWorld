package presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.container

actual abstract class HelloWorldScreenViewModel :
    ViewModel(),
    CommonViewModel<HelloWorldScreenState, HelloWorldScreenSideEffect>,
    HelloWorldScreenIntents {
    actual final override val scope: CoroutineScope = viewModelScope
    actual override val container: Container<HelloWorldScreenState, HelloWorldScreenSideEffect> =
        scope.container(HelloWorldScreenState())
}
