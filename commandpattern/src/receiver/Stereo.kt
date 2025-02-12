package receiver

class Stereo(private val location: String) {
    private var volume = 0

    fun on() {
        println("$location stereo is on")
    }

    fun off() {
        println("$location stereo is off")
    }

    fun setCD() {
        println("$location stereo is set for CD input")
    }

    fun setDvd() {
        println("$location stereo is set for DVD input")
    }

    fun setRadio() {
        println("$location stereo is set for radio input")
    }

    fun setVolume(volume: Int) {
        this.volume = volume
        println("$location stereo volume set to $volume")
    }

    override fun toString(): String {
        return "$location stereo"
    }
}