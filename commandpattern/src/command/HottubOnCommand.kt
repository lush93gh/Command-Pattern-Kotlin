package command

import receiver.Hottub

class HottubOnCommand(private val hottub: Hottub) : Command {
    override fun execute() {
        hottub.on()
    }

    override fun undo() {
        hottub.off()
    }
}