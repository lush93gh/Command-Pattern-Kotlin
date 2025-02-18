package client

import command.*
import invoker.RemoteControlWithUndo
import receiver.*

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
            //load()
            // loadCeilingFan()
            loadMacroCommand()
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

        private fun loadCeilingFan() {
            val remoteControl = RemoteControlWithUndo()

            // Create a Light.
            val ceilingFan = CeilingFan("Living Room")

            // Instantiate three commands: medium, high, and off.
            val ceilingFanMedium = CeilingFanCommand(ceilingFan, CeilingFan.Speed.Medium)
            val ceilingFanHigh = CeilingFanCommand(ceilingFan, CeilingFan.Speed.High)
            val ceilingFanOff = CeilingFanCommand(ceilingFan, CeilingFan.Speed.Off)

            // Put medium and high in slot. We also load up the off command.
            remoteControl.setCommand(ceilingFanMedium.toString(), ceilingFanMedium, ceilingFanOff)
            remoteControl.setCommand(ceilingFanHigh.toString(), ceilingFanHigh, ceilingFanOff)

            remoteControl.onButtonWasPushed(ceilingFanMedium.toString())
            remoteControl.offButtonWasPushed(ceilingFanMedium.toString())
            print(remoteControl)
            remoteControl.undoButtonWasPushed()
            remoteControl.onButtonWasPushed(ceilingFanHigh.toString())
            print(remoteControl)
            remoteControl.undoButtonWasPushed()
        }

        private fun loadMacroCommand() {
            val remoteControl = RemoteControlWithUndo()

            // Create all the devices: a light, tv, stereo, and hot tub.
            val light = Light("Living Room")
            val tv = TV("Living Room")
            val stereo = Stereo("Living Room")
            val hottub = Hottub()

            // Create all the On commands to control them.
            val lightOn = LightOnCommand(light)
            val stereoOn = StereoOnCommand(stereo)
            val tvOn = TVOnCommand(tv)
            val hottubOn = HottubOnCommand(hottub)

            // TODO Off buttons


            // Create an array for On commands and an array for Off commands.
            val partyOn = listOf(lightOn, stereoOn, tvOn, hottubOn)
            // val partyOff = listOf(lightOff, stereoOff, tvOff, hottubOff)

            // Create two corresponding macros to hold commands.
            val partyOnMacro = MacroCommand(partyOn)
            // val partyOffMacro = MacroCommand(partyOff)

            // Assign the macro command to a button.
            // remoteControl.setCommand(MacroCommand::javaClass.name, partyOnMacro, partyOffMacro)

            println(remoteControl)
            println("--- Pushing Macro On---")
            remoteControl.onButtonWasPushed(MacroCommand::javaClass.name)
            println("--- Pushing Macro Off---")
            remoteControl.offButtonWasPushed(MacroCommand::javaClass.name)
        }
    }
}