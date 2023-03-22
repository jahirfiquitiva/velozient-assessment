package dev.jahir.velozient.data

import dev.jahir.velozient.models.Drone
import dev.jahir.velozient.models.Location

object Delivery {

    fun distributePackagesToDrones(drones: List<Drone>, locations: MutableList<Location>): List<Drone> {
        var currentTripLocations = arrayListOf<Location>()
        var assignedDroneForTrip: Drone? = null
        for (location in locations) {
            // The current trip weight is equal to the sum of the current trip locations packages weights
            val currentTripWeight: Int =
                currentTripLocations.fold(0) { last, curr -> last + curr.packageWeight }

            // Check each drone to see if it can carry the current location package weight
            var currentLocationAssigned = false
            for (drone in drones) {
                // If the drone can carry the current trip carried weight, plus the current location weight
                if (currentTripWeight + location.packageWeight <= drone.maxWeight) {
                    currentTripLocations.add(location)
                    // Assigned this location to this drone
                    assignedDroneForTrip = drone
                    // Mark the current location as assigned for this trip
                    currentLocationAssigned = true
                    // Break the loop to continue with the next location
                    break
                }
            }

            // If the current location was not assigned, it means that there's no drone that can carry the
            // current location package,
            // so we set the current trip locations to the last assigned drone
            // and then set the current trip locations to just the current location, to prevent losing its state
            if (!currentLocationAssigned) {
                assignedDroneForTrip?.addLocationsToTrip(currentTripLocations)
                currentTripLocations = arrayListOf(location)
            }
        }

        // Add the last assigned trip locations to the last assigned drone
        if (currentTripLocations.isNotEmpty())
            assignedDroneForTrip?.addLocationsToTrip(currentTripLocations)

        return drones
    }

}
