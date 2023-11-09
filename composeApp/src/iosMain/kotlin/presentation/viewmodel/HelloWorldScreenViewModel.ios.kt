package presentation.viewmodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.container

actual abstract class HelloWorldScreenViewModel :
    CommonViewModel<HelloWorldScreenState, HelloWorldScreenSideEffect>,
    HelloWorldScreenIntents {
    actual final override val scope: CoroutineScope = CoroutineScope(Dispatchers.Unconfined + Job())
    actual override val container: Container<HelloWorldScreenState, HelloWorldScreenSideEffect> =
        scope.container(HelloWorldScreenState())
}
