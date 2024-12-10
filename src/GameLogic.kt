import entities.*
import korlibs.korge.view.*
import korlibs.math.geom.Point
import kotlin.math.*

class GameLogic(val container: Container, val assets: Assets) {
    val stars = mutableListOf<Star>()
    val arrow = Arrow(container, assets.arrow)
    var score = 0

    init {
        // Initialize stars here (same as before)
//        for (i in 0 until 20) {
//            stars.add(createStar(assets.star))
//        }
    }


//    fun createStar(starPath: String): Star {
//        return Star(container, starPath)
//    }

    fun update() {
        arrow.update()
        stars.forEach { star ->
            if (star.isHit(arrow)) {
                star.remove()
                score++
            }
        }
    }

    fun shoot(archer: Image, releaseX: Double, releaseY: Double) {
        val archerCenterX = archer.x + archer.width / 2
        val archerCenterY = archer.y + archer.height / 2
        val initialVelocity = 15.0
        arrow.shoot(archerCenterX.toDouble(), archerCenterY.toDouble(), releaseX, releaseY, initialVelocity)
    }

    fun getScoret(): Int = score
}
