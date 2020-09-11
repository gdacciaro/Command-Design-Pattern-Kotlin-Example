package com.gdacciaro.command_design_pattern_kotlin_example

import android.app.Activity


class StuffCommand(override var isReversible: Boolean,
                   var activity: Activity) : Command {

    override fun execute() {
        TheController.closeTheActivityAfter10Sec(activity)
    }

    override fun unexecute() {
        if(!isReversible)
            return

        TheController.undoCloseTheActivityAfter10Sec(activity)
    }
}