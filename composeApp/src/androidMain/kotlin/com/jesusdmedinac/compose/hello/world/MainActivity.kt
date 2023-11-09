package com.jesusdmedinac.compose.hello.world

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.Job
import presentation.viewmodel.HelloWorldScreenIntents
import presentation.viewmodel.HelloWorldScreenSideEffect
import presentation.viewmodel.HelloWorldScreenState
import presentation.viewmodel.HelloWorldScreenViewModel
import presentation.viewmodel.HelloWorldScreenViewModelImpl

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val helloWorldScreenViewModel by viewModels<HelloWorldScreenViewModel> {
            viewModelFactory {
                addInitializer(HelloWorldScreenViewModel::class) {
                    HelloWorldScreenViewModelImpl()
                }
            }
        }
        setContent {
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
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App(
        helloWorldScreenState = HelloWorldScreenState(),
        helloWorldScreenSideEffect = HelloWorldScreenSideEffect.Idle,
        helloWorldScreenIntents = object : HelloWorldScreenIntents {
            override fun onButtonClicked(): Job {
                TODO("Not yet implemented")
            }
        },
    )
}
