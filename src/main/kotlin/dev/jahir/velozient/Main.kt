package dev.jahir.velozient

import dev.jahir.velozient.data.Delivery
import dev.jahir.velozient.data.Loader
import dev.jahir.velozient.utils.PrintUtils

object Main {
    fun runAlgorithm(filename: String) {
        // Get the drones and locations data from the given filename
        val (drones, locations) = try {
            Loader.loadDronesAndLocationsData(filename)
        } catch (e: Exception) {
            println("The given input file has an incorrect format. Please verify and try again")
            return
        }

        // Check that both lists: drones and locations, have items to run the algorithm
        if (drones.isEmpty() || locations.isEmpty()) {
            println("There's not enough drones or locations data to test. Please verify and try again")
            return
        }

        // Get the list of drones with assigned trips, after processing the initial data
        val dronesWithTrips = Delivery.distributePackagesToDrones(drones, locations.toMutableList())

        // Print the result output for the given data
        PrintUtils.printDronesTrips(dronesWithTrips)
    }
}

fun main() {
    Main.runAlgorithm("input/b.txt")
}
