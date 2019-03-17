package pl.dawidmartenczuk.world;

import java.io.Serializable;

public class Position implements Serializable{

    public int x, y;

    public Position(int x, int y)
    {
        this.x=x;
        this.y=y;
    }

    public boolean isEqual(Position e)
    {
        if(this.x==e.x && this.y==e.y) {
            return true;
        }
        else {
            return false;
        }
    }
}

