package com.progmatic.labyrinthproject;

import com.progmatic.labyrinthproject.enums.CellType;
import com.progmatic.labyrinthproject.enums.Direction;
import com.progmatic.labyrinthproject.exceptions.CellException;
import com.progmatic.labyrinthproject.exceptions.InvalidMoveException;
import com.progmatic.labyrinthproject.interfaces.Labyrinth;
import com.progmatic.labyrinthproject.interfaces.Player;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author pappgergely
 */
public class LabyrinthImpl implements Labyrinth {
    //Valósítsd meg, hogy a LabyrinthImpl osztály tárolni tudjon egy labirintust!
    private CellType[][] labirinth;
    private Coordinate playerPosition;

    public LabyrinthImpl() {
    }

    @Override
    public int getWidth() {
        try {
            return labirinth.length;
        }catch (NullPointerException e){
            return -1;
        }
    }

    @Override
    public int getHeight() {
        try {
            return labirinth[0].length;
        }catch (NullPointerException e){
            return -1;
        }
    }

    @Override
    public void loadLabyrinthFile(String fileName) {
        try {
            Scanner sc = new Scanner(new File(fileName));
            int width = Integer.parseInt(sc.nextLine());
            int height = Integer.parseInt(sc.nextLine());
            labirinth = new CellType[height][width];
            for (int hh = 0; hh < height; hh++) {
                String line = sc.nextLine();
                for (int ww = 0; ww < width; ww++) {
                    switch (line.charAt(ww)) {
                        case 'W':
                            labirinth[hh][ww] = CellType.WALL;
                            break;
                        case 'E':
                            labirinth[hh][ww] = CellType.END;
                            break;
                        case 'S':
                            labirinth[hh][ww] = CellType.START;
                            break;
                        default:
                            labirinth[hh][ww] = CellType.EMPTY;
                    }
                }
            }
        } catch (FileNotFoundException | NumberFormatException ex) {
            System.out.println(ex.toString());
        }
    }

    @Override
    public CellType getCellType(Coordinate c) throws CellException {
        int row = c.getRow();
        int col = c.getCol();
        try {
            return labirinth[row][col];
        }catch (IndexOutOfBoundsException e){
            throw new CellException(row, col, "Nincs ilyen mező");
        }
    }

    @Override
    public void setSize(int width, int height) {
        labirinth = new CellType[width][height];
        for(int i = 0; i < width; i++){
            for(int j = 0; j <height; j++){
                labirinth[i][j] = CellType.EMPTY;
            }
        }
    }

    @Override
    public void setCellType(Coordinate c, CellType type) throws CellException {
        try {
            labirinth[c.getRow()][c.getCol()] = type;
            if (type.equals(CellType.START)){
                this.playerPosition = c;
            }
        }catch (IndexOutOfBoundsException e){
            throw new CellException(c.getCol(), c.getRow(), "Nincs ilyen mező");
        }
    }

    @Override
    public Coordinate getPlayerPosition() {
        return null;
    }

    @Override
    public boolean hasPlayerFinished() {
        for(int i = 0; i < labirinth.length; i++){
            for(int j = 0; j < labirinth[i].length; j++){
                if(labirinth[i][j].equals(CellType.END)){
                    if(playerPosition.getRow() == i && playerPosition.getCol() == j){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public List<Direction> possibleMoves() {
        return null;
    }

    @Override
    public void movePlayer(Direction direction) throws InvalidMoveException {

    }

}
