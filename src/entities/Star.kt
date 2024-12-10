@file:Suppress("INLINE_FROM_HIGHER_PLATFORM")

package entities

import korlibs.image.*
import korlibs.korge.view.*
import korlibs.math.geom.Rectangle
import kotlin.math.*

class Star(val speed: Double = 0.5, color: Int) {
    private val image: Image
    private val bonus: Int
    init{
        image = when (color) {
            1 -> Image(AssetLoader.star_yellow)
            2 -> Image(AssetLoader.star_purple)
            else -> {
            Image(AssetLoader.star_blue)
        }
        }
        bonus = when (color) {
            1 -> 100
            2 -> -10
            else -> {
            30
        }
        }
        this
    }


    private var xCoor = 0.0
    private var yCoor =  (20..100).random().toDouble()
    var angle = Math.random() * 360
    var hit = false

    fun update() {
        if (!hit) {
            val rad = Math.toRadians(angle)
            xCoor += Math.cos(rad) * speed
            yCoor += Math.sin(rad) * speed
        }
    }

    fun isHit(arrow: Arrow): Boolean {
        val starRect = Rectangle(xCoor, yCoor, image.width, image.height)

        return starRect.isZero
    }

    fun remove() {
        hit = true
    }
}
