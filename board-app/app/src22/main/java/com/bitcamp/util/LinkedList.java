package com.bitcamp.util;

public class LinkedList {

  private Node head;
  private Node tail;
  private int size;

  public void append(Object value) {
    Node node = new Node(value);

    size++;

    if (head == tail) {
      head = tail = node;
      return;
    }


    tail.next = node;
    node.prev = tail;
    tail = node;
  }

  public Object retrieve(int index) {
    // 인덱스의 유효 여부 검사
    if (index < 0 || index >= size) {
      throw new ListException("인덱스의 범위를 초과했습니다!");
    }

    Node cursor = head;

    // 지정된 인덱스의 노드 주소를 알아낸다.
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    } 

    // cursor가 가리키는 노드의 값을 꺼내 리턴한다.
    return cursor.value;
  }


  public Object delete(int index) {
    if (index < 0 || index >= size) {
      throw new ListException("인덱스의 범위를 초과했습니다!");
    }

    size--;

    Object deleted;

    if (head == tail) {
      deleted = head.value;
      head.value = null;
      head = tail = null;
      return deleted;
    }

    Node cursor = head;

    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }

    if (cursor.prev != null) {
      cursor.prev.next = cursor.next;
    } else {
      head = cursor.next;
      head.prev = null;
    }

    if (cursor.next != null) {
      cursor.next.prev = cursor.prev;      
    } else {
      tail = cursor.prev;
      tail.next = null;
    }

    deleted = cursor.value;
    cursor.prev = null;
    cursor.value = null;
    cursor.next = null;

    return deleted;
  }

  public int length() {
    return size;
  }

  public Object[] getArray() {
    Object[] arr = new Object[size];

    Node cursor = head;
    for (int i = 0; i < size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next;
    }

    return arr;
  }

}
