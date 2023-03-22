package dev.jahir.velozient.utils

import dev.jahir.velozient.models.Drone

object PrintUtils {

    fun printDronesTrips(drones: List<Drone>) {
        for (drone in drones) {
            println("[${drone.name}]")
            drone.trips.forEachIndexed { i, tripLocations ->
                println("Trip #${i + 1}")
                println(tripLocations.joinToString(", ") { "[${it.name}]" })
            }
            println()
        }
    }

}
