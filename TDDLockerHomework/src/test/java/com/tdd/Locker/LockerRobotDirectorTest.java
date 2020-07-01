package com.tdd.Locker;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;

public class LockerRobotDirectorTest {

    @Test
    public void should_return_report_when_LockerRobotDirector_check_report_given_LockerRobotManager_manage_2_lockers(){
        Locker firstLocker = new Locker(3);
        Locker secondLocker = new Locker(4);
        LockerRobotManager lockerRobotManager = new LockerRobotManager(asList(firstLocker,secondLocker), Collections.emptyList());
        LockerRobotDirector lockerRobotDirector = new LockerRobotDirector(singletonList(lockerRobotManager));

        Bag myBag = new Bag();
        lockerRobotManager.store(myBag);

        String report = lockerRobotDirector.checkReport();
        String expectReport = "M 6 7\n" +
                "\tL 2 3\n"+
                "\tL 4 4\n";
        assertEquals(expectReport,report);
    }

    @Test
    public void should_return_report_when_LockerRobotDirector_check_report_given_LockerRobotManager_manage_1_locker_and_1_robot(){
        Locker firstLocker = new Locker(5);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(singletonList(new Locker(10)));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(singletonList(firstLocker),singletonList(primaryLockerRobot));
        LockerRobotDirector lockerRobotDirector = new LockerRobotDirector(singletonList(lockerRobotManager));

        Bag myBag = new Bag();
        firstLocker.store(myBag);
        myBag = new Bag();
        lockerRobotManager.store(myBag);

        String report = lockerRobotDirector.checkReport();
        String expectReport = "M 13 15\n"+
                "\tL 4 5\n"+
                "\tR 9 10\n"+
                "\t\tL 9 10\n";
        assertEquals(expectReport,report);
    }


}
