package command

import receiver.CeilingFan

class CeilingFanOffCommand(private val ceilingFan: CeilingFan) : Command {
    override fun execute() {
        ceilingFan.off()
    }

    override fun undo() {
        TODO("Not yet implemented")
    }
}