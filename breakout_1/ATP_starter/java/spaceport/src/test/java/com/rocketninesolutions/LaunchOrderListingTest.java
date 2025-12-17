package com.rocketninesolutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LaunchOrderListingTest {

    //TODO - Use the Stub Recipe to test that launches are sorted correctly
    @Test
    void LaunchesAre_SortedByDestination_DestinationsAreUnique() {
        // Step 1. Create LaunchInfoProviderStub (that implements ISpacelineLaunchInfoProvider)
        LaunchInfoProviderStub_ForUniqueDestinations stub = new LaunchInfoProviderStub_ForUniqueDestinations();

        // Step 2 & 3 & 4. Create SUT - SpaceportDepartureBoard, using Constructor Injection
        // Exercising this behavior happens during construction of the System Under Test
        SpaceportDepartureBoard sut = new SpaceportDepartureBoard( stub );

        // Step 5. Verify the results are sorted correctly
        Assertions.assertEquals("Mars", sut.getLaunchList().get(0).getDestination());
        Assertions.assertEquals("Moon", sut.getLaunchList().get(1).getDestination());
    }
}
