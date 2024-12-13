package entitiesIm

import korlibs.io.file.std.*
import korlibs.image.bitmap.*
import korlibs.korge.view.*
import korlibs.time.*
import korlibs.event.*
import korlibs.korge.view.Stage
import korlibs.math.geom.*

class ArrowIm(startX: Double, startY: Double, image: Image)  {
    val arrowIm = image
    init{
        arrowIm.scale(0.3,0.3)
        arrowIm.xy(startX,startY)
    }
    fun chooseK(){
        arrowIm.addUpdater { time ->
            val scale = time.milliseconds
            arrowIm.rotation(scale.degrees)
        }
    }
}
