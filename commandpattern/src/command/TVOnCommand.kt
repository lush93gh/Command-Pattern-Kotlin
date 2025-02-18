package command

import receiver.TV

class TVOnCommand(private val tv: TV) : Command {
    override fun execute() {
        tv.on()
    }

    override fun undo() {
        tv.off()
    }
}