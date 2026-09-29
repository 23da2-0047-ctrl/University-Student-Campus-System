package university.system;

public class ActionStack {

    // Node used to store each action
    private static class ActionNode {

        String action;
        ActionNode next;

        ActionNode(String action) {
            this.action = action;
            this.next = null;
        }
    }

    // Top of the stack
    private ActionNode top;

    // Number of actions
    private int size;

    // Constructor
    public ActionStack() {
        top = null;
        size = 0;
    }

    // ==========================================
    // PUSH - Add action to the top
    // ==========================================

    public void push(String action) {

        ActionNode newNode = new ActionNode(action);

        newNode.next = top;
        top = newNode;

        size++;
    }

    // ==========================================
    // POP - Remove latest action
    // ==========================================

    public String pop() {

        if (top == null) {
            return null;
        }

        String action = top.action;

        top = top.next;
        size--;

        return action;
    }

    // ==========================================
    // PEEK - View latest action
    // ==========================================

    public String peek() {

        if (top == null) {
            return null;
        }

        return top.action;
    }

    // ==========================================
    // Display Stack
    // ==========================================

    public void displayActions() {

        if (top == null) {

            ConsoleUI.warning(
                "No recent actions available."
            );

            return;
        }

        ActionNode current = top;

        System.out.println();

        System.out.println(
            ConsoleUI.CYAN +
            "────────────────────────────────────────────" +
            ConsoleUI.RESET
        );

        System.out.println(
            ConsoleUI.CYAN +
            ConsoleUI.BOLD +
            "              RECENT ACTIONS" +
            ConsoleUI.RESET
        );

        System.out.println(
            ConsoleUI.CYAN +
            "────────────────────────────────────────────" +
            ConsoleUI.RESET
        );

        int number = 1;

        while (current != null) {

            System.out.printf(
                ConsoleUI.BLUE +
                "  [%02d] " +
                ConsoleUI.RESET +
                "%s%n",
                number,
                current.action
            );

            current = current.next;
            number++;
        }

        System.out.println(
            ConsoleUI.CYAN +
            "────────────────────────────────────────────" +
            ConsoleUI.RESET
        );

        System.out.println(
            ConsoleUI.WHITE +
            "Total Actions: " +
            size +
            ConsoleUI.RESET
        );
    }

    // ==========================================
    // Check Empty
    // ==========================================

    public boolean isEmpty() {
        return top == null;
    }

    // ==========================================
    // Get Stack Size
    // ==========================================

    public int getSize() {
        return size;
    }
}