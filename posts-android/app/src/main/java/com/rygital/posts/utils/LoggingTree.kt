package com.rygital.posts.utils

import timber.log.Timber

class LoggingTree : Timber.DebugTree() {

    override fun createStackElementTag(element: StackTraceElement): String? =
        findCaller(Thread.currentThread()).let {
            "Demo (${it.fileName}:${it.lineNumber})"
        }

    private fun findCaller(thread: Thread): StackTraceElement {
        val loggerClassName = Timber::class.java.name
        var lastCallerIsLoggerClass = false
        for (caller in thread.stackTrace) {
            val isLoggerClass = caller.className.startsWith(loggerClassName, ignoreCase = true)
            if (lastCallerIsLoggerClass && !isLoggerClass) {
                return caller
            }
            lastCallerIsLoggerClass = isLoggerClass
        }

        return thread.stackTrace[4]
    }
}
