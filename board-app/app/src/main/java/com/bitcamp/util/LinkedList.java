package com.bitcamp.util;

// LinkedList 클래스도 ObjectList 처럼 List 규격에 따라 만든다.
// 규격이 같으면 두 객체를 서로 교체할 수 있다.
//
public class LinkedList implements List {

  private Node head;
  private Node tail;
  private int size;

  @Override
  public void add(Object value) {
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

  @Override
  public Object get(int index) {
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


  @Override
  public Object remove(int index) {
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

  @Override
  public int size() {
    return size;
  }

  @Override
  public Object[] toArray() {
    Object[] arr = new Object[size];

    Node cursor = head;
    for (int i = 0; i < size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next;
    }

    return arr;
  }

}
