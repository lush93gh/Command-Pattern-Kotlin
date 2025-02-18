package receiver

class TV(private val location: String) {
    companion object {
        enum class Channel {
            DVD
        }
    }

    private var channel = Channel.DVD
    private var volume = 0

    fun on() {
        println("$location TV is on")
        println("$location TV channel is set for $channel")
    }

    fun off() {
        println("$location TV is off")
    }

    fun setInputChannel(channel: Channel) {
        this.channel = channel
        println("$location TV channel is set for $channel")
    }

    fun setVolume(volume: Int) {
        this.volume = volume
        println("$location TV volume set to $volume")
    }

    override fun toString(): String {
        return "$location TV"
    }
}