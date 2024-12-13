package entities

import korlibs.image.bitmap.*
import korlibs.korge.view.*
import korlibs.time.*

class Coin (bitmap: Bitmap, sX: Double, sY: Double, range: Int) {
    val coin = Image(bitmap)

    init {
        coin.scale(0.5, 0.5)
        coin.position(sX, sY / 2 + (-range..range).random())
        coin.addUpdater  { tS ->
            coin.x -= 0.3 * tS.milliseconds;
        }
    }
}
