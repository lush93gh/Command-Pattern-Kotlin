package invoker

import command.Command
import command.NoCommand

class RemoteControlWithUndo {
    companion object {
        val NO_COMMAND = NoCommand()
    }

    private val onCommands = mutableMapOf<String, Command>()
    private val offCommands = mutableMapOf<String, Command>()

    // Stash the last command executed for the undo button.
    // Just like the other slots, undo starts off with a noCommand,
    // so pressing undo before any other button won’t do anything at all
    private var lastCommand: Command = NO_COMMAND

    fun setCommand(slot: String, onCommand: Command, offCommand: Command) {
        onCommands[slot] = onCommand
        offCommands[slot] = offCommand
    }

    /**
     * When a button is pressed, we take
     * the command and first execute it;
     * then we save a reference to it
     * in the last_command instance variable.
     */
    fun onButtonWasPushed(slot: String) {
        onCommands[slot]?.execute()
        lastCommand = onCommands[slot] ?: NO_COMMAND
    }

    /**
     * When a button is pressed, we take
     * the command and first execute it;
     * then we save a reference to it
     * in the last_command instance variable.
     */
    fun offButtonWasPushed(slot: String) {
        offCommands[slot]?.execute()
        lastCommand = offCommands[slot] ?: NO_COMMAND
    }

    /**
     * When the undo button is pressed, we
     * invoke the undo() method of the
     * command stored in last_command.
     * This undoes the operation of the last
     * command executed.
     */
    fun undoButtonWasPushed() {
        lastCommand.undo()
    }

    override fun toString(): String {
        var string = "\n------ Remote Control -------\n"
        onCommands.values.zip(offCommands.values).forEachIndexed { i, (onCommand, offCommand) ->
            string += "[slot $i] $onCommand   $offCommand\n"
            string += "[undo] $lastCommand\n"
        }
        return string
    }
}