package logic.card;

import logic.player.Player;

public class MageCard extends BaseCard{
    private Element mageType;
    public MageCard(String name, int power, int health, Element mageType){
        super(name, power, health);
        setMageType(mageType);
    }

    public Element getMageType() {
        return mageType;
    }

    public void setMageType(Element mageType) {
        this.mageType = mageType;
    }

    @Override
    public void play(Player player) {
        int same = 0;
        for (BaseCard baseCard : player.getField()){
            if (baseCard instanceof OrbCard){
                if (((OrbCard)baseCard).getOrbType().equals(getMageType())){
                    same++;
                }
            }
        }
        setPower(getPower() + same);
        // Increase this card’s attack power by number of orb card with the same element on player’s field.
     }

    @Override
    public boolean canPlay(Player player) {
        for (BaseCard baseCard : player.getField()){
            if (baseCard instanceof OrbCard){
                if (((OrbCard)baseCard).getOrbType().equals(getMageType())){
                    return true;
                }
            }
        }
        return false;
        // Return true if player have orb card with the same element on player’s field. Otherwise, return false.
    }
}
