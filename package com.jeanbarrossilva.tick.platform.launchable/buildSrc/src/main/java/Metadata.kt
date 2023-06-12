object Metadata {
    const val GROUP = "com.jeanbarrossilva.samm"
    const val ARTIFACT = "samm"
    const val NAMESPACE = GROUP

    fun namespace(suffix: String): String {
        return "$NAMESPACE.$suffix"
    }
}
