import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Connection conn = DatabaseConfig.getConnection();

        int choice;

        do {
            System.out.println("\n===== TASK MENU =====");
            System.out.println("1. Create");
            System.out.println("2. Retrive");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    // Take input
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter description: ");
                    String description = sc.nextLine();

                    // Prepare SQL
                    String sql = "INSERT INTO tasks(title, description) VALUES (?, ?)";
                    PreparedStatement pstmt = conn.prepareStatement(sql);

                    pstmt.setString(1, title);
                    pstmt.setString(2, description);

                    int rows = pstmt.executeUpdate();

                    if (rows > 0)
                        System.out.println("Task added successfully!");
                    else
                        System.out.println("Failed to add task.");

                    pstmt.close();
                    break;
                case 2:
                    String selectSql = "SELECT * FROM tasks";
                    PreparedStatement selectStmt = conn.prepareStatement(selectSql);
                    ResultSet rs = selectStmt.executeQuery();

                    System.out.println("\n---- TASK LIST ----");

                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String taskTitle = rs.getString("title");
                        String taskDesc = rs.getString("description");

                        System.out.println("ID: " + id);
                        System.out.println("Title: " + taskTitle);
                        System.out.println("Description: " + taskDesc);
                        System.out.println("----------------------");
                    }

                    rs.close();
                    selectStmt.close();
                    break;

                case 3:
                    System.out.print("Enter task ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new title: ");
                    String newTitle = sc.nextLine();

                    System.out.print("Enter new description: ");
                    String newDesc = sc.nextLine();

                    String updateSql = "UPDATE tasks SET title = ?, description = ? WHERE id = ?";
                    PreparedStatement updateStmt = conn.prepareStatement(updateSql);

                    updateStmt.setString(1, newTitle);
                    updateStmt.setString(2, newDesc);
                    updateStmt.setInt(3, updateId);

                    int rowsUpdated = updateStmt.executeUpdate();

                    if (rowsUpdated > 0)
                        System.out.println("Task updated successfully!");
                    else
                        System.out.println("Task not found.");

                    updateStmt.close();
                    break;
                case 4:
                    System.out.print("Enter task ID to delete: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();

                    String deleteSql = "DELETE FROM tasks WHERE id = ?";
                    PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);

                    deleteStmt.setInt(1, deleteId);

                    int rowsDeleted = deleteStmt.executeUpdate();

                    if (rowsDeleted > 0)
                        System.out.println("Task deleted successfully!");
                    else
                        System.out.println("Task not found.");

                    deleteStmt.close();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        conn.close();
        sc.close();


//        Connection conn = DatabaseConfig.getConnection();
//
//        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO tasks(title, description) VALUES (?,?)");
//        pstmt.setString(1,"JDBC Testing");
//        pstmt.setString(2,"This is the jdbc Testing description");
//        pstmt.executeUpdate();
//
//        System.out.println("Task added!");
//        pstmt.close();
//        conn.close();

    }
}