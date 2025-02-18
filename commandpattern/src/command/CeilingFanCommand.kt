package command

import receiver.CeilingFan

class CeilingFanCommand(private val ceilingFan: CeilingFan, private var speed: CeilingFan.Speed) : Command {
    // Local state to keep track of the previous speed of the fan.
    private var prevSpeed: CeilingFan.Speed = ceilingFan.getSpeed()

    override fun execute() {
        // Before we change the speed of the fan,
        // we need to first record its previous state,
        // just in case we need to undo our actions.
        prevSpeed = ceilingFan.getSpeed()
        setSpeed(speed)
    }

    /**
     * Set the speed of the fan back to its previous speed.
     */
    override fun undo() {
        setSpeed(prevSpeed)
    }

    private fun setSpeed(speed: CeilingFan.Speed) {
        when (speed) {
            CeilingFan.Speed.High -> ceilingFan.high()
            CeilingFan.Speed.Medium -> ceilingFan.medium()
            CeilingFan.Speed.Low -> ceilingFan.low()
            CeilingFan.Speed.Off -> ceilingFan.off()
        }
    }

    override fun toString(): String {
        return "CeilingFan${speed}Command"
    }
}