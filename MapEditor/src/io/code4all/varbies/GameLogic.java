package io.code4all.varbies;

public class GameLogic {
    Grid grid;
    Cursor cursor;


    public void init(int gridSize) {
        grid = new Grid(gridSize);
        cursor = new Cursor();
        cursor.init(grid);


    }
}
