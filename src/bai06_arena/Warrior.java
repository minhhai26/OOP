package bai06_arena;
/**
 * Lớp đại diện cho một Chiến binh, một loại nhân vật cận chiến.
 */
public class Warrior extends Character {
    private int rage;

    public Warrior(String name, int maxHealth, int attackPower) {
        super(name, maxHealth, attackPower);
        this.rage = 0; // Bắt đầu với 0 Nộ
    }

    /**
     * {@inheritDoc}
     * Chiến binh tấn công vật lý. Mỗi đòn tấn công tăng Nộ.
     */
    @Override
    public void attack(Combatant target) {
        System.out.println(name + " swings his mighty axe at " + ((Character)target).name + "!");
        target.takeDamage(this.attackPower);
        this.rage += 10; // Tăng Nộ sau khi tấn công
    }
}