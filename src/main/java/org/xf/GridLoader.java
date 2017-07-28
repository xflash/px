package org.xf;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 */
public class GridLoader {

    private final Grid builded;
    private final ArrayList<Hint[]> rows;
    private final ArrayList<Hint[]> cols;

    private GridLoader(int width, int height) {
        builded = new Grid(width, height);
        rows = new ArrayList<Hint[]>();
        cols = new ArrayList<Hint[]>();
    }

    public static GridLoader build(int width, int height) {
        return new GridLoader(width, height);
    }

    public GridLoader addRow(Hint... hints) throws BadGridHintException {
        int nb = countHintsTotal(hints);
        if (nb != builded.getWidth()) {
            throw new BadGridHintException("Total number of hints " + nb + " is not correct for a Grid of Width " + builded.getWidth());
        }
        rows.add(hints);
        return this;
    }

    public GridLoader addColumn(Hint... hints) throws BadGridHintException {
        int nb = countHintsTotal(hints);
        if (nb != builded.getHeight()) {
            throw new BadGridHintException("Total number of hints " + nb + " is not correct for a Grid of Heigth " + builded.getHeight());
        }
        cols.add(hints);
        return this;
    }

    private int countHintsTotal(Hint[] hints) {
        int nb = 0;
        for (Hint hint : hints) {
            nb += hint.getNb();
        }
        return nb;
    }

    public Grid get() throws BadGridHintException {
        if (rows.size() != builded.getHeight())
            throw new BadGridHintException("Number of rows " + rows.size()
                    + " is not correct for a Grid of Heigth " + builded.getHeight());
        if (cols.size() != builded.getWidth())
            throw new BadGridHintException("Number of columns " + cols.size()
                    + " is not correct for a Grid of Width " + builded.getWidth());

        builded.setColors(collectColors(rows));
        builded.setColHints(cols);
        builded.setRowHints(rows);
        return builded;
    }

    private List<Integer> collectColors(List<Hint[]> hintList) {

        Set<Integer> colors = new LinkedHashSet<Integer>();
        for (Hint[] hints : hintList) {
            for (Hint hint : hints) {
                colors.add(hint.getColor());
            }
        }

        return new ArrayList<Integer>(colors);

    }
}
