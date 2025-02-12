package receiver

class Light(private val location: String) {
    fun on() {
        println("$location light is on")
    }

    fun off() {
        println("$location light is off")
    }

    override fun toString(): String {
        return "$location light"
    }
}