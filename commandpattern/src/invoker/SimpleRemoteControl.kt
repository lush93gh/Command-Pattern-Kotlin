package invoker

import command.Command

/**
 * We have one slot to hold our command,
 * which will control one device.
 */
class SimpleRemoteControl(private var slot: Command? = null) {
    /**
     * We have a method for setting the
     * command the slot is going to control.
     * This could be called multiple times if the
     * client of this code wanted to change
     * the behavior of the remote button.
     */
    fun setCommand(command: Command) {
        slot = command
    }

    /**
     * This method is called when the button
     * is pressed. All we do is take the
     * current command bound to the slot
     * and call its execute() method.
     */
    fun buttonWasPressed() {
        slot?.execute()
    }
}