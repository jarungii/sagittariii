import korlibs.io.file.std.*
import korlibs.audio.sound.*

class Audio {
    suspend fun play(){
        val music = resourcesVfs["bgMUsic.mp3"].readMusic()
        val channel = music.playForever()
    }
}
