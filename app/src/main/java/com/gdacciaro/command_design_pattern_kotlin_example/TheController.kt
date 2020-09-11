package com.gdacciaro.command_design_pattern_kotlin_example

import android.app.Activity
import android.widget.Toast

object TheController {

    private lateinit var thread: Thread

    fun closeTheActivityAfter10Sec(activity: Activity){ /** Example: wait 10 sec and close the app **/
        Toast.makeText(activity, "Goodbye! \uD83D\uDC4B \uD83D\uDE14", Toast.LENGTH_SHORT).show()
        thread = Thread{
            try {
                Thread.sleep(10 * 1000)
                activity.finish()
            }catch (interrupted: InterruptedException){return@Thread}
        }
        thread.start()
    }

    fun undoCloseTheActivityAfter10Sec(activity: Activity){
        Toast.makeText(activity, "Uh, hi again!! \uD83D\uDE0A ", Toast.LENGTH_SHORT).show()
        thread.interrupt()
    }

}