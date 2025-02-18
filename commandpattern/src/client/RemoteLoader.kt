package client

import command.LightOffCommand
import command.LightOnCommand
import invoker.RemoteControlWithUndo
import receiver.Light

/**
 * The RemoteLoader creates a number of Command objects
 * that are loaded into the slots of the Remote Control. Each
 * command object encapsulates a request of a home
 * automation device.
 */
class RemoteLoader {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            load()
        }

        private fun load() {
            val remoteControl = RemoteControlWithUndo()

            // Create a Light.
            val livingRoomLight = Light("Living Room")

            // Light In and Off Commands with undo() enabled().
            val livingRoomLightOn = LightOnCommand(livingRoomLight)
            val livingRoomLightOff = LightOffCommand(livingRoomLight)

            // Add the light Commands to the remote in slot.
            remoteControl.setCommand(livingRoomLight.toString(), livingRoomLightOn, livingRoomLightOff)

            // Turn the light on, then off, and then undo.
            remoteControl.onButtonWasPushed(livingRoomLight.toString())
            remoteControl.offButtonWasPushed(livingRoomLight.toString())
            print(remoteControl)
            remoteControl.undoButtonWasPushed()
            // Turn the light off, back on, and undo.
            remoteControl.offButtonWasPushed(livingRoomLight.toString())
            remoteControl.onButtonWasPushed(livingRoomLight.toString())
            print(remoteControl)
            remoteControl.undoButtonWasPushed()
        }
    }
}