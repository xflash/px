package org.xf;

/**
 */
public class Launcher {

    private static int RED = 1;
    private static int BLUE = 2;

    public static void main(String[] args) throws BadGridHintException {

//        Grid grid = GridLoader.build(5, 5, 2)
//                .addRow(Hint.group(3, RED), Hint.group(2, BLUE))
//                .addRow(Hint.group(3, RED), Hint.group(2, BLUE))
//                .addRow(Hint.group(3, RED), Hint.group(2, BLUE))
//                .addRow(Hint.group(3, RED), Hint.group(2, BLUE))
//                .addRow(Hint.group(3, RED), Hint.group(2, BLUE))
//                .addColumn(Hint.group(3, RED), Hint.group(2, BLUE))
//                .addColumn(Hint.group(3, RED), Hint.group(2, BLUE))
//                .addColumn(Hint.group(3, RED), Hint.group(2, BLUE))
//                .addColumn(Hint.group(3, RED), Hint.group(2, BLUE))
//                .addColumn(Hint.group(3, RED), Hint.group(2, BLUE))
//                .get();

        Grid grid = GridLoader.build(3, 3)
                .addRow(Hint.group(3, RED))
                .addRow(Hint.group(3, RED), Hint.group(2, BLUE))
                .addRow(Hint.group(3, RED), Hint.group(2, BLUE))
                .addColumn(Hint.group(3, RED), Hint.group(2, BLUE))
                .addColumn(Hint.group(3, RED), Hint.group(2, BLUE))
                .addColumn(Hint.group(3, RED), Hint.group(2, BLUE))
                .get();

        new GridPrinter()
                .print(grid);

        new GridSolver()
                .solve(grid);


    }
}
