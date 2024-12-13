import entities.*
import korlibs.korge.view.*
import korlibs.image.*
import korlibs.image.format.readBitmap
import korlibs.io.file.std.*

import korlibs.image.color.*
import korlibs.image.font.*
import korlibs.korge.*
import korlibs.image.format.readBitmap
import korlibs.io.file.std.*
import korlibs.korge.view.*
import kotlin.random.*

class Game(stage: Stage){
    val zero = 0
    val WIDTH = 1080
    val HEIGHT = 2340
    val stage: Stage = stage
    private var gameOver = false

    init{
        spawnRandomStars()
    }

    private fun spawnRandomStars(stage: Stage = this.stage){
        val random = Random
        repeat(5) {
            val star = spawnStar(0.0, 0.0, (0..2).random(), 0.5, stage)
            star.x = (0..2).random().toDouble()
            star.y = (0..2).random().toDouble()
        }
    }

    private fun spawnStar(x: Double, y: Double, color: Int, speed: Double, stage: Stage): Image{
        var star = Star(color, x, y).image
        val mystage: Stage = stage
        return star.addTo(mystage).xy(x, y)
    }
}
