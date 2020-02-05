package impl.stack;

class Stack{
    int top;
    int[] stack;
    int size;

    public Stack(int size){
        top = -1;
        stack = new int[size];
        this.size = size;
    }

    public int peek(){
        return stack[top];
    }
    public int pop(){
        return stack[top--];
    }
    public void push(int value){
        stack[++top] = value;
    }
}

public class Main{
    public static void main(String[] args){
        Stack st = new Stack(10);
        st.push(1);
        st.push(2);
        st.push(3);

        System.out.println(st.pop());
        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.peek());
        System.out.println(st.pop());
    }
}
