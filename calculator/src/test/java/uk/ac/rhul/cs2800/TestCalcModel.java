package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCalcModel {

  CalcModel model;

  @BeforeEach
  void setup() {
    model = new CalcModel();
  }

  // Test 1
  @Test
  void test() {
    model = new CalcModel();
  }

  // Test 2
  // Test an infix expression
  @Test
  void testInfixExpression() throws InvalidExpressionException {
    assertEquals(model.evaluate("1 + 2", true), (float) 3);
  }

  // Test 3
  // Test a reverse polish notation expression
  @Test
  void testRevPolishExpression() throws InvalidExpressionException {
    assertEquals(model.evaluate("1 5 -", false), (float) -4);
  }

  // Test 4
  // Test an more complex infix expression
  @Test
  void testInfixExpression2() throws InvalidExpressionException {
    assertEquals(model.evaluate("1 + 2 * 7 - 3", true), (float) 9);
  }

  // Test 5
  // Test an invalid infix expression
  @Test
  void testInfixExpressionInvalid() throws InvalidExpressionException {
    assertThrows(InvalidExpressionException.class, () -> model.evaluate("1 + 2 * 7 ^ 3", true));
  }
  
  // Test 6
  // Test a more complex infix expression
  @Test
  void testRevPolishExpression2() throws InvalidExpressionException {
    assertEquals(model.evaluate("1 2 + 7 3 * -", false), (float) -18);
  }
  
  // Test 7
  // Test a more complex infix expression
  @Test
  void testREvPolishExpression3() throws InvalidExpressionException {
    assertEquals(model.evaluate("6 2 9 7 + - *", false), (float) -84);
  }
  
  // Test 8
  // Test an invalid reverse polish notation expression
  @Test
  void testRevPolishExpressionInvalid() throws InvalidExpressionException {
    assertThrows(InvalidExpressionException.class, () -> model.evaluate("3 7 8 + ^", false));
  }
}