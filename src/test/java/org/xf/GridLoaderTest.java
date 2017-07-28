package org.xf;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author rcoqueugniot
 * @since 21.06.17
 */
public class GridLoaderTest {

    private static final int RED = 1;
    private static final int BLUE = 2;

    @Test(expected = BadGridHintException.class)
    public void checkAddingRowCorrectWidth() throws Exception {
        GridLoader.build(5, 5)
                .addRow(Hint.group(2, RED), Hint.group(2, BLUE))
                ;
    }

    @Test(expected = BadGridHintException.class)
    public void checkCorrectHeigth() throws Exception {
        GridLoader.build(5, 5)
                .addColumn(Hint.group(2, RED), Hint.group(2, BLUE))
                ;
    }
    @Test(expected = BadGridHintException.class)
    public void checkCorrectNumberOfRows() throws Exception {
        GridLoader.build(5, 5)
                .addRow(Hint.group(3, RED), Hint.group(2, BLUE))
                .addRow(Hint.group(3, RED), Hint.group(2, BLUE))
                .addRow(Hint.group(3, RED), Hint.group(2, BLUE))
                .addRow(Hint.group(3, RED), Hint.group(2, BLUE))
                .get();
    }

    @Test(expected = BadGridHintException.class)
    public void checkCorrectNumberOfColumns() throws Exception {
        GridLoader.build(5, 5)
                .addColumn(Hint.group(3, RED), Hint.group(2, BLUE))
                .addColumn(Hint.group(3, RED), Hint.group(2, BLUE))
                .addColumn(Hint.group(3, RED), Hint.group(2, BLUE))
                .addColumn(Hint.group(3, RED), Hint.group(2, BLUE))
                .get();
    }

    @Test()
    public void checkCorrectSizes() throws Exception {
        Grid grid = GridLoader.build(5, 5)
                .addRow(Hint.group(3, RED), Hint.group(2, BLUE))
                .addRow(Hint.group(3, RED), Hint.group(2, BLUE))
                .addRow(Hint.group(3, RED), Hint.group(2, BLUE))
                .addRow(Hint.group(3, RED), Hint.group(2, BLUE))
                .addRow(Hint.group(3, RED), Hint.group(2, BLUE))
                .addColumn(Hint.group(3, RED), Hint.group(2, BLUE))
                .addColumn(Hint.group(3, RED), Hint.group(2, BLUE))
                .addColumn(Hint.group(3, RED), Hint.group(2, BLUE))
                .addColumn(Hint.group(3, RED), Hint.group(2, BLUE))
                .addColumn(Hint.group(3, RED), Hint.group(2, BLUE))
                .get();
        Assert.assertEquals(5, grid.getWidth());
        Assert.assertEquals(5, grid.getHeight());
        Assert.assertEquals(5, grid.getRowHints().size());
        Assert.assertEquals(5, grid.getColHints().size());
    }

}
