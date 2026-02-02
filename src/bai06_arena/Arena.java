package bai06_arena;
/**
 * Lớp mô phỏng một đấu trường nơi hai đối thủ chiến đấu đến khi một người bị hạ gục.
 */
public class Arena {
     /**
     * Bắt đầu trận chiến giữa hai đấu sĩ (combatants) trong Arena.
     *
     * Yêu cầu sinh viên triển khai:
     * - Trận chiến diễn ra theo lượt (turn-based).
     * - Hai nhân vật sẽ lần lượt tấn công nhau cho đến khi có một bên bị hạ gục (HP <= 0).
     * - Mỗi lượt:
     *   1. Người tấn công gọi phương thức attack() để gây sát thương lên đối thủ.
     *   2. Sau khi bị tấn công, nếu HP của đối thủ <= 0 thì trận chiến kết thúc ngay lập tức.
     *   3. Nếu cả hai còn sống, đổi lượt cho người còn lại.
     *
     * Lưu ý:
     * - Bạn cần in ra diễn biến trận đấu để người dùng dễ theo dõi.
     *   Ví dụ: "Warrior tấn công Mage và gây 15 sát thương."
     * - Nếu nhân vật là Mage và không đủ mana để tung chiêu, phải bắt và xử lý
     *   ngoại lệ InsufficientManaException (in thông báo và cho qua lượt và gọi hàm recoverMana() để hồi phục Mana).
     * - Trận chiến kết thúc khi có một nhân vật HP <= 0.
     *   Hãy in ra kết quả: tên người thắng cuộc.
     *
     * Gợi ý triển khai:
     * - Sử dụng vòng lặp while để tiếp tục cho đến khi một nhân vật gục ngã.
     * - Trong mỗi lượt, hãy gọi attack() từ người đang tấn công.
     * - Sau khi một nhân vật gục ngã, in ra tên người chiến thắng.
     */
    public void startBattle(Character c1, Character c2) {
        System.out.println("========= BATTLE START =========");
        System.out.println(c1.getStatus() + " VS " + c2.getStatus());
        System.out.println("================================");

        //...........
        
        // Supporting print
        
        // System.out.println(attacker.name + "'s turn to attack!");
        
        // System.out.println("Attack failed! " + e.getMessage());
        // System.out.println(attacker.name + " skips a turn to recover.");
        
        // System.out.println("Status after turn:");
        // System.out.println(c1.getStatus());
        // System.out.println(c2.getStatus());

        // Sau khi vòng lặp kết thúc, xác định và công bố người chiến thắng
        System.out.println("\n========= BATTLE END =========");
        //...........
        System.out.println("============================");
    }
}