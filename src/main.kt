@file:Suppress("INLINE_FROM_HIGHER_PLATFORM")

import entitiesIm.*
import buttons.*
import korlibs.image.color.*
import korlibs.image.format.*
import korlibs.io.file.std.*
import korlibs.korge.*
import korlibs.korge.input.*
import korlibs.korge.tween.*
import korlibs.korge.ui.*
import korlibs.korge.view.*
import korlibs.math.geom.*
import korlibs.math.interpolation.*
import korlibs.time.*
import kotlinx.coroutines.*
import kotlin.math.*


suspend fun main() = Korge(virtualWidth = 1080, virtualHeight = 2340, bgcolor = Colors["#2b2b2b"]){

    val bg = image(resourcesVfs["bg.png"].readBitmap()).addTo(stage)
    val field = image(resourcesVfs["field.png"].readBitmap()).xy(-350.0,1600.0)
    val sagittari = image(resourcesVfs["sagittarius.png"].readBitmap())
        .xy(-50.0,1600.0)
        .scale(3)
        .alpha(0)
    val arrow = image(resourcesVfs["arrow.png"].readBitmap())
        .xy(this.width/2, 1600.0)
        .scale(3)
        .alpha(0)

    val blueStar = StarIm(1000.0, 20, resourcesVfs["bluestar.png"].readBitmap())
    val actStar = blueStar.getIm().alpha(0).addTo(this)
    var movingMode = false
    var shootingMode = false
    val input = this.input

    sagittari.tween(sagittari::alpha[0, 1], time = 1.seconds, easing = Easing.EASE_IN_OUT)

    arrowButton
        .xy(width, 1800).alpha(0)
        .clicked {
            if (shootingMode) {
                shootingMode = false
            }else {
                shootingMode = true
            }
        }
        .addTo(this)
        .tween(arrowButton::alpha[0,1], time = 1.seconds, easing = Easing.EASE_IN)
    moveButton
        .xy(width, 1500).alpha(0)
        .clicked {
            if (movingMode) {
                movingMode = false
            }else {
                movingMode = true
            }
        }
        .addTo(this)
        .tween(moveButton::alpha[0,1], time = 1.seconds, easing = Easing.EASE_IN)

    val chance = 100

    this.addUpdater { time ->
        val randGiven =  (0  .. 10000).random()
        if (randGiven < chance){
            val star =image(blueStar.getIm().bitmap)
            star.position(this.width, 1200 + (-550..380).random())
                .scale(0.3,0.3)
                .alpha(1)
                .addTo(this)
            this.addUpdater {
                star.x -= 0.4
                star.y -= 0.1
            }
        }
        if (movingMode){
            val button: Int = input.mouseButtons
            if (button == 0) {
                sagittari.x += 0.7
            } else {
                sagittari.x -= 0.7
            }
            if (sagittari.x > this.width){
                sagittari.x = -100.0
            }
        }
        if (shootingMode){
            val dragStart = Point(arrow.x, arrow.y)
            arrow
                .xy(sagittari.x-5, sagittari.y-230)
                .alpha(1)
        } else if (!shootingMode){
            arrow
                .xy(sagittari.x-5, sagittari.y-230)
                .alpha(0)
        }
    }

}
