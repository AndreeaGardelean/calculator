package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * Creating a Stack of Symbol entries.
 *
 * @author zjac013
 */
public class OpStack {

  private Stack symbolStack;

  /**
   * Constructor to initialise the Stack of Symbol entries.
   */
  public OpStack() {
    symbolStack = new Stack();
  }

  /**
   * Push a new symbol entry onto the stack.
   *
   * @param symbol the symbol entry to be added to the stack
   */
  public void push(Symbol symbol) {
    symbolStack.push(new Entry(symbol));
  }

  /**
   * Return a boolean value to confirm the status of the stack.
   *
   * @return return boolean value with the stack status
   * @throws EmptyStackException throw exception if the symbol stack is empty
   */
  public boolean isEmpty() throws EmptyStackException {
    return (symbolStack.size() == 0);

  }

  /**
   * Remove and return the last element from the stack entry.
   *
   * @return the values of the last stack entry
   * @throws BadTypeException throw an exception if the entry type is different of that of
   *         getOther() return type
   */
  public Symbol pop() throws BadTypeException {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return symbolStack.pop().getOther();
  }

}
