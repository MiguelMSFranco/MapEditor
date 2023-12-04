package io.code4all.varbies;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.*;

public class Cell {

    public Rectangle box;

    private boolean filled;



    public Cell(int one, int two, int three, int four) {
        box = new Rectangle(one, two, three, four);
        box.draw();
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public void changeBox() {
        if (isFilled()) {
            box.draw();
            filled = false;
        } else {
            box.fill();
            filled = true;
        }
    }

    public void unfillBox() {
        box.draw();
        filled = false;
    }

    public void fillBox() {
        box.fill();
        filled = true;
    }

    public int getX() {
        return box.getX();
    }

    public int getY() {
        return box.getY();
    }


}
