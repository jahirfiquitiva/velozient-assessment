package dev.jahir.velozient.data

import dev.jahir.velozient.models.Drone
import dev.jahir.velozient.models.Location
import dev.jahir.velozient.utils.FileUtils
import dev.jahir.velozient.utils.FormatUtils

object Loader {

    fun loadDronesAndLocationsData(filename: String): Pair<List<Drone>, List<Location>> {
        val fileTextsLines = FileUtils.readFile(filename).toMutableList()

        val dronesData = FormatUtils.getTextLineItems(fileTextsLines.removeAt(0))

        return Pair(
            Mapper.textToDronesList(dronesData),
            Mapper.textToLocationsList(fileTextsLines)
        )
    }

}
