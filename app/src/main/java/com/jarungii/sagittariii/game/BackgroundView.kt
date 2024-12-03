@file:Suppress("INLINE_FROM_HIGHER_PLATFORM")


package com.jarungii.sagittariii.game

import com.jarungii.sagittariii.helper.AssetLoader
import korlibs.image.color.RGBA
import korlibs.korge.view.*

fun Container.backgroundView() = BackgroundView().addTo(this)

class BackgroundView() : Container() {

    init {
        image(AssetLoader.bg)
    }
}