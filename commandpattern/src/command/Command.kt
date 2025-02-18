package command

/**
 * All RemoteControl commands implement the Command interface,
 * which consists of one method: execute().
 * Commands encapsulate a set of actions on a specific vendor class.
 * The remote invokes these actions by calling the execute() method.
 */
fun interface Command {
    /**
     * All we need is one method call execute().
     */
    fun execute()
}