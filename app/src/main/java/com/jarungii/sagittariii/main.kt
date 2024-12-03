@file:Suppress("INLINE_FROM_HIGHER_PLATFORM")

package com.jarungii.sagittariii

import com.jarungii.sagittariii.game.gameWorld
import com.jarungii.sagittariii.helper.AssetLoader
import korlibs.image.bitmap.extract
import korlibs.korge.Korge

suspend fun main() = Korge(){
    AssetLoader.load()
    //Storage.init()
    views.gameWindow.icon = AssetLoader.sagittari.extract()
    val world = gameWorld()
    val input = views.input
    world.start()
}