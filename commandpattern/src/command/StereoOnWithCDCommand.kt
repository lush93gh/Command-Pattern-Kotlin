package command

import receiver.Stereo

// 1. Pass the instance of the stereo
// we’re going to be controlling and
// store it in an instance variable.
// 2. Store the volume in an instance variable,
// rather than hardcoding it.
class StereoOnWithCDCommand(
    private val stereo: Stereo,
    private val volume: Int
) : Command {
    /**
     * To carry out this request, we need to call three
     * methods on the stereo: first, turn it on, then set
     * it to play the CD, and finally set the volume.
     */
    override fun execute() {
        stereo.on()
        stereo.setCD()
        stereo.setVolume(volume)
    }

    override fun undo() {
        stereo.off()
    }
}