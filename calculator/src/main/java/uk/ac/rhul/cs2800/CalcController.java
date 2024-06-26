package uk.ac.rhul.cs2800;

/**
 * Adds itself to an observer to the view so that changes can be observed.
 *
 * @author zjac013
 */
public class CalcController {
  private CalcModel model;
  private GuiView view;
  private boolean isInfix;
  private static CalcController controller_instance = null;

  /**
   * A single point of access for the controller. The controller cannot be instantiated outside this
   * class.
   *
   * @return returns the instance of the controller
   * @throws InvalidExpressionException exception thrown by the model
   */
  public static CalcController getInstance(CalcModel model, ViewInterface view2)
      throws InvalidExpressionException {
    if (controller_instance == null) {
      controller_instance = new CalcController(model, view2);
    }
    return controller_instance;
  }

  /**
   * Is notified when a change in the expression type is indicated and updates the state of the
   * calculator.
   */
  public void expressionType() {
    isInfix = view.getExpressionType();
    model.setType(isInfix);
  }

  /**
   * When the 'Calculate' button is pressed, a notification is sent to the controller to execute
   * this method. The method evaluates the input expression and sends an error message to the
   * interface if an error occurs or sends the result of the evaluated expression to the view.
   */
  public void calculate() {
    expressionType();
    String expression = view.getExpression();
    float result = 0;
    try {
      view.setErrorMessage("");
      result = model.evaluate(expression);
    } catch (InvalidExpressionException e) {
      String msg = "Invalid mathematical expression." + System.lineSeparator()
          + "Check each operand and operator is space separated" + System.lineSeparator()
          + "and your expression is in the correct format.";
      view.setErrorMessage(msg);
    } catch (ArithmeticException i) {
      view.setErrorMessage("Cannot divide by 0");
    }
    view.setAnswer(String.valueOf(result));
  }

  /**
   * Constructor adds itself as an observer and calls the appropriate methods when a change occurs
   * in the view.
   *
   * @param model model object to be used in the observer
   * @param view2 graphical user interface objects on which the changes will be observed
   * @throws InvalidExpressionException method is thrown by the model
   */
  private CalcController(CalcModel model, ViewInterface view2) throws InvalidExpressionException {
    this.model = model;
    this.view = (GuiView) view2;

    view2.addCalcObserver(this::calculate);
    view2.addTypeObserver(this::expressionType);
  }
}
