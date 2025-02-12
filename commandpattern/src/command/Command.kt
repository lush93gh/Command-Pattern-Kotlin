package command

interface Command {
    /**
     * All we need is one method call execute().
     */
    fun execute()
}