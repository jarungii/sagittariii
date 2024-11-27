package com.jarungii.sagittariii.game

import com.jarungii.sagittariii.model.State
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import androidx.compose.runtime.mutableStateOf
import java.util.*

class GameEngine(
    private val scope: CoroutineScope,
    private val onGameEnded: () -> Unit
) {
    private val mutex = Mutex()
    private val mutableState =
        MutableStateFlow(
            State(
                stars = listOf(Pair(7, 7)),
                streletz = Pair(1,1)
            )
        )
    val state: Flow<State> = mutableState



}