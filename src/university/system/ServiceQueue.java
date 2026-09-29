package university.system;

public class ServiceQueue {

    private static class QueueNode {

        ServiceRequest request;
        QueueNode next;

        QueueNode(ServiceRequest request) {
            this.request = request;
            this.next = null;
        }
    }

    private QueueNode front;
    private QueueNode rear;
    private int size;

    public ServiceQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    // Add request to the rear of the queue
    public void enqueue(ServiceRequest request) {

        QueueNode newNode =
            new QueueNode(request);

        if (rear == null) {

            front = newNode;
            rear = newNode;

        } else {

            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    // Remove request from the front
    public ServiceRequest dequeue() {

        if (front == null) {
            return null;
        }

        ServiceRequest request =
            front.request;

        front = front.next;

        if (front == null) {
            rear = null;
        }

        size--;

        return request;
    }

    // View the first request
    public ServiceRequest peek() {

        if (front == null) {
            return null;
        }

        return front.request;
    }

    // Display all requests
    public void displayQueue() {

        if (front == null) {

            ConsoleUI.warning(
                "No service requests in the queue."
            );

            return;
        }

        QueueNode current = front;

        System.out.println();

        System.out.println(
            ConsoleUI.CYAN +
            "──────────────────────────────────────────────────────────────" +
            ConsoleUI.RESET
        );

        System.out.println(
            ConsoleUI.CYAN +
            ConsoleUI.BOLD +
            "                  SERVICE REQUEST QUEUE" +
            ConsoleUI.RESET
        );

        System.out.println(
            ConsoleUI.CYAN +
            "──────────────────────────────────────────────────────────────" +
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
                current.request
            );

            current = current.next;
            number++;
        }

        System.out.println(
            ConsoleUI.CYAN +
            "──────────────────────────────────────────────────────────────" +
            ConsoleUI.RESET
        );

        System.out.println(
            ConsoleUI.WHITE +
            "Total Requests: " +
            size +
            ConsoleUI.RESET
        );
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int getSize() {
        return size;
    }
}
