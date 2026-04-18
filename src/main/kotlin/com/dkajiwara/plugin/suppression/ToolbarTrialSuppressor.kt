package com.dkajiwara.plugin.suppression

import com.intellij.openapi.actionSystem.ActionManager
import com.intellij.openapi.diagnostic.Logger

internal class ToolbarTrialSuppressor {
    fun suppress(phase: String) {
        runCatching {
            val actionManager = ActionManager.getInstance()
            val trialAction = actionManager.getAction(TrialUiIds.TRIAL_STATE_WIDGET)
            if (trialAction == null) {
                LOG.debug("Trial toolbar action not registered, phase=$phase")
                return
            }

            actionManager.unregisterAction(TrialUiIds.TRIAL_STATE_WIDGET)
            LOG.info("Hid trial widget in toolbar, phase=$phase")
        }.onFailure {
            LOG.warn("Failed to hide trial widget in toolbar, phase=$phase", it)
        }
    }

    companion object {
        private val LOG = Logger.getInstance(ToolbarTrialSuppressor::class.java)
    }
}
