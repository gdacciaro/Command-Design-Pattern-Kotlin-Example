package com.gdacciaro.command_design_pattern_kotlin_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //               ⬇️ ⬇️ ⬇️ ⬇️
        val command: Command = StuffCommand(isReversible = true, this@MainActivity)
        //               ⬆️ ⬆️ ⬆️ ⬆️

        naiveButton.setOnClickListener {
            TheController.closeTheActivityAfter10Sec(this@MainActivity)
        }
        naiveUndo.setOnClickListener {
            TheController.undoCloseTheActivityAfter10Sec(this@MainActivity)
        }

        /** The buttons DON'T KNOW who the Receiver is ! **/
        correctButton.setOnClickListener {
            command.execute()
        }
        correctUndo.setOnClickListener {
            command.unexecute()
        }
    }
}