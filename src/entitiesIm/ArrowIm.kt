package entitiesIm

import korlibs.image.bitmap.*
import korlibs.korge.input.*
import korlibs.korge.view.*
import korlibs.math.geom.*
import kotlin.math.*


class ArrowIm(startX: Double, startY: Double, bitmap: Bitmap)  {
    val arrowIm = Image(bitmap)
    init{
        arrowIm.scale(0.3,0.3)
        arrowIm.xy(startX,startY)
    }
    fun chooseK(){
        val dragStartX = arrowIm.x
        val dragStartY = arrowIm.y
        arrowIm
            .onMouseDrag {
                //Rotation Logic
                val mousePosY = it.cy
                val mousePosX = it.cx
                val angle = atan2(mousePosY - dragStartY, mousePosX - dragStartX)
                var arrowRotation = angle
                arrowIm.rotation(arrowRotation.degrees)

                if(arrowRotation > 180){
                    arrowRotation -= 360
                }
                if(arrowRotation < -180){
                    arrowRotation += 360
                }
            }
    }
}
