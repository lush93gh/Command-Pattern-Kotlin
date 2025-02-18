package command

import receiver.Light

/**
 * The LightOffCommand works exactly
 * the same way as the LightOnCommand,
 * except that we’re binding the receiver to
 * a different action: the off() method.
 */
class LightOffCommand(private val light: Light) : Command {
    override fun execute() {
        light.off()
    }

    /**
     * Turn the light back on.
     */
    override fun undo() {
        light.on()
    }
}