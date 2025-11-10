
package com.gs.dsa.ds;

import java.util.Stack;

/**
 * Implement a FIFO queue using two stacks.
 * Edge cases: empty queue ops, multiple consecutive peeks/pops, large sequences.
 */
public final class QueueUsingStacks {
    private QueueUsingStacks() {}
    public static final class MyQueue {
        private final Stack<Integer> inputStack = new Stack<>();
        private final Stack<Integer> outputStack = new Stack<>();
        /** Push to input stack. */
        public void push(int x) {
            inputStack.push(x);
        }
        /** Move elements to output stack and pop. */
        public int pop() {
            shiftStacks();
            return outputStack.pop();
        }
        /** Peek element at front. */
        public int peek() {
            shiftStacks();
            return outputStack.peek();
        }
        /** Return true if both stacks empty. */
        public boolean empty() {
            return inputStack.isEmpty() && outputStack.isEmpty();
        }

        /** Move all elements from inputStack to outputStack if outputStack is empty */
        private void shiftStacks() {
            if (outputStack.isEmpty()) {
                while (!inputStack.isEmpty()) {
                    outputStack.push(inputStack.pop());
                }
            }
        }
    }
}
