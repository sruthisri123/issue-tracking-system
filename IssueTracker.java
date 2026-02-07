import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IssueTracker {
    private List<Issue> issues = new ArrayList<>();
    private int nextId = 1;

    public void createIssue(String title, String description, String status) {
        Issue issue = new Issue(nextId++, title, description, status);
        issues.add(issue);
        System.out.println("Issue created successfully: " + issue);
    }

    public void viewIssues() {
        if (issues.isEmpty()) {
            System.out.println("No issues found.");
        } else {
            System.out.println("All Issues:");
            for (Issue issue : issues) {
                System.out.println(issue);
            }
        }
    }

    public void updateIssue(int id, String status) {
        for (Issue issue : issues) {
            if (issue.getId() == id) {
                issue.setStatus(status);
                System.out.println("Issue updated: " + issue);
                return;
            }
        }
        System.out.println("Issue not found with ID: " + id);
    }

    public void deleteIssue(int id) {
        for (Issue issue : issues) {
            if (issue.getId() == id) {
                issues.remove(issue);
                System.out.println("Issue deleted successfully.");
                return;
            }
        }
        System.out.println("Issue not found with ID: " + id);
    }

    public static void main(String[] args) {
        IssueTracker tracker = new IssueTracker();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Issue Tracker Menu ---");
            System.out.println("1. Create Issue");
            System.out.println("2. View Issues");
            System.out.println("3. Update Issue Status");
            System.out.println("4. Delete Issue");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter description: ");
                    String desc = sc.nextLine();
                    System.out.print("Enter status (Open/In Progress/Closed): ");
                    String status = sc.nextLine();
                    tracker.createIssue(title, desc, status);
                    break;
                case 2:
                    tracker.viewIssues();
                    break;
                case 3:
                    System.out.print("Enter Issue ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new status: ");
                    String newStatus = sc.nextLine();
                    tracker.updateIssue(updateId, newStatus);
                    break;
                case 4:
                    System.out.print("Enter Issue ID to delete: ");
                    int deleteId = sc.nextInt();
                    tracker.deleteIssue(deleteId);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
