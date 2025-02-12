package receiver

class CeilingFan(private val location: String) {
    private var speed: Int = 0

    fun high() {
        speed = 3
        println("$location ceiling fan is on high")
    }

    fun medium() {
        speed = 2
        println("$location ceiling fan is on medium")
    }

    fun low() {
        speed = 1
        println("$location ceiling fan is on low")
    }

    fun off() {
        speed = 0
        println("$location ceiling fan is off")
    }

    fun getSpeed() = speed

    override fun toString(): String {
        return "$location ceiling fan"
    }
}