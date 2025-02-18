package command

/**
 *  A Command that can execute other Commands.
 *  Take an array of Commands and store them in the MacroCommand.
 */
class MacroCommand(private val commands: List<Command>) : Command {
    /**
     * When the macro gets executed, execute those commands one at a time.
     */
    override fun execute() {
        for (command in commands) {
            command.execute()
        }
    }

    override fun undo() {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        return javaClass.simpleName
    }
}