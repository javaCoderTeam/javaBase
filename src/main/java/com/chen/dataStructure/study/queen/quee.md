# [queue队列](https://blog.csdn.net/qq_33524158/article/details/78578370)




````
//接口Queue：
public interface Queue<E> extends Collection<E> {
    //将指定元素插入到队列的尾部（队列满了话，会抛出异常）
    boolean add(E e);

    //将指定元素插入此队列的尾部(队列满了话，会返回false)
    boolean offer(E e);

    /返回取队列头部的元素，并删除该元素(如果队列为空，则抛出异常)
    E remove();

    //返回队列头部的元素，并删除该元素(如果队列为空，则返回null)
    E poll();

    //返回队列头部的元素,不删除该元素(如果队列为空，则抛出异常)
    E element();

    //返回队列头部的元素，不删除该元素(如果队列为空，则返回null)
    E peek();
}
````


````

//接口Deuque:
public interface Deque<E> extends Queue<E> {

    //将指定元素添加到双端队列的头部（如果队列满了，则抛出异常）
    void addFirst(E e);

    //将指定元素添加到双端队列的头部（如果队列满了，则返回fasle）
    boolean offerFirst(E e);

    //将指定元素添加到双端队列的尾部（如果队列满了，则抛出异常）
    void addLast(E e);

    //将指定元素添加到双端队列的尾部（如果队列满了，则返回fasle）
    boolean offerLast(E e);

    //获取并删除该双端队列的第一个元素（如果双端队列为空，则抛出异常）
    E removeFirst();

    //获取并删除双端队列的第一个元素（如果双端队列为空，则返回null）
    E pollFirst();

    //获取并删除该双端队列的最后一个元素（如果双端队列为空，则抛出异常）
    E removeLast();

    //获取并删除该双端队列的最后一个元素（如果双端队列为空，则返回null）
    E pollLast();

    //获取但不删除双端队列的第一个元素（如果双端队列为空，则抛出异常）
    E getFirst();

    //获取但不删除双端队列的第一个元素（如果双端队列为空，则返回null）
    E peekFirst();

    //获取但不删除双端队列的最后一个元素（如果双端队列为空，则抛出异常）
    E getLast();

    //获取但不删除双端队列的最后一个元素（如果双端队列为空，则返回null）
    E peekLast();

    //删除该双端队列的第一次出现的元素o
    boolean removeFirstOccurrence(Object o);

    //删除该双端队列的最后一次出现的元素o
    boolean removeLastOccurrence(Object o);

    //与Queue同理：
    boolean add(E e);
    //与Queue同理：
    boolean offer(E e);
    //与Queue同理：
    E remove();
    //与Queue同理：
    E poll();
    //与Queue同理：
    E element();
    //与Queue同理：
    E peek();
    //与Queue同理：
    boolean remove(Object o);

    模拟数据结构--栈-将元素压入栈顶（向栈顶添加元素）
    void push(E e);

    模拟数据结构--栈-将元素移出栈顶（从栈顶删除元素）
    E pop();

    boolean contains(Object o);

    public int size();

    Iterator<E> iterator();

    Iterator<E> descendingIterator();
}

````