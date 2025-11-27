import java.util.Stack;

public class ImplementQueueUsingStacks {
    Stack<Integer> readStack;
    Stack<Integer> writeStack;

    public ImplementQueueUsingStacks() {
        readStack = new Stack<>();
        writeStack = new Stack<>();
    }

    public void push(int x) {
        writeStack.push(x);
    }

    public int pop() {
        revStack();
        return readStack.pop();
    }

    public int peek() {
        revStack();
        return readStack.peek();

    }

    public boolean empty() {
        return (readStack.empty() && writeStack.empty());
    }

    private void revStack() {
        if (readStack.size() == 0) {
            int len = writeStack.size();
            while (len > 0 && writeStack.size() > 0) {
                readStack.push(writeStack.pop());
            }
        }
    }
}

