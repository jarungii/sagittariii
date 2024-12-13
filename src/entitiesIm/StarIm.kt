package entitiesIm

import korlibs.korge.view.*
import korlibs.image.bitmap.*


class StarIm(startX: Double, range: Int, bitmap: Bitmap) {
    private val star = Image(bitmap)
    init{
        star.scale(0.3,0.3)
        star.xy(startX, (-range..range).random().toDouble())
    }
    fun getIm():Image{
        return star
    }
}
