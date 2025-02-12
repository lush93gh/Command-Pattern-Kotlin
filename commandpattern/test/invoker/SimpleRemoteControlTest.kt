package invoker

import command.LightOnCommand
import receiver.Light

class SimpleRemoteControlTest {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SimpleRemoteControlTest().testLightOn()
        }
    }

    fun testLightOn() {
        // The remote is our Invoker;
        // it will be passed a command
        // object that can be used to
        // make requests.
        val remoteControl = SimpleRemoteControl()
        // The Receiver of the request.
        val light = Light()
        // Create a command and pass the Receiver to it.
        val lightOnCommand = LightOnCommand(light)
        // Pass the command to the Invoker.
        remoteControl.setCommand(lightOnCommand)
        // Simulate the button being pressed.
        remoteControl.buttonWasPressed()
    }
}