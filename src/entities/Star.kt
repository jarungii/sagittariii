@file:Suppress("INLINE_FROM_HIGHER_PLATFORM")

package entities

import korlibs.image.*
import korlibs.korge.view.*
import korlibs.math.geom.Rectangle
import kotlin.math.*


class Star(color: Int, x: Double, y: Double) {
    private var xCoor: Double
    private var yCoor: Double
    val image: Image
    val bonus: Int
    var angle = Math.random() * 360
    var hit = false
    init{
        xCoor = x
        yCoor = y
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
    }

//    fun update() {
//        if (!hit) {
//            val rad = Math.toRadians(angle)
//            xCoor += Math.cos(rad)
//            yCoor += Math.sin(rad)
//        }
//    }
//
//    fun isHit(arrow: Arrow): Boolean {
//        val starRect = Rectangle(xCoor, yCoor, image.width, image.height)
//
//        return starRect.isZero
//    }
//
//    fun remove() {
//        hit = true
//    }
}
