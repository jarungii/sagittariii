@file:Suppress("INLINE_FROM_HIGHER_PLATFORM")

package com.jarungii.sagittariii.game

import com.jarungii.sagittariii.helper.AssetLoader
import korlibs.korge.view.Container
import korlibs.korge.view.Image
import korlibs.korge.view.addTo
import korlibs.math.geom.Point

fun Container.star(x: Double, y: Double, color: Int) = Star(x = x, y = y, color = color).addTo(this)

class Star(x: Double, y: Double, color: Int) : Container(){
    private val position = Point(x, y)
    private val image = when (color) {
        1 -> AssetLoader.star_yellow
        2 -> AssetLoader.star_purple
        else -> {
            AssetLoader.star_blue
        }
    }
}