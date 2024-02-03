package logic.card;

import logic.player.Player;

public abstract class BaseCard {
    private String name;
    private int power;
    private int health;

    public BaseCard(String name, int power, int health){
        setHealth(health);
        setName(name);
        setPower(power);
    }
    public abstract void play(Player player);

    public abstract boolean canPlay(Player player);

    public int attack(BaseCard target) {
        int ht = Math.max(0,getPower() - target.getHealth());
        target.setHealth(Math.max(0,target.getHealth() - getPower()));
        return ht;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = Math.max(0,power);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.max(0,health);
    }
}

/*
* git init
git commit -m "Abstract"
git branch -M main
git remote add origin https://github.com/Nawakorn23/Abstract.git
git push -u origin main
*
* */