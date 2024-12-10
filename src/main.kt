@file:Suppress("INLINE_FROM_HIGHER_PLATFORM")

//import com.google.ar.core.Config
import entities.*
import korlibs.image.bitmap.*
import korlibs.image.color.*
import korlibs.korge.*
import korlibs.image.format.readBitmap
import korlibs.io.file.std.*
import korlibs.korge.view.*



suspend fun main() = Korge(virtualWidth = 1080, virtualHeight = 2340, bgcolor = Colors["#2b2b2b"]){
    val bg = image(resourcesVfs["bg.png"].readBitmap())
    val field = image(resourcesVfs["field.png"].readBitmap()).xy(-350.0,1600.0)
    val star = Star(0.5, (0..2).random()) //example of generation. doesn't work currently
//    val stars = listOf(Star(color = (0..2).random()), Star(color = (0..2).random()),
//        Star(color = (0..2).random()), Star(color = (0..2).random()))
}

data class Assets(val hill: String, val archer: String, val sky: String, val star: String, val arrow: String)
