package bai06_arena;

/**
 * Lớp mô phỏng một đấu trường nơi hai đối thủ chiến đấu đến khi một người bị hạ gục.
 */
public class Arena {
    /**
     * Bắt đầu trận chiến giữa hai đấu sĩ (combatants) trong Arena.
     * <p>
     * Yêu cầu sinh viên triển khai:
     * - Trận chiến diễn ra theo lượt (turn-based).
     * - Hai nhân vật sẽ lần lượt tấn công nhau cho đến khi có một bên bị hạ gục (HP <= 0).
     * - Mỗi lượt:
     * 1. Người tấn công gọi phương thức attack() để gây sát thương lên đối thủ.
     * 2. Sau khi bị tấn công, nếu HP của đối thủ <= 0 thì trận chiến kết thúc ngay lập tức.
     * 3. Nếu cả hai còn sống, đổi lượt cho người còn lại.
     * <p>
     * Lưu ý:
     * - Bạn cần in ra diễn biến trận đấu để người dùng dễ theo dõi.
     * Ví dụ: "Warrior tấn công Mage và gây 15 sát thương."
     * - Nếu nhân vật là Mage và không đủ mana để tung chiêu, phải bắt và xử lý
     * ngoại lệ InsufficientManaException (in thông báo và cho qua lượt và gọi hàm recoverMana() để hồi phục Mana).
     * - Trận chiến kết thúc khi có một nhân vật HP <= 0.
     * Hãy in ra kết quả: tên người thắng cuộc.
     * <p>
     * Gợi ý triển khai:
     * - Sử dụng vòng lặp while để tiếp tục cho đến khi một nhân vật gục ngã.
     * - Trong mỗi lượt, hãy gọi attack() từ người đang tấn công.
     * - Sau khi một nhân vật gục ngã, in ra tên người chiến thắng.
     */
    public void startBattle(Character c1, Character c2) {
        System.out.println("========= BATTLE START =========");
        System.out.println(c1.getStatus() + " VS " + c2.getStatus());
        System.out.println("================================");

        // 2. Thiết lập con trỏ vai trò
        Character attacker = c1; // Ban đầu c1 được ưu tiên đánh trước
        Character defender = c2; // c2 là người nhận đòn

        /*Tại sao làm vậy?
         Thay vì viết code riêng cho c1 đánh c2 rồi lại viết lại cho c2 đánh c1,
         mình dùng hai biến tạm attacker (người công) và defender (người thủ).
         Sau mỗi lượt chỉ cần đổi giá trị hai biến này là xong.*/
        // 3. Vòng lặp trận đấu
        while (c1.isAlive() && c2.isAlive()) {
            System.out.println(attacker.name + "'s turn to attack!");
            /*Tại sao làm vậy?
             Điều kiện && (VÀ) cực kỳ quan trọng.
             Trận đấu chỉ tiếp tục nếu cả hai đều còn sống.
             Nếu một người HP <= 0, isAlive() trả về false và vòng lặp dừng ngay lập tức.*/
            try {
                attacker.attack(defender); // Hàng động tấn công
            } catch (InsufficientManaException e) {
                // Nếu là Mage và hết mana, exception này sẽ bị "bắt" tại đây
                System.out.println("Attack failed! " + e.getMessage());
                System.out.println(attacker.name + " skips a turn to recover.");
                // Ép kiểu (Casting) để gọi hàm hồi mana
                if (attacker instanceof Mage) {
                    // Trong lập trình Java, instanceof là một toán tử dùng để kiểm tra kiểu dữ liệu của một đối tượng.
                    /* Vì attacker đang để kiểu dữ liệu chung là Character,
                    mà lớp Character không có hàm recoverMana().
                    Ta phải kiểm tra "Nếu ông này đúng là Mage thì mới cho ông ấy hồi mana".*/
                    ((Mage) attacker).recoverMana();
                }
            }
            // 5. In trạng thái sau mỗi lượt đánh
            System.out.println("Status after turn:");
            System.out.println(c1.getStatus());
            System.out.println(c2.getStatus());

            // 6. Kiểm tra điều kiện kết thúc sớm
            if (!defender.isAlive()) {
                break; // Nếu người bị đánh đã chết, thoát vòng lặp ngay
            }
            // 7. Hoán đổi vai trò (Swap)
            Character temp = attacker;
            attacker = defender;
            defender = temp;
        }
        // Sau khi vòng lặp kết thúc, xác định và công bố người chiến thắng
        System.out.println("\n========= BATTLE END =========");
        if (c1.isAlive()) {
            System.out.println("WINNER: " + c1.name);
        } else {
            System.out.println("WINNER: " + c2.name);
        }
        System.out.println("============================");
    }
}