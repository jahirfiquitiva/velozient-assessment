package dev.jahir.velozient.models

data class Drone(val name: String, val maxWeight: Int) {
    val trips = arrayListOf<List<Location>>()

    fun addLocationsToTrip(locations: List<Location>) {
        trips.add(locations)
    }
}
