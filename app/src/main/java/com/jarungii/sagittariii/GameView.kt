package com.jarungii.sagittariii

import android.content.Context
import android.graphics.*
import android.view.MotionEvent
import android.view.SurfaceView
import androidx.compose.runtime.Composable
import kotlin.random.Random
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


class GameView(context: Context) : SurfaceView(context), Runnable {

    private val paint = Paint()
    private val stars = mutableListOf<Star>()
    private var isPlaying = true
    private var playerPositionX = 400f
    private var playerPower: Long = 0

    init {
        paint.style = Paint.Style.FILL
        generateStars()
    }


    private fun generateStars() {
        stars.clear()
        for (i in 0 until 10) {
            val x = Random.nextFloat() * width
            val y = Random.nextFloat() * height
            val color = Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat())
            val bonus = Random.nextInt(1, 100)
            stars.add(Star(x, y, color, bonus))
        }
    }

    override fun run() {
        while (isPlaying) {
            update()
            draw()
            Thread.sleep(16)
        }
    }

    private fun update() {
    }

    private fun draw() {
        val canvas = holder.lockCanvas()
        canvas?.let {
            drawPlayer(it)
            drawStars(it)
            holder.unlockCanvasAndPost(it)
        }
    }

    private fun drawPlayer(canvas: Canvas) {
        canvas.drawRect(playerPositionX - 50, height - 100f, playerPositionX + 50, height - 80f, paint)
    }

    private fun drawStars(canvas: Canvas) {
        stars.forEach { star ->

            canvas.drawCircle(star.x, star.y, 20f, paint)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                playerPower = System.currentTimeMillis()
            }
            MotionEvent.ACTION_UP -> {
                val elapsedTime = System.currentTimeMillis() - playerPower
                shootStar(elapsedTime)
            }
        }
        return true
    }

    private fun shootStar(power: Long) {
    }
}
