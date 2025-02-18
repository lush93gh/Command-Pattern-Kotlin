package receiver

class CeilingFan(private val location: String) {
    companion object {
        private const val HIGH = 3
        private const val MEDIUM = 2
        private const val LOW = 1
        private const val OFF = 0
    }

    // The CeilingFan instance holds local state representing
    // the speed of the ceiling fan.
    private var speed: Int = OFF

    fun high() {
        speed = HIGH
        println("$location ceiling fan is on high")
    }

    fun medium() {
        speed = MEDIUM
        println("$location ceiling fan is on medium")
    }

    fun low() {
        speed = LOW
        println("$location ceiling fan is on low")
    }

    fun off() {
        speed = OFF
        println("$location ceiling fan is off")
    }

    /**
     * Get the current speed of the ceiling fan.
     */
    fun getSpeed() = speed

    override fun toString(): String {
        return "$location ceiling fan"
    }
}