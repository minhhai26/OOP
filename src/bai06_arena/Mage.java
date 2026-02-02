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
     * @throws InsufficientManaException nếu không đủ mana để thi triển phép.
     */
    @Override
    public void attack(Combatant target) {
        //..........
        // Print xong thi moi goi ham take damage
        System.out.println(name + " casts a powerful fireball at " + ((Character)target).name + "!");
        // goi ham take damage o duoi day
        //..........
    }
    
    public void recoverMana(){
        this.mana += 10;
    }
    
    @Override
    public String getStatus() {
        return super.getStatus() + " [Mana: " + mana + "/" + maxMana + "]";
    }
}