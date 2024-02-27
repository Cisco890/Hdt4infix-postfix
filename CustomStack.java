/** Anthony Lou Shwank 23410/Juan Francisco Martínez 23617

Custom Stack Genérico

@param   no_hay
@throws Stacks Clase que crea la estructura y metodos que usan los stacks con datos genericos
*/
public class CustomStack<T> {
    public Node<T> lastNode;
    public Node<T> firstNode;


      public void push(T value) {//agrega un dato al final del stack
          if (lastNode == null) {
              lastNode = new Node<T>(value);
              firstNode = lastNode;
          } else {
              Node<T> current = new Node<T>(value);
              current.setNext(firstNode);
              firstNode = current;
          }
      }

      public boolean isEmpty() {//revisa si el stack está vacío
          return firstNode == null;
      }

      public T pop() {//elimína el último dato del stack
          if (firstNode != null) {
              T value = firstNode.getValue();
              firstNode = firstNode.getNext();
              return value;
          }
          return null;
      }

      public int size() {//revisa el tamaño del stack
          int count = 0;
          Node<T> current = firstNode;
          while (current != null) {
              count++;
              current = current.getNext();
          }
          return count;
      }

      public T[] toArray(T[] array) {//vuelve el T en un array
          Node<T> current = firstNode;
          int index = 0;
          while (current != null && index < array.length) {
              array[index++] = current.getValue();
              current = current.getNext();
          }
          return array;
      }
    }