package com.tdd.taxi;

import org.junit.Test;
import sun.security.x509.DeltaCRLIndicatorExtension;

import static junit.framework.TestCase.assertEquals;

/**
 * create by ssmao
 * 2020.06.09
 */

//done 不超过8公里时每公里0.8元
//Todo 超过8公里则每公里加收50%长途费
//Todo 停车等待时加收每分钟0.25元
public class TaxiTest {

    private static final double DELTA = 0.00001;

    private void verfyCalculate(int distance, double expected) {
        final Taxi taxi = new Taxi();
        double actual = taxi.calculate(distance);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void shoule_be_0p8yuan_when_distance_is_1km(){
        verfyCalculate(1, 0.8);
    }

    @Test
    public void shoule_be_6p4yuan_when_distance_is_8km(){
        verfyCalculate(8, 6.4);
    }


}
