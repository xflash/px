package org.xf;

/**
 */
public class Hint {
    private final HintType type;
    private final int nb;
    private final int color;

    private Hint(HintType type, int nb, int color) {

        this.type = type;
        this.nb = nb;
        this.color = color;
    }

    public static Hint group(int nb, int color) {
        return new Hint(HintType.GROUP, nb, color);
    }

    public HintType getType() {
        return type;
    }

    public int getNb() {
        return nb;
    }

    public int getColor() {
        return color;
    }
}
