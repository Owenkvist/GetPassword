

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/*
Генератор паролей
*/
public class Password {
    static ArrayList<ByteArrayOutputStream> baosList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {



        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        boolean numb = false;
        boolean upper = false;
        boolean lower = false;
        while (baos.size() != 8) {
            int k = (int) (1 + Math.random() * 3);
            if (k == 1) {
                baos.write((int) (48 + Math.random() * 10));
                numb = true;
            }
            if (k == 2) {
                baos.write((int) (65 + Math.random() * 26));
                upper = true;
            }
            if (k == 3) {
                baos.write((int) (97 + Math.random() * 26));
                lower = true;
            }
        }
        if ((numb && upper && lower) && !baosList.contains(baos)) {
            baosList.add(baos);
            return baos;
        } else
            return getPassword();
    }
}