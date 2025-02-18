package command

import receiver.CeilingFan

class CeilingFanOnCommand(private val ceilingFan: CeilingFan) : Command {
    override fun execute() {
        ceilingFan.high()
    }

    override fun undo() {
        ceilingFan.off()
    }
}