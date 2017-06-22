package org.xf;

import java.util.BitSet;
import java.util.List;

/**
 */
public class Grid {
    private final int width;
    private final int height;
    private List<Hint[]> rowHints;
    private List<Hint[]> colHints;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Hint[]> getRowHints() {
        return rowHints;
    }

    public void setRowHints(List<Hint[]> rowHints) {
        this.rowHints = rowHints;
    }

    public List<Hint[]> getColHints() {
        return colHints;
    }

    public void setColHints(List<Hint[]> colHints) {
        this.colHints = colHints;
    }
}
