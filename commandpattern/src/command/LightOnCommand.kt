package command

import receiver.Light

/**
 * Implement the Command interface.
 *
 * The constructor is passed the specific
 * light that this command is going to
 * control—say the living room light—
 * and stashes it in the light instance
 * variable. When execute gets called,
 * this is the light object that is going
 * to be the receiver of the request.
 */
class LightOnCommand(private val light: Light) : Command {
    /**
     * Calls the on() method on the
     * receiving object, which is
     * the light we are controlling.
     */
    override fun execute() {
        light.on()
    }

    /**
     * Turn the light back off.
     */
    override fun undo() {
        light.off()
    }
}