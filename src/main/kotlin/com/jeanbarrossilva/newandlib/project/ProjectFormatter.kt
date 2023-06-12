package com.jeanbarrossilva.newandlib.project

import java.io.IOException

internal object ProjectFormatter {
    fun format(project: Project) {
        ProcessBuilder().command("cd", "${project.path}").start()
        tryToRunKtlint()
    }

    @Suppress("SpellCheckingInspection")
    private fun tryToRunKtlint() {
        try {
            runKtlint()
        } catch (_: IOException) {
            tryToInstallKtlint()
            runKtlint()
        }
    }

    @Suppress("SpellCheckingInspection")
    private fun runKtlint() {
        ProcessBuilder().command("ktlint").start()
    }

    @Suppress("SpellCheckingInspection")
    private fun tryToInstallKtlint() {
        try {
            installKtlint()
        } catch (_: IOException) {
            installHomebrew()
            installKtlint()
        }
    }

    @Suppress("SpellCheckingInspection")
    private fun installKtlint() {
        ProcessBuilder().command("brew", "install", "ktlint").start()
    }

    private fun installHomebrew() {
        ProcessBuilder(
            "/bin/bash",
            "-c",
            "\"\$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)\""
        )
            .start()
    }
}
