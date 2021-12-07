package com.company;

        public class Main {

            // Стекпен Очередьты Дек аркылы иске асыру
            // Дек туйиндерине класс ашу ягни контейнерлер екилик агаш
            static class DQueNode {
                int value;
                DQueNode next;
                DQueNode prev;
            }
            static class deque {
                // Басы мен аяк жагына указательдар
                private DQueNode head;
                private DQueNode tail;

                // Конструктор
                public deque() {
                    head = tail = null;
                }

                // Егер катар бос болса
                boolean isEmpty() {
                    if (head == null)
                        return true;

                    return false;
                }

                // катардагы жадыдагы контейнерлерди санау
                int size() {

                    // Егер
                    if (!isEmpty()) {
                        DQueNode temp = head;
                        int len = 0;

                        while (temp != null) {
                            len++;
                            temp = temp.next;
                        }
                        return len;
                    }
                    return 0;
                }

                // Биринши орынга элемент салу
                void insert_first(int element) {

                    // реттеуши контейнер
                    DQueNode temp = new DQueNode();
                    temp.value = element;

                    // Егер элемент биринши элемент болса
                    if (head == null) {
                        head = tail = temp;
                        temp.next = temp.prev = null;
                    } else {
                        head.prev = temp;
                        temp.next = head;
                        temp.prev = null;
                        head = temp;
                    }
                }

                // Дектеги Сонгы орынга элемент
                void insert_last(int element) {

                    // реттеуши контейнер
                    DQueNode temp = new DQueNode();
                    temp.value = element;

                    // Элемент егерде биринши элемент болса
                    if (head == null) {
                        head = tail = temp;
                        temp.next = temp.prev = null;
                    } else {
                        tail.next = temp;
                        temp.next = null;
                        temp.prev = tail;
                        tail = temp;
                    }
                }

                // биринши орындагы элементты оширу
                void remove_first() {

                    // Егер катар бос болмаса
                    if (!isEmpty()) {
                        DQueNode temp = head;
                        head = head.next;
                        head.prev = null;

                        return;
                    }
                    System.out.print("List is Empty");
                }

                // Сонгы элементты шыгару
                void remove_last() {

                    // Егер катар бос болмаса
                    if (!isEmpty()) {
                        DQueNode temp = tail;
                        tail = tail.prev;
                        tail.next = null;

                        return;
                    }
                    System.out.print("List is Empty");
                }

                // Дектеги элементтерды экранга шыгару дисплэй аркылы
                void display() {
                    if (!isEmpty()) {
                        DQueNode temp = head;

                        while (temp != null) {
                            System.out.print(temp.value + " ");
                            temp = temp.next;
                        }

                        return;
                    }
                    System.out.print("List is Empty");
                }
            }

            // класс для реализации стека с помощью дек
            static class Stack {
                deque d = new deque();

                // стек шынына элемен енгизу
                // дек функциясымен кезектин сонына елемент енгизу
                public void push(int element) {
                    d.insert_last(element);
                }

                // размерын кайтару
                public int size() {
                    return d.size();
                }

                // стектын шынындагы элементты шыгару
                public void pop() {
                    d.remove_last();
                }
                public void display() {
                    d.display();
                }
            }

            // Кезек классын дек аркылы реализация жасау
            static class Queue {
                deque d = new deque();

                // элементы сонына кою ушин кезекке кою
                public void enqueue(int element) {
                    d.insert_last(element);
                }
                // дектеги биринши элемент шыгару
                public void dequeue() {
                    d.remove_first();
                }

                // display
                public void display() {
                    d.display();
                }

                // size
                public int size() {
                    return d.size();
                }
            }
            public static void main(String[] args) {
                // стек объектысы
                Stack stk = new Stack();

                // стекке элемент енгизу
                stk.push(7);
                stk.push(8);
                System.out.print("Stack: ");
                stk.display();
                System.out.println();

                // элементты стектен шыгару
                stk.pop();
                System.out.print("Stack: ");
                stk.display();
                System.out.println();

                // Дек объектысы
                Queue que = new Queue();

                // кезекке элемент киргизу
                que.enqueue(12);
                que.enqueue(13);
                System.out.print("Queue: ");
                que.display();
                System.out.println();

                // кезектеги элементти жою
                que.dequeue();
                System.out.print("Queue: ");
                que.display();
                System.out.println();
                System.out.println("Size of stack is " +
                        stk.size());
                System.out.println("Size of queue is " +
                        que.size());
            }
        }
