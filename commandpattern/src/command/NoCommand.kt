package command

class NoCommand : Command {
    override fun execute() {
    }

    override fun undo() {
    }

    override fun toString(): String {
        return javaClass.simpleName
    }
}