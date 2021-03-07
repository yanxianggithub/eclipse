package single_list;

public class SingleList {
	/*
	 元素的数量
	 */
	private int size;
	/*
	 所有的元素
	 */
	private E[] elements;

	/*
	 构造函数
	 */
	public SingleList () {
		this(DEFAULT_CAPACITY);
	}
	
	public SingleList (int capaticy) {
		capaticy = (capaticy < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capaticy;
		elements = (E[]) new Object[capaticy];
	}
	/*
	 清除所有元素
	 */

	/**
	 * 清除所有元素
	 */
	public void clear() {
		size = 0;
		first = null;
	}

	/*
	 元素的数量
	 @return
	 */
	public int size() {
		return size;
	}
	/*
	 是否为空
	 @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	/*
	 是否包含某个元素
	 @param element
	 @return
	 */
	public boolean contains(E element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}
	/*
	 添加元素到尾部
	 @param element
	 */
	public void add(E element) {
		add(size,element);
	}
	/*
	 获取index位置的元素
	 @param index
	 @return
	 获取index位置的元素
	 @param index
	 @return
	 */
	public E get(int index) {

		return node(index).element;
	}

	/*
	 * 设置index位置的元素
	 * @param index
	 * @param element
	 * @return 原来的元素ֵ
	 */
	public E set(int index,E element) {
		Node<E> node = node(index);
		E old = node.element;
		node.element = element;
		return old;
	}

	/*
	 * 在index位置插入一个元素
	 * @param index
	 * @param element
	 */
	public void add(int index,E element) {
		checkForAdd(index);

		if(index == 0){
			first = new Node<>(element,first);
		}else{
			Node<E> prev = node(index - 1);
			prev.next = new Node<>(element,prev.next);
		}
		size++;
	}

	public E remove(int index) {
		check(index);

		Node<E> node = first;
		if(index == 0){
			first = first.next;
		}else{
			Node<E> prev = node(index - 1);
			node = prev.next;
			prev.next = node.next;
		}
		size--;
		return node.element;
	}

	/*
	 * 查看元素的索引
	 * @param element
	 * @return
	 */
	public int indexOf(E element) {
		if(element == null) {
			Node<E> node = first;
			for(int i = 0; i < size; i++) {
				if(node.element == null) return i;
				node = node.next;
			}
		}else {
			Node<E> node = first;
			for(int i = 0; i < size; i++) {
				if(element.equals(node.element)) return i;
				node = node.next;
			}
		}
		return -1;
	}

	private Node<E> node(int index){
		check(index);

		Node<E> node = first;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		retrun node;
	}

	private void check(int index) {
		if(index < 0 || index >= size) {
			outOfBounds(index);
		}
	}
	
	private void checkForAdd(int index) {
		if(index < 0 || index > size) {
			outOfBounds(index);
		}
	}
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append(", [");
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				string.append(", ");
			}

			string.append(node.element);

			node = node.next;
		}
		string.append("]");


		return string.toString();
	}

}

