package com.dkajiwara.plugin.lifecycle

import com.dkajiwara.plugin.suppression.ToolbarTrialSuppressor
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.ProjectActivity

internal class TrialPostStartupActivity : ProjectActivity {
    private val toolbarTrialSuppressor = ToolbarTrialSuppressor()

    override suspend fun execute(project: Project) {
        toolbarTrialSuppressor.suppress("postStartupActivity")
    }
}
