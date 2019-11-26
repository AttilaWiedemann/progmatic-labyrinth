package com.progmatic.labyrinthproject;

import com.progmatic.labyrinthproject.enums.Direction;
import com.progmatic.labyrinthproject.interfaces.Labyrinth;
import com.progmatic.labyrinthproject.interfaces.Player;

import java.util.Random;

public class RandomPlayer implements Player {

    @Override
    public Direction nextMove(Labyrinth l) {
        /*
        Random r = new Random();
        switch (r.nextInt(4)) {
            case 0:
                if(l.ge)
                return Direction.NORTH;
            case 1:
                return Direction.SOUTH;
            case 2:
                return Direction.WEST;
            default:
                return Direction.EAST;
        }

         */
        return null;
    }
}
