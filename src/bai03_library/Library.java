package bai03_library;


public class Library {
    private final String name;
    private final Book[] books; // Mảng để lưu trữ các cuốn sách
    private int bookCount;      // Biến đếm số lượng sách hiện có

    /**
     * Constructor để khởi tạo một thư viện.
     *
     * @param name     Tên của thư viện.
     * @param capacity Sức chứa tối đa của thư viện (kích thước của mảng books).
     */
    public Library(String name, int capacity) {
        this.name = name;
        this.books = new Book[capacity]; // Khởi tạo mảng với sức chứa cho trước
        this.bookCount = 0;              // Ban đầu chưa có sách nào
    }

    /**
     * Thêm một cuốn sách vào thư viện.
     * Điều kiện:
     * 1. Thư viện vẫn còn chỗ trống (bookCount < books.length).
     * Hành động:
     * - Nếu còn chỗ, thêm đối tượng Book vào vị trí tiếp theo trong mảng (vị trí bookCount).
     * - Tăng bookCount lên 1.
     * - In ra thông báo đã thêm sách thành công theo định dạng: Added book: book title
     * - Nếu hết chỗ, in ra thông báo lỗi "Library is full. Cannot add the book: book title."
     */
    public void addBook(Book book) {

    }

    /**
     * Hiển thị tất cả các cuốn sách hiện có trong thư viện.
     * Hành động:
     * - In ra tên thư viện theo định dạng --- Books in library name ---.
     * - Dùng vòng lặp for để duyệt qua mảng 'books' từ 0 đến bookCount - 1.
     * - Với mỗi cuốn sách, in thông tin của nó ra màn hình
     * - Nếu thư viện không có sách nào (bookCount == 0), in ra thông báo "The library is empty."
     */
    public void displayBooks() {
        System.out.println("\n--- Books in " + this.name + " ---");

        System.out.println("------------------------");
    }

    /**
     * Tìm kiếm một cuốn sách theo tiêu đề.
     *
     * @param title Tiêu đề của cuốn sách cần tìm.
     * @return Trả về đối tượng Book nếu tìm thấy, ngược lại trả về null.
     * Hành động:
     * - Dùng vòng lặp for để duyệt qua các cuốn sách hiện có.
     * - So sánh tiêu đề của từng cuốn sách với tham số 'title' (sử dụng phương thức equalsIgnoreCase
     * để không phân biệt chữ hoa/thường).
     * - Nếu tìm thấy, ngay lập tức trả về đối tượng Book đó.
     * - Nếu duyệt hết vòng lặp mà không tìm thấy, trả về null.
     */
    public Book findBookByTitle(String title) {

        return null;
    }
}