@file:Suppress("INLINE_FROM_HIGHER_PLATFORM")

import entitiesIm.*
import korlibs.math.interpolation.*
import korlibs.audio.sound.*
import korlibs.datastructure.*
import korlibs.event.*
import korlibs.image.bitmap.*
import korlibs.image.color.*
import korlibs.korge.*
import korlibs.image.format.readBitmap
import korlibs.io.async.*
import korlibs.io.async.launch
import korlibs.io.file.std.*
import korlibs.korge.animate.*
import korlibs.korge.tween.*
import korlibs.korge.ui.*
import korlibs.korge.view.*
import korlibs.math.geom.*
import korlibs.time.*
import kotlinx.coroutines.*

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
    val blueStar = StarIm(1000.0, 200, resourcesVfs["bluestar.png"].readBitmap())
    val actStar = blueStar.getIm().addTo(this)
    var movingMode = false
    var shootingMode = false
    val input = this.input

    sagittari.tween(sagittari::alpha[0, 1], time = 1.seconds, easing = Easing.EASE_IN_OUT)

    uiButton("Move", ).also{
        it.width = 300.0
        it.height = 170.0
        it.background.radius = RectCorners(0f, 0f,
            90f, 90f)
        it.textSize = 100.0
        it.rotation = 90.degrees}
        .xy(width, height/2)
        .clicked {
            if (movingMode) {
                movingMode = false
            }else {
                movingMode = true
            }
    }
    uiButton("Shoot", ).also{
        it.width = 300.0
        it.height = 170.0
        it.background.radius = RectCorners(0f, 0f,
            90f, 90f)
        it.textSize = 100.0
        it.rotation = 90.degrees}
        .xy(width, height/2+300)
        .clicked {
            if (shootingMode) {
                shootingMode = false
            }else {
                shootingMode = true
            }
        }

    this.addUpdater { _ ->
        val random = 40
        val randGiven = (0..100).random()
        if (randGiven < random){
            //val star = image()
        }
        if (movingMode){
//            launch{
//                arrow
//                    .xy(sagittari.x-5, sagittari.y-230)
//                    .tween(arrow::alpha[0,1],time = 0.5.seconds, easing = Easing.EASE_IN_OUT)
//            }

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

    }

}
