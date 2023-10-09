import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class BattleLoc extends Location{
    private Obstacle obstacle;
    private String award;
    private boolean isAward;
    private int maxObstacle;
    public BattleLoc(Player player, String name, Obstacle obstacle, String award, boolean isAward, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.isAward = isAward;
        this.maxObstacle = maxObstacle;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public boolean isAward() {
        return isAward;
    }

    public void setAward(boolean award) {
        isAward = award;
    }

    @Override
    public boolean onLocation() {
        if (this.getName().equals("Mağara") && this.getPlayer().getInventory().isFood()) {
            System.out.println("Mağara bölgesinin ganimetini zaten ele geçirdiniz lütfen başka bölge seçiniz!");
        } else if (this.getName().equals("Orman") && this.getPlayer().getInventory().isFirewood()) {
            System.out.println("Orman bölgesinin ganimetini zaten ele geçirdiniz lütfen başka bölge seçiniz!");
        } else if (this.getName().equals("Nehir") && this.getPlayer().getInventory().isWater()) {
            System.out.println("Nehir bölgesinin ganimetini zaten ele geçirdiniz lütfen başka bölge seçiniz!");
        } else {
            int obsNumber = this.randomObstacleNumber();
            System.out.println("Şu an buradasınız: " + this.getName());
            System.out.println("Dikkatli ol! Burada " + obsNumber + " tane " + this.getObstacle().getName() + " yaşıyor!");
            System.out.print("<S>avaş veya <K>aç: ");
            String selectCase = input.nextLine().toUpperCase();
            if (selectCase.equals("S") && combat(obsNumber)) {
                if (this.getName().equals("Maden")) {
                    setMineAward();
                    System.out.println(this.getName() + " lokasyonundaki tüm düşmanları yendiniz!");
                    System.out.println(this.getName() + " lokasyonundaki " + this.getAward() + " ganimetini ele geçirdiniz!");
                    return true;
                }
                System.out.println(this.getName() + " lokasyonundaki tüm düşmanları yendiniz!");
                System.out.println(this.getName() + " lokasyonundaki " + this.getAward() + " ganimetini ele geçirdiniz!");
                if(this.getName().equals("Mağara")) {
                    this.getPlayer().getInventory().setFood(true);
                } else if (this.getName().equals("Orman")) {
                    this.getPlayer().getInventory().setFirewood(true);
                } else if (this.getName().equals("Nehir")) {
                    this.getPlayer().getInventory().setWater(true);
                }
                return true;
            }
            if (this.getPlayer().getHealth() <= 0) {
                System.out.println("Öldünüz!");
                return false;
            }
        }
        return true;
    }

    public boolean combat(int obsNumber) {
        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
            playerStats();
            obstacleStats(i);
            int turn = (int) (Math.random() * 2) + 1;
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                if (turn == 1) {
                    System.out.print("<V>ur veya <K>aç: ");
                    String selectCombat = input.nextLine().toUpperCase();
                    if (selectCombat.equals("V")) {
                        System.out.println("Siz vurdunuz!");
                        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();
                        if (this.getObstacle().getHealth() > 0) {
                            System.out.println();
                            System.out.println("Canavar size vurdu!");
                            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            if (obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit();
                        }
                    } else {
                        return false;
                    }
                } else {
                    System.out.println("Canavar size vurdu!");
                    int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                    if (obstacleDamage < 0) {
                        obstacleDamage = 0;
                    }
                    this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                    afterHit();
                    if (this.getPlayer().getHealth() > 0) {
                        System.out.print("<V>ur veya <K>aç: ");
                        String selectCombat = input.nextLine().toUpperCase();
                        if (selectCombat.equals("V")) {
                            System.out.println("Siz vurdunuz!");
                            this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                            afterHit();
                        }
                    }
                }
            }
            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("Düşmanı yendiniz!");
                System.out.println(this.getObstacle().getAward() + " para kazandınız!");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Güncel paranız: " + this.getPlayer().getMoney());
            } else {
                return false;
            }
        }
        return true;
    }

    public void afterHit() {
        System.out.println("Canınız: " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " Canı: " + this.getObstacle().getHealth());
        System.out.println("---------------");
    }

    public void playerStats() {
        System.out.println("Oyuncu değerleri");
        System.out.println("---------------------------------------------");
        System.out.println("Sağlık: " + this.getPlayer().getHealth());
        System.out.println("Silah: " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Hasar: " + this.getPlayer().getTotalDamage());
        System.out.println("Zırh: " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama: " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Para: " + this.getPlayer().getMoney());
        System.out.println();
    }

    public void obstacleStats(int i) {
        System.out.println(i + ". " + this.getObstacle().getName() + " Değerleri");
        System.out.println("---------------------------------------------");
        System.out.println("Sağlık: " + this.getObstacle().getHealth());
        System.out.println("Hasar: " + this.getObstacle().getDamage());
        System.out.println("Ödül: " + this.getObstacle().getAward());
        System.out.println();
    }

    public int randomObstacleNumber () {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public void setMineAward () {
        int rand = (int) (Math.random() * 101);
        if (rand >= 0 && rand < 15) {
            int rand1 = (int) (Math.random() * 101);
            if (rand1 >= 0 && rand1 < 20) {
                Weapon w = Weapon.getWeaponObjById(3);
                this.setAward(w.getName());
                this.getPlayer().getInventory().setWeapon(w);
            } else if (rand1 >= 20 && rand1 < 50) {
                Weapon w = Weapon.getWeaponObjById(2);
                this.setAward(w.getName());
                this.getPlayer().getInventory().setWeapon(w);
            } else {
                Weapon w = Weapon.getWeaponObjById(1);
                this.setAward(w.getName());
                this.getPlayer().getInventory().setWeapon(w);
            }
        } else if (rand >= 15 && rand < 30) {
            int rand1 = (int) (Math.random() * 101);
            if (rand1 >= 0 && rand1 < 20) {
                Armor a = Armor.getArmorObjById(3);
                this.setAward(a.getName());
                this.getPlayer().getInventory().setArmor(a);
            } else if (rand1 >= 20 && rand1 < 50) {
                Armor a = Armor.getArmorObjById(2);
                this.setAward(a.getName());
                this.getPlayer().getInventory().setArmor(a);
            } else {
                Armor a = Armor.getArmorObjById(1);
                this.setAward(a.getName());
                this.getPlayer().getInventory().setArmor(a);
            }
        } else if (rand >= 30 && rand < 55) {
            int rand1 = (int) (Math.random() * 101);
            if (rand1 >= 0 && rand1 < 20) {
                Snake s = new Snake();
                s.setAward(10);
                this.setAward("10 Altın");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + s.getAward());
            } else if (rand1 >= 20 && rand1 < 50) {
                Snake s = new Snake();
                s.setAward(5);
                this.setAward("5 Altın");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + s.getAward());
            } else {
                Snake s = new Snake();
                s.setAward(1);
                this.setAward("1 Altın");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + s.getAward());
            }
        } else {
            this.setAward("ıvır zıvır eşya");
        }
    }

}
