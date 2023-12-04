package io.code4all.varbies;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.*;

public class Cursor implements KeyboardHandler {
    public Rectangle box;

    private Grid grid;

    private int posX;

    private int posY;

    private int moveAmount = 1;

    private boolean isPressed;


    public void init(Grid grid) {
        this.grid = grid;
        Keyboard keyboard = new Keyboard(this);
        box = new Rectangle(Grid.PADDING, Grid.PADDING, grid.getCellSize(), grid.getCellSize());
        box.setColor(Color.MAGENTA);
        box.fill();
        KeyboardEvent pressedUp = new KeyboardEvent();
        pressedUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedUp.setKey(KeyboardEvent.KEY_UP);
        keyboard.addEventListener(pressedUp);

        KeyboardEvent pressedDown = new KeyboardEvent();
        pressedDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedDown.setKey(KeyboardEvent.KEY_DOWN);
        keyboard.addEventListener(pressedDown);

        KeyboardEvent pressedW = new KeyboardEvent();
        pressedW.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedW.setKey(KeyboardEvent.KEY_W);
        keyboard.addEventListener(pressedW);

        KeyboardEvent pressedS = new KeyboardEvent();
        pressedS.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedS.setKey(KeyboardEvent.KEY_S);
        keyboard.addEventListener(pressedS);

        KeyboardEvent pressedLeft = new KeyboardEvent();
        pressedLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(pressedLeft);

        KeyboardEvent pressedA = new KeyboardEvent();
        pressedA.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedA.setKey(KeyboardEvent.KEY_A);
        keyboard.addEventListener(pressedA);

        KeyboardEvent pressedD = new KeyboardEvent();
        pressedD.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedD.setKey(KeyboardEvent.KEY_D);
        keyboard.addEventListener(pressedD);

        KeyboardEvent pressedRight = new KeyboardEvent();
        pressedRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(pressedRight);

        KeyboardEvent pressedSpace = new KeyboardEvent();
        pressedSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(pressedSpace);

        KeyboardEvent releasedSpace = new KeyboardEvent();
        releasedSpace.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releasedSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(releasedSpace);

        KeyboardEvent pressedR = new KeyboardEvent();
        pressedR.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedR.setKey(KeyboardEvent.KEY_R);
        keyboard.addEventListener(pressedR);

        KeyboardEvent pressedC = new KeyboardEvent();
        pressedC.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedC.setKey(KeyboardEvent.KEY_C);
        keyboard.addEventListener(pressedC);

        KeyboardEvent pressedT = new KeyboardEvent();
        pressedT.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedT.setKey(KeyboardEvent.KEY_T);
        keyboard.addEventListener(pressedT);

        KeyboardEvent pressedY = new KeyboardEvent();
        pressedY.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedY.setKey(KeyboardEvent.KEY_Y);
        keyboard.addEventListener(pressedY);

        KeyboardEvent pressedH = new KeyboardEvent();
        pressedH.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedH.setKey(KeyboardEvent.KEY_H);
        keyboard.addEventListener(pressedH);


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        int key = keyboardEvent.getKey();

        switch (key) {

            case KeyboardEvent.KEY_UP:
            case KeyboardEvent.KEY_W:
                moveUp();
                if (isPressed) {
                    draw();
                }
                break;
            case KeyboardEvent.KEY_DOWN:
            case KeyboardEvent.KEY_S:
                moveDown();
                if (isPressed) {
                    draw();
                }
                break;
            case KeyboardEvent.KEY_LEFT:
            case KeyboardEvent.KEY_A:
                moveLeft();
                if (isPressed) {
                    draw();
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
            case KeyboardEvent.KEY_D:
                moveRight();
                if (isPressed) {
                    draw();
                }
                break;
            case KeyboardEvent.KEY_SPACE:
                draw();
                isPressed = true;
                break;
            /** Try To Fix this */

            case KeyboardEvent.KEY_C:
                clear();
                break;
            case KeyboardEvent.KEY_R:
                reverse();
                break;
            case KeyboardEvent.KEY_T:
                write();
                break;
            case KeyboardEvent.KEY_Y:
                read();
                break;

            case KeyboardEvent.KEY_H:
                readSecret();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.KEY_SPACE == keyboardEvent.getKey()) {
            isPressed = false;
        }
    }

    public int translateY() {
        return box.getY() * grid.getCellSize();
    }

    public int translateX() {
        return box.getX() * grid.getCellSize();
    }


    public void moveDown() {
        if (box.getY() + moveAmount < grid.border() - Grid.PADDING)
            box.translate(0, grid.getCellSize() * moveAmount);

    }


    public void moveUp() {
        if (box.getY() - moveAmount > Grid.PADDING)
            box.translate(0, grid.getCellSize() * -moveAmount);
    }

    public void moveRight() {
        if (box.getX() + moveAmount < grid.border() - Grid.PADDING)
            box.translate(grid.getCellSize() * moveAmount, 0);

    }

    public void moveLeft() {
        if (box.getX() - moveAmount > Grid.PADDING)
            box.translate(grid.getCellSize() * -moveAmount, 0);
    }

    public void draw() {
        for (int i = 0; i < grid.getArray().length; i++) {
            if (grid.getArray()[i].getX() == box.getX() && grid.getArray()[i].getY() == box.getY()) {
                grid.getArray()[i].changeBox();
            }
        }
    }

    public void reverse() {
        for (int i = 0; i < grid.getArray().length; i++) {
            grid.getArray()[i].changeBox();

        }
    }

    public void clear() {
        for (int i = 0; i < grid.getArray().length; i++) {
            grid.getArray()[i].unfillBox();

        }
    }

    public void write() {

        try {

            FileOutputStream writer = new FileOutputStream("/Users/codecadet/Documents/my-exercises/Season1/MapEditor/resources/savefile.txt");
            for (int i = 0; i < grid.getArray().length; i++) {
                if (grid.getArray()[i].isFilled()) {
                    writer.write(1);
                } else {
                    writer.write(0);
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }

    }

    public void read() {
        try {
            int counter = 0;
            FileInputStream reader = new FileInputStream("/Users/codecadet/Documents/my-exercises/Season1/MapEditor/resources/savefile.txt");
            int firstValue = reader.read();
            for (int i = 0; i < grid.getArray().length; i++) {
                if (firstValue == 1) {
                    grid.getArray()[counter].fillBox();
                } else {
                    grid.getArray()[counter].unfillBox();
                }
                counter++;
                firstValue = reader.read();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }
    }

    public void readSecret() {
        try {
            int counter = 0;
            FileInputStream reader = new FileInputStream("/Users/codecadet/Documents/my-exercises/Season1/MapEditor/resources/secret.txt");
            int firstValue = reader.read();
            for (int i = 0; i < grid.getArray().length; i++) {
                if (firstValue == 1) {
                    grid.getArray()[counter].fillBox();
                } else {
                    grid.getArray()[counter].unfillBox();
                }
                counter++;
                firstValue = reader.read();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }
    }


}
