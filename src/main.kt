@file:Suppress("INLINE_FROM_HIGHER_PLATFORM")

import buttons.*
import entities.*
import entitiesIm.*
import korlibs.image.color.*
import korlibs.image.format.*
import korlibs.io.file.std.*
import korlibs.korge.*
import korlibs.korge.tween.*
import korlibs.korge.ui.*
import korlibs.korge.view.*
import korlibs.math.interpolation.*
import korlibs.time.*


suspend fun main() = Korge(virtualWidth = 1080, virtualHeight = 2340, bgcolor = Colors["#2b2b2b"]){
    val bulletSheet = resourcesVfs["bullet.png"].readBitmap()
    val sagittariSheet = resourcesVfs["sagittari.png"].readBitmap()
    val bg = image(resourcesVfs["bg.png"].readBitmap()).addTo(stage)
    val sagittari = getSagittari(sagittariSheet)
    val blueStar = StarIm(1000.0, 20, resourcesVfs["bluestar.png"].readBitmap())
    var movingMode = false
    var shootingMode = false
    val input = this.input
    val bullet = getBullet(bulletSheet)
    sagittari.xy(-50.0,1600).addTo(this)
        .playAnimationLooped(spriteDisplayTime = 150.milliseconds)
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
    this.addUpdater { _ ->
        val randGiven = (0..10000).random()
        if (randGiven < chance) {
            val star = image(blueStar.getIm().bitmap)
            star.position(this.width, 1200 + (-750..380).random())
                .scale(0.03, 0.03)
                .alpha(1)
                .addTo(this)
            this.addUpdater {
                star.x -= 0.4
                star.y -= 0.1
                if (star.x<0){
                    star.removeFromParent()
                }
            }
        }
        if (movingMode) {
            val button: Int = input.mouseButtons
            if (button == 0) {
                sagittari.x += 7
            } else {
                sagittari.x -= 7
            }
            if (sagittari.x > this.width) {
                sagittari.x = -200.0
            }
        }
        if (shootingMode) {
            val curX = sagittari.x + 200
            bullet.playAnimationLooped(spriteDisplayTime = 50.milliseconds)
            bullet
                .scale(0.07, 0.07).xy(curX,sagittari.y - 350)
                .addTo(this)
            this.addUpdater {
                bullet.y -= 5
            }
            if (bullet.y<0) {
                bullet.y=sagittari.y - 350
                bullet.removeFromParent()
            }
        }
        if (!shootingMode){
            bullet.y = sagittari.y - 350
            bullet.removeFromParent()
        }
    }
}
