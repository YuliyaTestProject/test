
import org.junit.Test;

import javax.swing.text.html.HTMLDocument;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class Tests {

    @Test(expected = NullPointerException.class)
    public void Exception1Test() {

        String name = null;
        System.out.println(name.length());

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void Exception2Test() {

        int[] arr = new int[10];
        arr[15] = 7;

    }

    @Test(expected = NumberFormatException.class)
    public void Exception3Test() {

        String text = new String("3a");
        Integer.parseInt(text);

    }

    @Test(expected = ClassCastException.class)
    public void Exception4Test() {

        Long number = new Long(100);
        Object obj = number;
        Integer integer = (Integer) obj;

    }

    @Test(expected = ClassNotFoundException.class)
    public void Exception5Test() throws ClassNotFoundException {

        Class test1 = Class.forName("test.test");

    }

    @Test(expected = IllegalArgumentException.class)
    public void Exception6Test() {

        Character.toChars(-1);


    }

    @Test(expected = IllegalStateException.class)
    public void Exception7Test() {

        ArrayList arr1 = new ArrayList();
        arr1.iterator().remove();

    }

    @Test(expected = UnsupportedOperationException.class)
    public void Exception8Test() {

        Arrays.asList().add("1");


    }

    @Test(expected = IOException.class)
    public void Exception9Test() throws IOException {

        File file = new File("C:\\Training\\src\\Task1\\test.txt");
        file.createNewFile();

    }

    @Test(expected = Error.class)
    public void Exception10Test() {

        int size = 1000000000;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }

    }


}
