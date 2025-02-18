package receiver

class CeilingFan(private val location: String) {
    enum class Speed(val value: Int) {
        Off(0), Low(1), Medium(2), High(3)
    }

    // The CeilingFan instance holds local state representing
    // the speed of the ceiling fan.
    private var speed: Speed = Speed.Off

    fun high() {
        speed = Speed.High
        println("$location ceiling fan is on high")
    }

    fun medium() {
        speed = Speed.Medium
        println("$location ceiling fan is on medium")
    }

    fun low() {
        speed = Speed.Low
        println("$location ceiling fan is on low")
    }

    fun off() {
        speed = Speed.Off
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