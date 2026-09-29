package university.system;

public class ConsoleUI {

    // ==============================
    // Console Colors
    // ==============================

    public static final String RESET = "\u001B[0m";

    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static final String BOLD = "\u001B[1m";

    // ==============================
    // Display Main Header
    // ==============================

    public static void displayHeader() {

        System.out.println(CYAN + BOLD);

        System.out.println(
            "╔══════════════════════════════════════════════════════════════╗"
        );

        System.out.println(
            "║        UNIVERSITY STUDENT & CAMPUS MANAGEMENT SYSTEM        ║"
        );

        System.out.println(
            "║                     CIT300 - DSA                             ║"
        );

        System.out.println(
            "╚══════════════════════════════════════════════════════════════╝"
        );

        System.out.println(RESET);
    }

    // ==============================
    // Display Section Header
    // ==============================

    public static void sectionHeader(String title) {

        System.out.println();
        System.out.println(CYAN + BOLD);

        System.out.println(
            "╔══════════════════════════════════════════════════════════════╗"
        );

        System.out.printf(
            "║  %-58s║%n",
            title
        );

        System.out.println(
            "╚══════════════════════════════════════════════════════════════╝"
        );

        System.out.println(RESET);
    }

    // ==============================
    // Success Message
    // ==============================

    public static void success(String message) {

        System.out.println(
            GREEN + "✓ " + message + RESET
        );
    }

    // ==============================
    // Error Message
    // ==============================

    public static void error(String message) {

        System.out.println(
            RED + "✗ " + message + RESET
        );
    }

    // ==============================
    // Warning Message
    // ==============================

    public static void warning(String message) {

        System.out.println(
            YELLOW + "⚠ " + message + RESET
        );
    }

    // ==============================
    // Information Message
    // ==============================

    public static void info(String message) {

        System.out.println(
            BLUE + "ℹ " + message + RESET
        );
    }
}
