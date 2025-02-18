package command

import receiver.ActionEvent

/**
 * ActionListener is the Command
 * Interface: it has one method,
 * actionPerformed() that, like
 * execute(), is executed when the
 * command is invoked.
 */
interface ActionListener {
    fun actionPerformed(event: ActionEvent)
}