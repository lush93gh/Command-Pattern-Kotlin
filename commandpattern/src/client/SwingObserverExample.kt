package client

import command.AngelListener
import invoker.JButton

class SwingObserverExample {
    // The Client is the class that sets up the
    // Swing components and sets the commands
    // (AngelListener and DevilListener) in the
    // Invoker (the Button).

    init {
        // Set up ...

        // The button is our Invoker. The button
        // calls the actionPerformed() (like
        // execute()) methods in the commands (the
        // ActionListeners) when you click the button.
        val button = JButton("Should I do it?")

        // AngelListener and DevilListener
        // are our concrete Commands. They
        // implement the command interface (in
        // this case, ActionListener).
        button.addActionListener(AngelListener())
        // button.addActionListener(DevilListener())
    }
}