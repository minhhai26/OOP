package bai06_arena;

/**
 * Lớp đại diện cho một Pháp sư, một loại nhân vật dùng phép thuật.
 */
public class Mage extends Character {
    private int mana;
    private int maxMana;
    private int spellCost;

    public Mage(String name, int maxHealth, int attackPower, int maxMana, int spellCost) {
        super(name, maxHealth, attackPower);
        this.maxMana = maxMana;
        this.mana = maxMana;
        this.spellCost = spellCost;
    }

    /**
     * {@inheritDoc}
     * Pháp sư tấn công bằng phép thuật, tiêu tốn mana.
     *
     * @throws InsufficientManaException nếu không đủ mana để thi triển phép.
     */
    @Override
    public void attack(Combatant target) {
        // 1. Kiểm tra điều kiện mana đầu tiên
        if (this.mana < this.spellCost) {
            // Ném ngoại lệ để thông báo cho Arena biết Mage không thể đánh lượt này
            throw new InsufficientManaException("Current Mana: " + this.mana + ", required: " + this.spellCost);
        }
        // 2. Nếu đủ mana, tiến hành trừ mana và tấn công
        this.mana -= this.spellCost;
        // Ép kiểu target sang Character để lấy thuộc tính .name
        System.out.println(name + " casts a powerful fireball at " + ((Character) target).name + "!");
        // 3. Gây sát thương lên đối thủ
        target.takeDamage(this.attackPower);
    }

    public void recoverMana() {
        this.mana += 10;
    }

    @Override
    public String getStatus() {
        return super.getStatus() + " [Mana: " + mana + "/" + maxMana + "]";
    }
}