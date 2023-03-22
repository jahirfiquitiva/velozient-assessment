package dev.jahir.velozient.utils

import java.io.File

object FileUtils {

    fun readFile(filename: String): List<String> {
        val file = File(filename)
        return file.useLines { FormatUtils.cleanInputFileText(it).toMutableList() }
    }

}
