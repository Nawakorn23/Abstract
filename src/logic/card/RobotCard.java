package logic.card;

import logic.player.Player;

public class RobotCard extends BaseCard{
    private int energyCost;
    public RobotCard(String name, int power, int health, int energyCost){
        super(name,power,health);
        setEnergyCost(energyCost);
    }

    @Override
    public void play(Player player) {
        player.setEnergy(Math.max(0,player.getEnergy() - getEnergyCost()));
        // Subtract player energy by this card’s energy cost. Player’s energy cannot be negative.
    }

    @Override
    public boolean canPlay(Player player) {
        return player.getEnergy() >= getEnergyCost();
    }

    public int getEnergyCost() {
        return energyCost;
    }

    public void setEnergyCost(int energyCost) {
        this.energyCost = Math.max(0,energyCost);
    }
}
