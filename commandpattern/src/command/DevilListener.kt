package command

import receiver.ActionEvent

class DevilListener : ActionListener {
    override fun actionPerformed(event: ActionEvent) {
        println("Come on, do it!")
    }
}