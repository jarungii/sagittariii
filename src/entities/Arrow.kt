package entities

import AssetLoader
import korlibs.korge.view.*
import korlibs.math.geom.*
import kotlin.math.*

class Arrow(x: Int, y: Int) {
    val image = AssetLoader.arrow
    var velocity = Point(0.0, 0.0)
    var gravity = 0.5
    var isFlying = false
    var xCoor = x
    var yCoor = y
    init {
        //image.visible = false // Initially hidden
    }

    fun shoot(startX: Double, startY: Double, endX: Double, endY: Double, initialVelocity: Double) {
        image.x(xCoor)
        image.y(yCoor)
        image
        isFlying = true
        // Calculate velocity vector
        val dx = endX - startX
        val dy = endY - startY
        val distance = sqrt(dx * dx + dy * dy)
        velocity = Point(dx / distance * initialVelocity, dy / distance * initialVelocity)
    }

    fun update() {
        if (isFlying) {
//            velocity.y += gravity // Apply gravity
//            position.x += velocity.x
//            position.y += velocity.y
//            image.x = position.x.toFloat()
//            image.y = position.y.toFloat()
//
//            // Check if arrow is off-screen or has hit the ground
//            if (position.y > 600 || position.x < 0 || position.x > 800) {
//                isFlying = false
//                image.visible = false
            }
        }
    }


