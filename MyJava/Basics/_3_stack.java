import java.util.Stack;

public class _3_stack {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        push(stack, 1);        // O(1)
        push(stack, 2);        // O(1)
        push(stack, 3);        // O(1)
        printStack(stack);     // O(n)
        pop(stack);            // O(1)
        printStack(stack);     // O(n)
        peek(stack);           // O(1)
        isEmpty(stack);        // O(1)
        size(stack);           // O(1)
        clear(stack);          // O(n)
        search(stack, 2);      // O(n)

        printStack(stack);
    }

    public static void printStack(Stack<Integer> stack){
        for(int i : stack){
            System.out.println(i);
        }
    }

    public static void push(Stack<Integer> stack, int data){
        stack.push(data);
    }
    
    public static void pop(Stack<Integer> stack){
        stack.pop();
    }

    public static void peek(Stack<Integer> stack){
        System.out.println(stack.peek()); // Returns the top element of the stack without removing it
    }

    public static void isEmpty(Stack<Integer> stack){
        System.out.println(stack.isEmpty());
    }

    public static void size(Stack<Integer> stack){
        System.out.println(stack.size());
    }

    public static void clear(Stack<Integer> stack){
        stack.clear();
    }

    public static void search(Stack<Integer> stack, int data){
        System.out.println(stack.search(data));
    }
}
