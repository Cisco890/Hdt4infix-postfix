/** Anthony Lou Shwank 23410/Juan Francisco Martínez 23617
  * Icalculadora
 
  * @param   no_hay
  * @throws Stacks Clase que crea la estructura y metodos que usan los stacks con datos genericos
  */import org.junit.Test;
import static org.junit.Assert.*;

public class Pruebas {

    @Test
    public void testEvaluateExpression() {
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        
        // Definir una expresión conocida y su resultado esperado
        String expression = "(3+5)*2-4/2";
        int expectedResult = 14;
        
        // Llamar al método evaluateExpression y verificar el resultado
        int actualResult = evaluator.evaluateExpression(expression);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testInfixtoPostfix(){
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        
        // Definir una expresión infix conocida y su representación postfix esperada
        String infixExpression = "(3+5)*2-4/2";
        String expectedPostfix = "3 5 + 2 * 4 2 / -";
        
        // Llamar al método infixToPostfix y verificar el resultado
        String actualPostfix = evaluator.infixToPostfix(infixExpression);
        assertEquals(expectedPostfix, actualPostfix);
        
    }


}