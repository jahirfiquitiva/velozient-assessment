package dev.jahir.velozient.data

import dev.jahir.velozient.models.Drone
import dev.jahir.velozient.models.Location
import dev.jahir.velozient.utils.FileUtils
import dev.jahir.velozient.utils.FormatUtils

object Loader {

    fun loadDronesAndLocationsData(filename: String): Pair<List<Drone>, List<Location>> {
        val fileTextsLines = FileUtils.readFile(filename).toMutableList()

        if (fileTextsLines.isEmpty()) {
            println("The given input file was not found or is empty. Please verify and try again")
            return Pair(listOf(), listOf())
        }

        val dronesData =
            FormatUtils.getTextLineItems(fileTextsLines.removeAt(0))

        val dronesList = try {
            Mapper.textToDronesList(dronesData)
        } catch (e: Exception) {
            println("The given input file has an incorrect format for Drones. Please verify and try again")
            listOf()
        }

        val locationsList = try {
            Mapper.textToLocationsList(fileTextsLines)
        } catch (e: Exception) {
            println("The given input file has an incorrect format for Locations. Please verify and try again")
            listOf()
        }

        return Pair(
            dronesList, locationsList
        )
    }

}
