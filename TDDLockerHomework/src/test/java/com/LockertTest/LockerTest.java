package com.LockertTest;
/**
 * created by ssmao on 20200613
 */

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LockerTest {

    @Test
    public void should_open_a_locker_when_save_a_package_given_loacker_is_10_and_have_a_empty(){
        Locker locker = new Locker(10);
        Locker.setUsedCount(9);

        String ticket = locker.save();
        assertThat(ticket,is("010"));
    }
}
