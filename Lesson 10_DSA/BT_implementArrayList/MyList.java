public class MyList<E> {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    private MyList() {
        this.size = 0;
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        this.size = 0;
        this.elements = new Object[capacity];
    }

    public void add(int index, E element) {
        //Kiểm tra chỉ số index hợp lệ
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    ensureCapacity(size + 1);


    //dịch chuyển các phần tử về sau


}
