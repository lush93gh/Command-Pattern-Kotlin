package client

import command.*
import invoker.RemoteControl
import receiver.CeilingFan
import receiver.Light
import receiver.Stereo

/**
 * The RemoteLoader creates a number of Command objects
 * that are loaded into the slots of the Remote Control. Each
 * command object encapsulates a request of a home
 * automation device.
 */
class RemoteControlLoader {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            load()
        }

        private fun load() {
            val remoteControl = RemoteControl()

            // Create all the devices in their proper locations.
            val livingRoomLight = Light("Living Room")
            val kitchenLight = Light("Kitchen")
            val ceilingFan = CeilingFan("Living Room")
            val stereo = Stereo("Living Room")

            // Create all the Light Command objects.
            val livingRoomLightOn = LightOnCommand(livingRoomLight)
            val livingRoomLightOff = LightOffCommand(livingRoomLight)
            val kitchenLightOn = LightOnCommand(kitchenLight)
            val kitchenLightOff = LightOffCommand(kitchenLight)

            // Create the On and Off for the ceiling fan.
            val ceilingFanOn = CeilingFanOnCommand(ceilingFan)
            val ceilingFanOff = CeilingFanOffCommand(ceilingFan)

            // Create the stereo On and Off commands.
            val stereoOnWithCD = StereoOnWithCDCommand(stereo, volume = 11)
            val stereoOff = StereoOffCommand(stereo)

            // Load all the commands into the remote slots.
            remoteControl.setCommand(livingRoomLight.toString(), livingRoomLightOn, livingRoomLightOff)
            remoteControl.setCommand(kitchenLight.toString(), kitchenLightOn, kitchenLightOff)
            remoteControl.setCommand(ceilingFan.toString(), ceilingFanOn, ceilingFanOff)
            remoteControl.setCommand(stereo.toString(), stereoOnWithCD, stereoOff)

            // Here’s where we use our toString() method
            // to print each remote slot and the command
            // assigned to it.
            // Note that toString() gets
            // called automatically here, so we don’t have
            // to call toString() explicitly.
            println(remoteControl)

            // Step through each slot and push its On and Off buttons.
            remoteControl.onButtonWasPushed(livingRoomLight.toString())
            remoteControl.offButtonWasPushed(livingRoomLight.toString())
            remoteControl.onButtonWasPushed(kitchenLight.toString())
            remoteControl.offButtonWasPushed(kitchenLight.toString())
            remoteControl.onButtonWasPushed(ceilingFan.toString())
            remoteControl.offButtonWasPushed(ceilingFan.toString())
            remoteControl.onButtonWasPushed(stereo.toString())
            remoteControl.offButtonWasPushed(stereo.toString())
        }
    }
}