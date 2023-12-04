package io.code4all.varbies;

import jdk.nashorn.internal.ir.IfNode;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {
    public static final int PADDING = 10;

    private int cellSize = 20;

    private int gridSize = 25;

    private int totalCells;

    private Rectangle grid;

    public Cell[] cells;


    public Grid(int gridSize) {
        int horizonalCounter = 0;
        int verticalCounter = 0;
        int iterator = 0;
        if (gridSize > 10 && gridSize < 101) {
                this.gridSize = gridSize;
        }
        grid = new Rectangle(PADDING, PADDING, border(), border());
        this.totalCells = (gridSize) * (gridSize);
        grid.draw();

        cells = new Cell[totalCells];

        while (horizonalCounter < gridSize) {
            if (iterator == 625) {
                return;
            }
            cells[iterator] = new Cell(horizonalCounter*cellSize+PADDING, verticalCounter*cellSize+PADDING, cellSize, cellSize);
            iterator++;
            horizonalCounter++;
            if (horizonalCounter == gridSize && verticalCounter < gridSize) {
                horizonalCounter = 0;
                verticalCounter++;
            }
        }
    }

    public int getCellSize() {
        return cellSize;
    }

    public int getGridSize() {
        return gridSize;
    }

    public int border() {
        return gridSize * cellSize;
    }




   public Cell[] getArray() {
        return cells;
    }






}
