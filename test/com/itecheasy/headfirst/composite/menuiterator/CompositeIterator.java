package com.itecheasy.headfirst.composite.menuiterator;



import java.util.*;

//看为是allMenu
public class CompositeIterator implements Iterator {
	public Stack stack = new Stack();	//all menu下所有的 node 和 leaf 的iterator
   
	public CompositeIterator(Iterator iterator) { //all menu下所有的 node 和 leaf
		stack.push(iterator);
	}
   
	public Object next() {
		if (hasNext()) {
			Iterator iterator = (Iterator) stack.peek();
			MenuComponent component = (MenuComponent) iterator.next();	//其实还是在调用自己
			if (component instanceof Menu) {	//如果是父节点类型
				stack.push(component.createIterator());
			} 
			return component;
		} else {
			return null;
		}
	}
  
	public boolean hasNext() {
		if (stack.empty()) {
			return false;
		} else {
			Iterator iterator = (Iterator) stack.peek();
			if (!iterator.hasNext()) { //看all Menu下有没有其他的
				stack.pop(); 	//如果迭代器all Menu的迭代器是空的，那就把这个迭代器给拿出来(删除)
				return hasNext();
			} else {
				return true;
			}
		}
	}
   
	public void remove() {
		throw new UnsupportedOperationException();
	}
}


