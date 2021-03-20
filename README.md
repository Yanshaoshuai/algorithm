### LinkedList 实现队列和栈
#### 栈
| 栈方法| 等效方法| 作用|
| :----: | :----: | :----:|
|push(e)| addFirst(e)| 添加到链表头|
|pop()|removeFirst()|从链表头移除一个元素|
|peek()|peekFirst()/getFirst()|访问链表头元素(不删除)|

#### 队列
| 队列方法| 等效方法| 作用|
| :----: | :----: | :----:|
|offer(e)| offer(e)/offerLast(e)/addLast(e)|添加到链表尾部|
|poll()| poll()/pollFirst()/removeFirst()|从链表头移除一个元素|
|peek()|peekFirst()/getFirst()|访问链表头元素(不删除)|

#### Test

```java
package leetcode.problems.utils;

import java.util.LinkedList;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /12 14:49
 **/
public class TestLinkedList {
    public static void main(String[] args) {
        //栈测试
        LinkedList<Integer> stack=new LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);//[3, 2, 1]
        System.out.println(stack.pop());//3
        System.out.println(stack);//[2, 1]
        System.out.println(stack.peek());//2
        System.out.println(stack);//[2, 1]
        //队列测试
        LinkedList<Integer> queue=new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue);//[1, 2, 3]
        System.out.println(queue.poll());//1
        System.out.println(queue);//[2, 3]
        System.out.println(queue.peek());//2
        System.out.println(queue);//[2, 3]
    }
}

```
