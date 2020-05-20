package algorithm.onlineassesment.amazon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;


class PartitionLabelsTest {
PartitionLabels partitionLabels = new PartitionLabels();
    @Test
    void partitionLabels() {
        String in = "ababcbacadefegdehijhklij";
        List<Integer> expected = Arrays.asList(9,7,8);
        List<Integer> actual = partitionLabels.partitionLabels(in);
        assertThat(actual, is(expected));
    }

    @Test
    void partitionLabels1() {
        String in = "caedbdedda";
        List<Integer> expected = Arrays.asList(1,9);
        List<Integer> actual = partitionLabels.partitionLabels(in);
        assertThat(actual, is(expected));
    }
}