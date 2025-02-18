package invoker

import command.ActionListener
import receiver.ActionEvent


class JButton(private val text: String) {
    private val actionListeners = mutableListOf<ActionListener>()

    fun addActionListener(actionListener: ActionListener) {
        actionListeners.add(actionListener)
    }

    fun actionPerformed(event: ActionEvent) {
        for (actionListener in actionListeners) {
            actionListener.actionPerformed(event)
        }
    }
}