/** Anthony Lou Shwank 23410/Juan Francisco Martínez 23617
  * AbstractList
 
  * @param   no_hay
  * @throws Listas sirve para agregar, remover, obtener el tamaño y ver si la lista abstracta está vacía
  */
abstract class AbstractList<T> {
    public abstract void add(T element);
    public abstract void remove(T element);
    public abstract int size();
    public abstract boolean isEmpty();
}
