@file:Suppress("INLINE_FROM_HIGHER_PLATFORM")


package com.jarungii.sagittariii.game

import korlibs.korge.view.*
import com.jarungii.sagittariii.helper.*

fun Container.gameWorld() = GameWorld().addTo(this)

private enum class GameState {
    READY, RUNNING, GAME_OVER, HIGH_SCORE,
}

class GameWorld : Container() {

    var score = 0
    val isReady get() = currentState == GameState.READY
    val isGameOver get() = currentState == GameState.GAME_OVER
    val isHighScore get() = currentState == GameState.HIGH_SCORE

    private var currentState = GameState.READY
/*
    private val scoreText: Text
    private val touchMeText: Text
    private val gameOverText: Text
    private val highScoreText: Text
    private val highScoreValuePrefixText: Text
    private val highScoreValueText: Text
    private val tryAgainText: Text
*/
    private val backgroundView = BackgroundView()
    private val star = Star(10.0, 10.0, 2)
    private val sagittari = Sagittari(100.0, 100.0, 3)

    init {
        val midPointY = gameVirtual.Height / 2.0
        /*
        scoreText = text("", textSize = 18.0, font = AssetLoader.text)
        touchMeText = text("Touch me", textSize = 18.0, font = AssetLoader.text).xy((136 / 2) - (42 - 1), 75)
        gameOverText = text("Game Over", textSize = 18.0, font = AssetLoader.text).xy(24, 55)  // todo: don't forget there are multiple directions of shadow
        highScoreText = text("High Score!", textSize = 18.0, font = AssetLoader.text).xy(18, 55)
        highScoreValuePrefixText = text("High Score:", textSize = 18.0, font = AssetLoader.text).xy(22, 105)
        highScoreValueText = text("", textSize = 18.0, font = AssetLoader.text)
        tryAgainText = text("Try again?", textSize = 18.0, font = AssetLoader.text).xy(24, 75)
        * */

    }

    fun start() {
        currentState = GameState.RUNNING
    }

    fun restart() {
        val midPointY = gameVirtual.Height / 2.0
        currentState = GameState.READY
        score = 0
    }


    object gameVirtual{

        const val Width = 136
        const val Height = 204
    }
}