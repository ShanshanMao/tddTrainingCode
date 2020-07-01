package com.tdd.Locker;

import java.util.List;

public class LockerRobotDirector {

    private final List<LockerRobotManager> managers;

    public LockerRobotDirector(List<LockerRobotManager> managers) {
        this.managers = managers;
    }

    public String checkReport() {
        return managers.stream()
                .map(LockerRobotManager::getReport).reduce("",(partialReport,managerReport) -> partialReport + managerReport);
    }
}
