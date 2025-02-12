package client

import command.LightOnCommand
import invoker.SimpleRemoteControl
import receiver.Light

/**
 * This is our Client in Command Pattern.
 */
class SimpleRemoteControlClient {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            testLightOn()
            //testGarageDoorOpen()
        }

        private fun testLightOn() {
            // The remote is our Invoker;
            // it will be passed a command
            // object that can be used to
            // make requests.
            val remoteControl = SimpleRemoteControl()
            // The Receiver of the request.
            val light = Light("Living Room")
            // Create a command and pass the Receiver to it.
            val lightOnCommand = LightOnCommand(light)
            // Pass the command to the Invoker.
            remoteControl.setCommand(lightOnCommand)
            // Simulate the button being pressed.
            remoteControl.buttonWasPressed()
        }

        private fun testGarageDoorOpen() {
//            val remoteControl = SimpleRemoteControl()
//            val garageDoor = GarageDoor()
//            val garageDoorOpenCommand = GarageDoorOpenCommand(garageDoor)
//            remoteControl.setCommand(garageDoorOpenCommand)
//            remoteControl.buttonWasPressed()
        }
    }
}