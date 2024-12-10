package entities
import AssetLoader
import korlibs.korge.view.*
import korlibs.math.geom.*
import kotlin.math.*
class Sagittari (container: Container){
    val image = AssetLoader.arrow
    var position = Point(0.0, 0.0)
    var velocity = Point(0.0, 0.0)
}
