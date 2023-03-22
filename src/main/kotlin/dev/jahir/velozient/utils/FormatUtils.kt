package dev.jahir.velozient.utils

object FormatUtils {

    // Removes [ and ] to make texts easier to read and parse (in the case of numbers)
    fun cleanInputFileText(text: Sequence<String>): Sequence<String> =
        text.map { line -> line.trim().replace("[", "").replace("]", "") }

    // Splits a string by the comma character "," so we get the items in that line
    fun getTextLineItems(text: String): List<String> =
        text.split(",").map { it.trim() }

}
