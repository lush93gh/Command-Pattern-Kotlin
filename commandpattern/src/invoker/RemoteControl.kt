package invoker

import command.Command

/**
 * The RemoteControl class manages a set of Command objects, one per button.
 * When a button is pressed, the corresponding button_was_pushed() method
 * is called, which invokes the execute() method on the command.
 * That is the full extent of the remote’s knowledge of the classes it’s invoking
 * as the Command object decouples the remote from the classes doing the actual home automation work.
 */
class RemoteControl {
    // 1. The remote is going to handle seven On and Off commands,
    // which we’ll hold in corresponding Map.
    // 2. In the constructor, all we need to
    // do is instantiate and initialize the
    // On and Off Map.
    private val onCommands = mutableMapOf<String, Command>()
    private val offCommands = mutableMapOf<String, Command>()

    /**
     * 1. The set_command() method takes a slot
     * position and an On and Off command to
     * be stored in that slot.
     * 2. It puts these commands in the
     * On and Off Map for later use.
     */
    fun setCommand(slot: String, onCommand: Command, offCommand: Command) {
        onCommands[slot] = onCommand
        offCommands[slot] = offCommand
    }

    /**
     * When an On button is
     * pressed, the hardware takes
     * care of calling the on_button_was_pushed().
     */
    fun onButtonWasPushed(slot: String) {
        onCommands[slot]?.execute()
    }

    /**
     * When an Off button is
     * pressed, the hardware takes
     * care of calling the off_button_was_pushed().
     */
    fun offButtonWasPushed(slot: String) {
        offCommands[slot]?.execute()
    }

    /**
     * Override __str__() to print out each slot and
     * its corresponding command. You’ll see us use this
     * when we test the remote control.
     */
    override fun toString(): String {
        var string = "\n------ Remote Control -------\n"
        onCommands.values.zip(offCommands.values).forEachIndexed { i, (onCommand, offCommand) ->
            string += "[slot $i] ${onCommand.javaClass.simpleName}   ${offCommand.javaClass.simpleName}\n"
        }
        return string
    }
}