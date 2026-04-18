package com.dkajiwara.plugin.lifecycle

import com.dkajiwara.plugin.suppression.ToolbarTrialSuppressor
import com.intellij.ide.AppLifecycleListener

internal class TrialAppLifecycleListener : AppLifecycleListener {
    private val toolbarTrialSuppressor = ToolbarTrialSuppressor()

    override fun appFrameCreated(commandLineArgs: MutableList<String>) {
        toolbarTrialSuppressor.suppress("appFrameCreated")
    }

    override fun welcomeScreenDisplayed() {
        toolbarTrialSuppressor.suppress("welcomeScreenDisplayed")
    }
}
