public class Stack {
    public int[] arr = new int[10];
    public int index = 0;
    public void push(int x){
        arr[index++] = x;
    }

    public int pop(){
        return arr[--index];
    }

    public String toString(){
        String str = "[";
        if (index == 0){
            return "[]";
        }
        for (int i = index-1; i > 0; i--) {
            str += arr[i] + ", ";
        }
        str += arr[0] + "]";
        return str;
    }
}
