package buttons

import korlibs.korge.ui.*
import korlibs.math.geom.*

val arrowButton = UIButton(text = "ARROW").also{
    it.width = 400.0
    it.height = 170.0
    it.background.radius = RectCorners(0f, 0f,
        90f, 90f)
    it.textSize = 100.0
    it.rotation = 90.degrees}

val moveButton = UIButton(text ="MOVE").also{
    it.width = 300.0
    it.height = 170.0
    it.background.radius = RectCorners(0f, 0f,
        90f, 90f)
    it.textSize = 100.0
    it.rotation = 90.degrees}
