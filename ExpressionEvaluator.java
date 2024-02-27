/** Anthony Lou Shwank 23410/Juan Francisco Martínez 23617
  * ExpressionEvaluator
 
  * @param   infixExpression,filePath,operator  
  * @throws El_resultado_de_la_evaluación_de_la_expresión
  */
import java.util.Stack;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Singleton para la evaluación de expresiones
public class ExpressionEvaluator {

    public int evaluateExpression(String infixExpression) {
        String postfixExpression = infixToPostfix(infixExpression);
        return evaluatePostfix(postfixExpression);
    }

    private int evaluatePostfix(String postfixExpression) {
        System.out.println("Expresión postfix: " + postfixExpression);
    
        Stack<Integer> stack = new Stack<>();
    
        for (String token : postfixExpression.trim().split("\\s+")) {
            if (token.matches("\\d+")) {
                // Es un número, simplemente lo apilamos
                stack.push(Integer.parseInt(token));
            } else {
                // Es un operador, realizamos la operación correspondiente
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Expresión postfix no válida: faltan operandos para el operador " + token);
                }
    
                int operand2 = stack.pop();
                int operand1 = stack.pop();
    
                switch (token) {// casos para las oprecaciones
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        stack.push(operand1 / operand2);
                        break;
                    default:
                        throw new IllegalArgumentException("Operador no válido: " + token);
                }
            }
        }
    
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Expresión postfix no válida");
        }
    
        return stack.pop();// quita el elemento del stack
    }
    
    public String readExpressionFromFile(String filePath) {
        // Lógica para leer la expresión desde el archivo
        StringBuilder expression = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                expression.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return expression.toString();
    }

    public String infixToPostfix(String infixExpression) {// agarra los datos del archivo y 
        StringBuilder postfixExpression = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();
        boolean readingNumber = false;
        StringBuilder currentNumber = new StringBuilder();
    
        for (char c : infixExpression.toCharArray()) {
            if (Character.isDigit(c)) {
                readingNumber = true;
                currentNumber.append(c); // Agrega el dígito al número actual
            } else {
                if (readingNumber) {
                    postfixExpression.append(currentNumber.toString().trim()).append(" "); // agrega el número al final
                    currentNumber.setLength(0);  // Reinicia el StringBuilder para el próximo número
                    readingNumber = false;
                }
    
                if (c == '(') {// Apila el paréntesis izquierdo
                    operatorStack.push(c);
                } else if (c == ')') {
                    while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                        postfixExpression.append(operatorStack.pop()).append(" ");
                    }
                    if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
                        operatorStack.pop(); // Remueve el paréntesis
                    } else {
                        throw new IllegalArgumentException("Invalid infix expression: unbalanced parentheses");
                    }
                } else {
                    while (!operatorStack.isEmpty() && getPrecedence(operatorStack.peek()) >= getPrecedence(c) && operatorStack.peek() != '(') {
                        postfixExpression.append(operatorStack.pop()).append(" ");
                    }
                    operatorStack.push(c);// Apila el nuevo operador
                }
            }
        }
    
        if (readingNumber) {
            postfixExpression.append(currentNumber.toString()).append(" ");
        }
    
        while (!operatorStack.isEmpty()) {
            char operator = operatorStack.pop();
            if (operator == '(') {
                throw new IllegalArgumentException("Invalid infix expression: unbalanced parentheses");
            }
            postfixExpression.append(operator).append(" "); // Agrega los operadores restantes al resultado
        
        }
    
        return postfixExpression.toString().trim();
    }
    
    
    private int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }
}


// Fábrica para crear instancias de pilas y listas

