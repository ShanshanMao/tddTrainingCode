package com.LockertTest;
/**
 * created by ssmao on 20200613
 */

import com.tdd.Locker.Locker;
import com.tdd.Locker.SavePackageFailException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LockerTest {

    private Locker locker;

    @Before
    public void setUp() throws Exception {
        locker = new Locker(10);
    }


    @Test
    public void should_open_a_locker_when_save_a_package_given_locker_is_10_and_have_a_empty(){


        locker.setUsedCount(9);

        String ticket = locker.save();
        assertThat(ticket,is("010"));
    }

    @Test
    public void should_open_a_locker_fail_when_save_a_package_given_locker_is_full(){
        Locker locker = new Locker(10);
        locker.setUsedCount(10);

        try {
            locker.save();
            Assert.fail("Should throw an exception");
        } catch (SavePackageFailException e) {
            assertThat(e, is(instanceOf(SavePackageFailException.class)));
            assertThat(e.getMessage(), is("Lockers are fulled,save package failure!"));
        }
    }

    @Test
    public void should_open_a_locker_when_pick_a_package_given_ticket_available(){
        locker.setUsedCount(9);
        String usedTicket = locker.save();

        boolean success = locker.get(usedTicket);
        assertTrue(success);
    }
}
