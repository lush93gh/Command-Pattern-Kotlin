package command

import receiver.ActionEvent

class AngelListener : ActionListener {
    override fun actionPerformed(event: ActionEvent) {
        // The Receiver in this example is the System object.
        // Invoking a command results in actions on
        // the Receiver. In a typical Swing application this would
        // result in calling actions on other components in the UI.
        println("Don't do it, you might regret it!")
    }
}