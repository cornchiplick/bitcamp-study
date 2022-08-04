package com.bitcamp.util;

import java.lang.reflect.Array;

public class ObjectList<E> extends AbstractList<E> {

  private static final int DEFAULT_CAPACITY = 10;

  private Object[] elementData;

  public ObjectList() {
    elementData = new Object[DEFAULT_CAPACITY];
  }

  public ObjectList(int initialCapacity) {
    elementData = new Object[initialCapacity];
  }

  @Override // 인터페이스 규격에 따라 메서드를 정의하는 것도 오버라이딩으로 간주한다.
  public void add(E e) {
    if (size == elementData.length) {
      grow();
    }

    elementData[size++] = e;
  }

  @Override
  public Object[] toArray() {
    Object[] arr = new Object[size];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = elementData[i];
    }
    return arr;
  }

  @Override
  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) {

    if (arr.length < size) {
      arr = (E[]) Array.newInstance(arr.getClass().getComponentType(), size);
    }

    for (int i = 0; i < size; i++) {
      arr[i] = (E) elementData[i];
    }

    return arr;
  }

  @SuppressWarnings("unchecked")
  @Override
  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new ListException("인덱스가 무효함!");
    }
    return (E) elementData[index];
  }

  @SuppressWarnings("unchecked")
  @Override
  public E remove(int index) {
    if (index < 0 || index >= size) {
      throw new ListException("인덱스가 무효합니다!");
    }

    // 삭제한 객체를 리턴할 수 있도록 임시 변수에 담아 둔다.
    E deleted = (E) elementData[index];

    for (int i = index + 1; i < size; i++) {
      elementData[i - 1] = elementData[i];
    }
    elementData[--size] = null;

    return deleted;
  }

  private void grow() {
    int newCapacity = elementData.length + (elementData.length >> 1);
    Object[] newArray = new Object[newCapacity];
    for (int i = 0; i < elementData.length; i++) {
      newArray[i] = elementData[i];
    }
    elementData = newArray;
  }
}








