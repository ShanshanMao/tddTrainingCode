package com.GiledeRose;

import com.giledeRose.Item;
import org.junit.Test;

import static com.giledeRose.Item.createBackstagePass;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class itemTest {

    @Test
    public void should_double_increase_backstage_pass_value_when_getting_close_to_expiration(){
        Item item = createBackstagePass (11,20);
        item.passOneDay();
        assertThat(item.quality,is(21));
        item.passOneDay();
        assertThat(item.quality,is(23));

    }
}
