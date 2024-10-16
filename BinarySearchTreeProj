import java.util.Scanner;

// Class representing a contact with a name and phone number
class Contact {
    String name;
    String phoneNumber;

    Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}

// Class representing a node in the binary search tree
class TreeNode {
    Contact contact;
    TreeNode left;
    TreeNode right;

    TreeNode(Contact contact) {
        this.contact = contact;
        this.left = null;
        this.right = null;
    }
}

// Class for managing contacts using a Binary Search Tree
class ContactBST {
    private TreeNode root;

    // Method to insert a contact into the BST
    public void insert(String name, String phoneNumber) {
        Contact newContact = new Contact(name, phoneNumber);
        root = insertRec(root, newContact);
    }

    private TreeNode insertRec(TreeNode root, Contact contact) {
        if (root == null) {
            root = new TreeNode(contact);
            return root;
        }
        if (contact.name.compareToIgnoreCase(root.contact.name) < 0) {
            root.left = insertRec(root.left, contact);
        } else if (contact.name.compareToIgnoreCase(root.contact.name) > 0) {
            root.right = insertRec(root.right, contact);
        } else {
            System.out.println("Contact with this name already exists.");
        }
        return root;
    }

    // Method to search for a contact by name
    public void search(String name) {
        TreeNode node = searchRec(root, name);
        if (node != null) {
            System.out.println("Contact found: " + node.contact.name + " - " + node.contact.phoneNumber);
        } else {
            System.out.println("Contact not found.");
        }
    }

    private TreeNode searchRec(TreeNode root, String name) {
        if (root == null || root.contact.name.equalsIgnoreCase(name)) {
            return root;
        }
        if (name.compareToIgnoreCase(root.contact.name) < 0) {
            return searchRec(root.left, name);
        } else {
            return searchRec(root.right, name);
        }
    }

    // Method to delete a contact by name
    public void delete(String name) {
        root = deleteRec(root, name);
    }

    private TreeNode deleteRec(TreeNode root, String name) {
        if (root == null) {
            return root;
        }
        if (name.compareToIgnoreCase(root.contact.name) < 0) {
            root.left = deleteRec(root.left, name);
        } else if (name.compareToIgnoreCase(root.contact.name) > 0) {
            root.right = deleteRec(root.right, name);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: get the in-order successor (smallest in the right subtree)
            root.contact = findMin(root.right);
            root.right = deleteRec(root.right, root.contact.name);
        }
        return root;
    }

    private Contact findMin(TreeNode root) {
        Contact minContact = root.contact;
        while (root.left != null) {
            minContact = root.left.contact;
            root = root.left;
        }
        return minContact;
    }

    // Method to display all contacts in alphabetical order (in-order traversal)
    public void displayInOrder() {
        displayInOrderRec(root);
    }

    private void displayInOrderRec(TreeNode root) {
        if (root != null) {
            displayInOrderRec(root.left);
            System.out.println(root.contact.name + " - " + root.contact.phoneNumber);
            displayInOrderRec(root.right);
        }
    }
}

// Main class to run the Contact Management System
public class ContactManagementSystem {
    public static void main(String[] args) {
        ContactBST contactBST = new ContactBST();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nContact Management System:");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter contact name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    contactBST.insert(name, phoneNumber);
                    break;
                case 2:
                    System.out.print("Enter the name of the contact to search: ");
                    String searchName = scanner.nextLine();
                    contactBST.search(searchName);
                    break;
                case 3:
                    System.out.print("Enter the name of the contact to delete: ");
                    String deleteName = scanner.nextLine();
                    contactBST.delete(deleteName);
                    break;
                case 4:
                    System.out.println("Contacts in alphabetical order:");
                    contactBST.displayInOrder();
                    break;
                case 5:
                    System.out.println("Exiting the Contact Management System.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
