package command

import receiver.GarageDoor

class GarageDoorDownCommand(private val garageDoor: GarageDoor) : Command {
    override fun execute() {
        garageDoor.down()
    }

    override fun undo() {
        garageDoor.up()

    }
}