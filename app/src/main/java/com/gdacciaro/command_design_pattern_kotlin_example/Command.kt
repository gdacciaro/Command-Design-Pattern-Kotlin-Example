package com.gdacciaro.command_design_pattern_kotlin_example


interface Command {
    val isReversible: Boolean
    fun execute()
    fun unexecute()
}
