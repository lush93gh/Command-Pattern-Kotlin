package command

import receiver.Hottub

class HottubOffCommand(private val hottub: Hottub) : Command {
    override fun execute() {
        hottub.off()
    }

    override fun undo() {
        hottub.on()
    }
}