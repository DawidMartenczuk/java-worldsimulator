package pl.dawidmartenczuk.world;

import java.io.Serializable;

public class Organism implements Serializable {


    boolean killed=false;
    protected String name, shortcut;
    protected int initiative, age, strength;
    public boolean movePermission=true;
    protected World world;
    public Position location;

    public Organism(Position pos, World world)
    {
        this.age=0;
        this.location=pos;
        this.world=world;
    }

    public void action()
    {

    };

    public boolean checkCollision(Organism other)
    {
        return true;
    }

    public void collision(Organism attacker, Organism deffender)
    {
        if(attacker.getName()==deffender.getName())
        {
            this.multiply();
            attacker.movePermission=false;
            return;
        }

        if(!this.checkCollision(deffender))return;
        if(!deffender.checkCollision(this))return;

        if(attacker.getStrength()>=deffender.getStrength())
        {
            deffender.kill();
            return;
        }
        attacker.kill();
        return;
    }

    public void kill()
    {
        killed=true;
    }

    public int getAge()
    {
        return this.age;
    }

    public String getName()
    {
        return this.name;
    }

    public String getShortcut()
    {
        return this.shortcut;
    }

    public int getInitiative()
    {
        return this.initiative;
    }

    public Position getLocation()
    {
        return this.location;
    }

    public int getStrength()
    {
        return this.strength;
    }

    public boolean isKilled()
    {
        return killed;
    }

    public void setAge(int age)
    {
        this.age=age;
    }

    public void setStrength(int value)
    {
        this.strength=value;
    }

    protected void multiply() {
    }
}
