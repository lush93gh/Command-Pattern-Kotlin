package command

import receiver.TV

class TVOffCommand(private val tv: TV) : Command {
    override fun execute() {
        tv.off()
    }

    override fun undo() {
        tv.on()
    }
}