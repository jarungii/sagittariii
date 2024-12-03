@file:Suppress("INLINE_FROM_HIGHER_PLATFORM")
package com.jarungii.sagittariii.scenes

import korlibs.image.atlas.Atlas
import korlibs.image.atlas.readAtlas
import korlibs.io.file.std.resourcesVfs
import korlibs.korge.input.draggableCloseable
import korlibs.korge.scene.Scene
import korlibs.korge.view.*
import korlibs.math.geom.Point
import korlibs.math.geom.Scale
import korlibs.time.TimeSpan
import kotlin.random.Random
import korlibs.image.color.Colors
import korlibs.korge.Korge
import korlibs.korge.scene.sceneContainer
import korlibs.math.geom.Size

suspend fun examplee() = Korge(
    title = "Exampleeee",
    windowSize = Size(512, 512),
    backgroundColor = Colors["#2b2b2b"]
){
    val sceneContainer = sceneContainer()
    sceneContainer.changeTo{PlayScene()}
}

class PlayScene: Scene() {
    override suspend fun SContainer.sceneMain(){
        val atlas = resourcesVfs["spritesheet.json"].readAtlas()
        val sagittarius = atlas["sagittarius.png"]
        val spriteArrow = displaySprite(
            atlas = atlas,
            name = SpriteNames.arrow
        )
        val spriteYellowStar = displaySprite(
            atlas = atlas,
            name = SpriteNames.yellowstar
        )
        val animation = atlas.getSpriteAnimation(
            "star"
        )
        val sprite = sprite(animation)
        sprite.position(Point(200f, 200f))
        sprite.scaleXY = Scale(5)
        sprite.playAnimationLooped(
            // spriteDisplayTime = TimeSpan(200)
        )
        //controlDragAndDrop(spriteYellowStar)
    }
}

private fun Container.displaySprite(
    atlas: Atlas,
    name: String,
    point: Point = getRandomPoint()
) {
    val thing = atlas[name]
    val sprite = sprite(thing)
    sprite.position(point)
    sprite.scaleXY = Scale(5)
    sprite.name = name
}

private fun getRandomPoint(): Point{
    val x = Random.nextDouble(0.0, 500.0)
    val y = Random.nextDouble(0.0, 500.0)

    return Point(x, y)
}

object SpriteNames{
    const val arrow = "arrow.png"
    const val yellowstar = "yellowstar.png"
}
private var debugText: Text? = null
private fun Container.debugLog(
    message: String
){
    when(debugText){
        null -> debugText = text(text = message)
        else -> debugText?.text = message
    }
}

private fun Container.controlDragAndDrop(
    sprite: Sprite
){
    sprite.draggableCloseable (
        selector = sprite,
        autoMove = true
    ){
            draggableInfo ->
        val x = draggableInfo.viewNextX
        val y = draggableInfo.viewNextY

        debugLog(
            message = "Drag'n'Drop: $x, $y"
        )
    }
}