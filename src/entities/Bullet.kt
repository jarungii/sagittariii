package entities

import korlibs.image.bitmap.*
import korlibs.korge.view.*

fun getBullet(atlas: Bitmap): Sprite{
    val bulletAnimation = SpriteAnimation(
        spriteMap = atlas,
        spriteWidth = 1002,
        spriteHeight = 1002,
        columns = 1,
        rows = 10
    )
    val bulletSprite = Sprite(bulletAnimation).scale(0.07, 0.07)
    return (bulletSprite)
}
