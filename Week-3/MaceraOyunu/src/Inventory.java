public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private boolean isFood;
    private boolean isFirewood;
    private boolean isWater;

    public Inventory(boolean isFood, boolean isFirewood, boolean isWater) {
        this.weapon = new Weapon("Yumruk", -1, 0,0);
        this.armor = new Armor(-1, "Paçavra", 0,0);
        this.isFood = isFood;
        this.isFirewood = isFirewood;
        this.isWater = isWater;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public boolean isFood() {
        return isFood;
    }

    public void setFood(boolean food) {
        isFood = food;
    }

    public boolean isFirewood() {
        return isFirewood;
    }

    public void setFirewood(boolean firewood) {
        isFirewood = firewood;
    }

    public boolean isWater() {
        return isWater;
    }

    public void setWater(boolean water) {
        isWater = water;
    }
}
