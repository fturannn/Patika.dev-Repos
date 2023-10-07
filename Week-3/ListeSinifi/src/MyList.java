import java.util.Arrays;


public class MyList <T> {
    private int capacity;
    private Object [] list;

    public MyList() {
        list = new Object[10];
    }
    public MyList(int capacity) {
        this.capacity = capacity;
        list = new Object[capacity];
    }

    public int size() { // Dizideki eleman sayısını verir.
        int counter = 0;
        for (int i = 0; i < list.length; i ++) {
            if (list[i] != null)
                counter++;
        }
        return  counter;
    }

    public void add(T data) { // Sınıfa ait diziye eleman eklemek için kullanılır. Eğer dizide yeteri kadar yer yok ise, dizi boyutu 2 katına çıkarılır.
        if (this.size() == this.getCapacity()) {
            if (list.length == this.size()) {
                Object[] temp = new Object[list.length + this.capacity];
                System.arraycopy(list, 0, temp, 0, list.length);
                list = temp;
            }
            this.capacity *= 2;
        }
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) {
                list[i] = data;
                break;
            }
        }
    }

    public int get(int index) { // Verilen indisteki değeri döndürür. Geçersiz indis girilerse null döndürür.
        return (int) list[index];
    }

    public void remove(int index) { // Verilen indisteki veriyi siler ve silinen indis sonrasında ki verileri sol doğru kaydırır. Geçersiz indis girilerse null döndürür.
        if (index < 0 || index > size() - 1) {
            list[index] = "null";
        } else {
            for (int i = 0; i < size(); i++) {
                if (i == index) {
                    list[i] = null;
                }
            }
            for (int i = index + 1; i < size(); i++) {
                list[i] = list [i - 1];
            }
        }
    }

    public void set(int index, T data) { // Verilen indisteki veriyi yenisi ile değiştirme işlemini yapar. Geçersiz indis girilerse null döndürür.
        if (index < 0 || index > size() - 1) {
            list[index] = "null";
        } else {
            list[index] = data;
        }
    }

    @Override
    public String toString() { // Sınıfa ait dizideki elemanları listeleyen bir metot.
        String arr = "";
        arr += "[";
        for (int i = 0; i < size(); i++) {
            if (i == size() - 1) {
                arr += list[i].toString();
            } else {
                arr += list[i].toString() + ",";
            }
        }
        arr += "]";
        return arr;
    }

    public int indexOf(T data) { // Parametrede verilen nesnenin listedeki indeksini verir. Nesne listede yoksa -1 değerini verir.
        int temp = -1;
        for (int i = 0; i < size(); i++) {
            if(list[i] == data) {
                temp = i;
            }
        }
        return temp;
    }

    public int lastIndexOf(T data) { // Belirtilen öğenin listedeki son indeksini söyler. Nesne listede yoksa -1 değerini verir.
        int temp = -1;
        for (int i = size() - 1; i >= 0; i--) {
            if (list[i] == data) {
                temp = i;
            }
        }
        return temp;
    }

    public boolean isEmpty() { // Listenin boş olup olmadığını söyler.
        boolean isEmpty = false;
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                isEmpty = true;
            }
        }
        return isEmpty;
    }

    public T [] toArray() { // Listedeki öğeleri, aynı sırayla bir array haline getirir.
        return (T[]) Arrays.stream(list).toArray();
    }

    public void clear() { // Listedeki bütün öğeleri siler, boş liste haline getirir.
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                list[i] = null;
            }
        }
    }

    public MyList<T> subList(int start, int finish) { // Parametrede verilen indeks aralığına ait bir liste döner.
        MyList<T> subList = new MyList<>(10);
        for (int i = start; i <= finish; i++) {
            subList.add((T)list[i]);
        }
        return subList;
    }

    public boolean contains(T data) { // Parametrede verilen değerin dizide olup olmadığını söyler.
        boolean temp = false;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == data) {
                temp = true;
            }
        }
        return temp;
    }

    public int getCapacity() { // Dizinin kapasite değerini verir.
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Object[] getList() {
        return list;
    }

    public void setList(Object[] list) {
        this.list = list;
    }
}
