package dev.jahir.velozient.utils

import java.io.File

object FileUtils {

    fun readFile(filename: String): List<String> = try {
        val file = File(filename)
        file.useLines { FormatUtils.cleanInputFileText(it).toMutableList() }
    } catch (e: Exception) {
        listOf()
    }

}
