package dev.jahir.velozient.data

import dev.jahir.velozient.models.Drone
import dev.jahir.velozient.models.Location
import dev.jahir.velozient.utils.FormatUtils

object Mapper {

    fun textToDronesList(texts: List<String>): List<Drone> {
        val dronesList = arrayListOf<Drone>()
        for (index in texts.indices step 2) {
            dronesList.add(Drone(texts[index], texts[index + 1].toInt()))
        }
        return dronesList
    }

    fun textToLocationsList(texts: List<String>): List<Location> {
        return texts.map { line ->
            val data = FormatUtils.getTextLineItems(line)
            Location(data[0], data[1].toInt())
        }
    }

}
