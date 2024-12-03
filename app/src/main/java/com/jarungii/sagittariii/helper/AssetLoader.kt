package com.jarungii.sagittariii.helper

import korlibs.image.bitmap.Bitmap
import korlibs.image.bitmap.BmpSlice
import korlibs.image.bitmap.slice
import korlibs.image.font.BitmapFont
import korlibs.image.format.readBitmap
import korlibs.io.file.std.resourcesVfs

object AssetLoader {
    lateinit var texture: Bitmap private set

    lateinit var bg: BmpSlice private set
    lateinit var star_blue: BmpSlice private set
    lateinit var star_yellow: BmpSlice private set
    lateinit var star_purple: BmpSlice private set
    lateinit var sagittari: BmpSlice private set
    lateinit var arrow: BmpSlice private set

    lateinit var text: BitmapFont private set
    suspend fun load() {
        texture = resourcesVfs["spritesheet.png"].readBitmap()

        bg = texture.slice(name = "bg.png")
        star_blue = texture.slice(name = "star/bluestar.png")
        star_yellow = texture.slice(name = "star/yellowstar.png")
        star_purple = texture.slice(name = "star/purplestar.png")
        sagittari = texture.slice(name = "sagittarius.png")
        arrow = texture.slice(name = "arrow.png")

        //text = resourcesVfs["text.fnt"].readBitmapFont()
    }
}