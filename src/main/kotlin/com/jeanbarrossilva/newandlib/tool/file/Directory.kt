package com.jeanbarrossilva.newandlib.tool.file

abstract class Directory : File() {
    protected abstract val children: List<File>

    final override fun write() {
        super.write()
        onWrite()
        children.forEach(File::write)
    }

    protected open fun onWrite() {
    }
}
