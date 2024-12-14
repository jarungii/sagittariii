package entities

import korlibs.image.bitmap.*
import korlibs.korge.view.*

fun getSagittari(atlas: Bitmap): Sprite{
    val sagittariAnimation = SpriteAnimation(
        spriteMap = atlas,
        spriteWidth = 1202,
        spriteHeight = 1702,
        columns = 1,
        rows = 6
    )
    val sagittariSprite = Sprite(sagittariAnimation).scale(0.4, 0.4)
    return (sagittariSprite)
}
