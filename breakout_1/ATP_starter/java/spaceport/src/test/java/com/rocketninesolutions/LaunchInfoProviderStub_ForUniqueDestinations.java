package com.rocketninesolutions;

import java.util.List;

public class LaunchInfoProviderStub_ForUniqueDestinations implements ISpacelineLaunchInfoProvider {

    @Override
    public List<LaunchInfo> getCurrentLaunches() {
        return List.of(
                createLaunchInfo("Moon"),
                createLaunchInfo("Mars"));
    }

    private LaunchInfo createLaunchInfo(String destination) {
        // create new launch info and populate destination
        LaunchInfo launchInfo = new LaunchInfo(java.util.UUID.randomUUID());
        launchInfo.setDestination(destination);
        return launchInfo;
    }


}
