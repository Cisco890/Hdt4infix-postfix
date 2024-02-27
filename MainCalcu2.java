/** Anthony Lou Shwank 23410/Juan Francisco Martínez 23617
  * MainCalcu2
 
  * @param   La_expresión_del_archivo_de_texto
  * @throws Resultado 
  */
import java.util.EmptyStackException;


public class MainCalcu2 {
    public static void main(String[] args) {
    

        ExpressionEvaluator evaluator = new ExpressionEvaluator();

        // Lee la expresión desde el archivo 
        String archivo = "datos.txt";
        String exprescion = evaluator.readExpressionFromFile(archivo);

        // Evalúa la expresión e imprime el resultado
        int resultado = evaluator.evaluateExpression(exprescion);
        System.out.println("Resultado de la expresión: " + resultado);
    }

    }
    
    
    // Clase de implementación de pila utilizando la clase Stack de Java
    class StackImpl<T> extends CustomStack<T>{
        public StackImpl() {
            super();
        }
        @Override
        //Añade un elemento al  stack.
        public void push(T element) {
            super.push(element);
        }
    
        @Override 
         //remueve el elemento del stack
   
        public T pop() throws EmptyStackException {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return super.pop();
        }
    
        @Override
        //Verifica si el stack está vacío.

        public boolean isEmpty() {
            return super.isEmpty();
        }
    }
    

    