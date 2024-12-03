@file:Suppress("INLINE_FROM_HIGHER_PLATFORM")

package com.jarungii.sagittariii.game

import androidx.compose.foundation.Image
import com.jarungii.sagittariii.helper.AssetLoader
import korlibs.korge.input.draggable
import korlibs.korge.input.draggableCloseable
import korlibs.korge.view.*
import korlibs.math.geom.Point

fun Container.sagittari(x: Double, y: Double, arrowsLeft: Int) = Sagittari(x = x, y = y, arrowsLeft = arrowsLeft)

class Sagittari(x: Double, y: Double, arrowsLeft: Int) {
    private val position = Point(x, y)
    private val image = Image(AssetLoader.sagittari).draggable()
}
