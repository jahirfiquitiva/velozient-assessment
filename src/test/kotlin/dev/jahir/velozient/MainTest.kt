package dev.jahir.velozient

import dev.jahir.velozient.data.Delivery
import dev.jahir.velozient.data.Loader
import kotlin.test.Test
import kotlin.test.assertEquals

internal class MainTest {

    @Test
    fun `Test input file A`() {
        val (drones, locations) = Loader.loadDronesAndLocationsData("input/a.txt")
        assertEquals(3, drones.size, "3 drones loaded")
        assertEquals(16, locations.size, "16 locations loaded")

        val dronesWithTrips = Delivery.distributePackagesToDrones(drones, locations.toMutableList())
        val tripsCount = dronesWithTrips.fold(0) { last, curr -> last + curr.trips.size };
        assertEquals(6, tripsCount, "6 trips are optimal")
    }

    @Test
    fun `Test input file B`() {
        val (drones, locations) = Loader.loadDronesAndLocationsData("input/b.txt")
        assertEquals(3, drones.size, "3 drones loaded")
        assertEquals(10, locations.size, "10 locations loaded")

        val dronesWithTrips = Delivery.distributePackagesToDrones(drones, locations.toMutableList())
        val tripsCount = dronesWithTrips.fold(0) { last, curr -> last + curr.trips.size };
        assertEquals(4, tripsCount, "4 trips are optimal")
    }

    @Test
    fun `Test input file C`() {
        val (drones, locations) = Loader.loadDronesAndLocationsData("input/c.txt")
        assertEquals(2, drones.size, "2 drones loaded")
        assertEquals(7, locations.size, "7 locations loaded")

        val dronesWithTrips = Delivery.distributePackagesToDrones(drones, locations.toMutableList())
        val tripsCount = dronesWithTrips.fold(0) { last, curr -> last + curr.trips.size };
        assertEquals(4, tripsCount, "4 trips are optimal")
    }

}
