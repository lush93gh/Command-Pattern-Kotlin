package receiver

class Hottub {

    private var temperature = 98

    fun on() {
        setTemperature(104)
        circulate()
    }

    fun off() {
        setTemperature(98)
    }

    fun circulate() {
        println("Hottub is bubbling!")
    }

    fun jetsOn() {
        println("Hottub jets are on")
    }

    fun jetsOff() {
        println("Hottub jets are off")
    }

    fun setTemperature(temperature: Int) {
        if (this.temperature < temperature) {
            println("Hottub is heating to a steaming $temperature degrees")
        } else {
            println("Hottub is cooling to $temperature degrees")
        }
        this.temperature = temperature
    }

    override fun toString(): String {
        return javaClass.simpleName
    }
}