package receiver

class GarageDoor(private val location: String) {
    fun up() {
        println("$location garage door is up")
    }

    fun down() {
        println("$location garage door is down")
    }

    fun stop() {
        println("$location garage door is stopped")
    }

    fun lightOn() {
        println("$location garage light is on")
    }

    fun lightOff() {
        println("$location garage light is off")
    }
}