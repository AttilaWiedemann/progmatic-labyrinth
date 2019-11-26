package com.progmatic.labyrinthproject;

import com.progmatic.labyrinthproject.enums.Direction;
import com.progmatic.labyrinthproject.interfaces.Labyrinth;
import com.progmatic.labyrinthproject.interfaces.Player;

import java.util.ArrayList;
import java.util.List;

public class WallFollowerPlayer implements Player {
    private int roundCounter = 1;
    private Direction myWay;
    private String preferedDirection = "right";

    public WallFollowerPlayer(String preferedDirection) {
        this.preferedDirection = preferedDirection;
    }

    @Override
    public Direction nextMove(Labyrinth l) {
        List<Direction> possibleMoves = l.possibleMoves();
        if (roundCounter == 1) {
            roundCounter++;
            myWay = l.possibleMoves().get(0); //starts at the first possible way
            return l.possibleMoves().get(0);
        } else {
            if (myWay.equals(Direction.NORTH)) {
                if (possibleMoves.contains(Direction.EAST)) { //If there is a crossing and can turn right
                    myWay = Direction.EAST;
                    return myWay;
                }
                if (possibleMoves.contains(myWay)) {
                    return myWay;
                }
                if (possibleMoves.contains(Direction.WEST)) {    //If there is a crossing but can't turn right
                    myWay = Direction.WEST;
                    return myWay;
                } else {
                    myWay = Direction.SOUTH;    //If only option is to turn back
                    return myWay;
                }
            } else if (myWay.equals(Direction.SOUTH)) {
                if (possibleMoves.contains(Direction.WEST)) {
                    myWay = Direction.WEST;
                    return myWay;
                }
                if (possibleMoves.contains(myWay)) {
                    return myWay;
                }
                if (possibleMoves.contains(Direction.EAST)) {
                    myWay = Direction.EAST;
                    return myWay;
                } else {
                    myWay = Direction.NORTH;
                    return myWay;
                }
            } else if (myWay.equals(Direction.WEST)) {
                if (possibleMoves.contains(Direction.NORTH)) {
                    myWay = Direction.NORTH;
                    return myWay;
                }
                if (possibleMoves.contains(myWay)) {
                    return myWay;
                }
                if (possibleMoves.contains(Direction.SOUTH)) {
                    myWay = Direction.SOUTH;
                    return myWay;
                } else {
                    myWay = Direction.EAST;
                    return myWay;
                }
            } else if (myWay.equals(Direction.EAST)) {
                if (possibleMoves.contains(Direction.SOUTH)) {
                    myWay = Direction.SOUTH;
                    return myWay;
                }
                if (possibleMoves.contains(myWay)) {
                    return myWay;
                }
                if (possibleMoves.contains(Direction.NORTH)) {
                    myWay = Direction.NORTH;
                    return myWay;
                } else {
                    myWay = Direction.WEST;
                    return myWay;
                }
            }
        }
        return null;
    }
}
