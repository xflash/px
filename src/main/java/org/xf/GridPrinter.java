package org.xf;

/**
 * @since 22.06.17
 */
public class GridPrinter {
    public void print(Grid grid) {

        //print colors columns for each of the hint rows
        for (int i = 0; i < grid.getNbColors(); i++) {
            printSpaces(grid.getNbColors());
            for (Hint[] hints : grid.getColHints()) {
                for (Hint hint : hints) {
                    if(hint.getColor()==i+1) {
                        printHint(hint);
                    } else {
                        printSpaces(1);
                    }
                }
            }
            System.out.println("");
        }

    }

    private void printHint(Hint hint) {
        System.out.print(hint.getNb());
    }

    private void printSpaces(int spaces) {
        printCharNb(spaces, " ");
    }

    private void printCharNb(int nb, String s) {
        for (int i = 0; i < nb; i++) {
            System.out.print(s);
        }
    }
}
