package uk.ac.rhul.cs2800;

/**
 * The entry class creates values that can be stored in the stack. This class has a constructor and
 * getters for each possible data type. Each getter throws a BadTypeException if the type of the
 * entry, that was called on, is not the same type as the getter method should return. The
 * constructors can take values of type: float, String, and Symbol and an extra argument of type
 * Type which specifies what type the data used in the constructor is.
 *
 * @author zjac013
 */
public class Entry {
  private float value;
  private Symbol other;
  private String str;
  private Type type;

  // ---------------------------------------------------------------------

  /**
   * Constructor for a float value.
   *
   * @param val value used to initialise the float entry
   */
  public Entry(float val, Type type) {
    this.value = val;
    this.type = type;
  }

  /**
   * Constructor for a string value.
   *
   * @param str value used to initialise the string entry
   */
  public Entry(String str, Type type) {
    this.str = str;
    this.type = type;
  }

  /**
   * Constructor for a symbol entry.
   *
   * @param symbol value used to initialise the symbol entry
   */
  public Entry(Symbol symbol, Type type) {
    this.other = symbol;
    this.type = type;
  }

  /**
   * Getter for the string entry value.
   *
   * @return the string entry value
   * @throws BadTypeException if the entry type is not of type String
   */
  public String getStr() throws BadTypeException {
    if (!(this.type.toString().equals("String data type"))) {
      throw new BadTypeException();
    }
    return this.str;
  }

  /**
   * Getter for the float entry value.
   *
   * @return the float entry value
   * @throws BadTypeException if the entry type is not of type float
   */
  public float getValue() throws BadTypeException {
    if (!(this.type.toString().equals("float data type"))) {
      throw new BadTypeException();
    }
    return this.value;
  }

  /**
   * Getter for the symbol entry value.
   *
   * @return the symbol entry value
   * @throws BadTypeException if the entry type is not of type Symbol
   */
  public Symbol getOther() throws BadTypeException {
    if (!(this.type.toString().equals("Symbol data type"))) {
      throw new BadTypeException();
    }
    return this.other;
  }

  /**
   * Getter for the type entry value.
   *
   * @return the type entry value
   */
  public Type getType() {
    return this.type;
  }

  /**
   * Creates a string representation with information about the Entry value type.
   *
   * @return returns a string representation with information about the type of the variable
   */
  public String toString() {
    return "The entry is of type: " + this.getType().toString();
  }
}
