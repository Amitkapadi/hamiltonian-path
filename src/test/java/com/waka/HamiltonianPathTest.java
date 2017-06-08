package com.waka;

import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by canoztokmak on 08/06/2017.
 */
public class HamiltonianPathTest {

    @Test
    public void testAssertPathFound() {
        int boardSize = 5;
        HamiltonianPath hamiltonianPath = new HamiltonianPath(boardSize);
        int[] path = hamiltonianPath.findPath(0, 0);

        Assert.assertNotNull(path);
        Assert.assertEquals(path.length, boardSize * boardSize);
    }

    @Test
    public void testAssertReusedInstance() {
        int boardSize = 5;
        HamiltonianPath hamiltonianPath = new HamiltonianPath(boardSize);
        int[] path1 = hamiltonianPath.findPath(0, 0);
        int[] path2 = hamiltonianPath.findPath(1, 1);

        Assert.assertNotNull(path1);
        Assert.assertNotNull(path2);
        Assert.assertEquals(path1.length, boardSize * boardSize);
        Assert.assertEquals(path2.length, boardSize * boardSize);
        Assert.assertThat(path1, IsNot.not(IsEqual.equalTo(path2)));
    }

    @Test
    public void testAssertNoPathFound() {
        int boardSize = 4;
        HamiltonianPath hamiltonianPath = new HamiltonianPath(boardSize);
        int[] path = hamiltonianPath.findPath(0, 0);

        Assert.assertNull(path);
    }
}
