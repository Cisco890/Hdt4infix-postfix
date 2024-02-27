/** Anthony Lou Shwank 23410/Juan Francisco Martínez 23617
  
Node genérico

@param   no_hay
@throws Nodos Estructura del dato generico
*/
public class Node<T>{
    
    T value;
    Node<T> next;
    public Node (T val){                    //Datos genericos
        value=val;
        next=null;
    }
    public T getValue(){                    //Conseguimos datos de el nodo deseado
        return value;
    }
    public Node<T> getNext(){               //Nos movemos al siguiente dato
        return next;
    }
    public void setValue(T newValue){       //Indicamos el valor de algun nodo
        value=newValue;
    }
    public void setNext( Node <T> n){       //Indicamos cual es el nodo que le sigue a otro
        next = n;
    }
  
  }
  