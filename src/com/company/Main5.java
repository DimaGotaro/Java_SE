package com.company;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Main5 {
    public static void main(String[] args) /*throws IOException*/ { // не нужен try...catch
        // Потоки ввода-вывода. Работа с файлами
        // Потоки ввода-вывода
        /* В основе всех классов, управляющих потоками байтов, находятся два абстрактных класса:
         InputStream (представляющий потоки ввода) и OutputStream (представляющий потоки вывода)
         Но поскольку работать с байтами не очень удобно, то для работы с потоками символов были добавлены
          абстрактные классы Reader (для чтения потоков символов) и Writer (для записи потоков символов).*/

        // Чтение и запись файлов. FileInputStream и FileOutputStream
        String text = "Huli vilypilsya?";
        try (FileOutputStream fok = new FileOutputStream("C:\\Users\\dima\\Desktop\\ит.txt")) { /* если файла
         нет, то он создаётся. Потоки закрываются автоматически*/
            byte[] butter = text.getBytes(); // перевод строки в байты
            for (byte m:
                 butter) {
                System.out.print(m+" ");
            }
            System.out.println();
//            fok.write(butter[0]); // запись одного байта, одна буква
            fok.write(butter, 0, butter.length); // 0 - начало записи байтов
            System.out.println(fok);
            System.out.println("Выполнено!");
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        // Чтение файлов и класс FileInputStream
        try (FileInputStream fik = new FileInputStream("C:\\Users\\dima\\Desktop\\ит.txt")) {
            System.out.println("Кол-во байтов доступных для считывания: " + fik.available());
            int i = 865;
            while ((i= fik.read())!= -1) { // считываем каждый отдельный байт в переменную i, по одному
                System.out.print((char) i); // каждый считанный байт конвертируется в объект типа char
            }
            System.out.println();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        // с помощью массива 2
        FileInputStream fik2 = null;
        try {
            fik2 = new FileInputStream("C:\\Users\\dima\\Desktop\\ит.txt");
            System.out.println("Кол-во байтов доступных для считывания(2): " + fik2.available());
            byte[] nutter = new byte[fik2.available()]; // кол-во ячеек
            fik2.read(nutter, 0, nutter.length);
            for (byte c:
                    nutter) {
                System.out.print((char) c);
            }
            System.out.println();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        finally { // так закрывали поток диды без конструктора в try
            try {
                if (fik2 != null) { // если значение изменено, то операция прошла успешно и нужно закрыть поток
                    fik2.close(); // закрытие потока
                }
            }
            catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        // с помощью массива 3
        try (FileInputStream fik = new FileInputStream("C:\\Users\\dima\\Desktop\\ит.txt")) {
            System.out.println("Кол-во байтов доступных для считывания(3): " + fik.available());
            byte[] nutter = fik.readAllBytes();
            for (byte c:
                 nutter) {
                System.out.print((char) c);
            }
            System.out.println();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        // Совместим
        try (FileInputStream fik = new FileInputStream("C:\\Users\\dima\\Desktop\\ит.txt");
        FileOutputStream fok = new FileOutputStream("C:\\Users\\dima\\Desktop\\ит2.txt")) {
//            byte[] vivo = new byte[fik.available()];
//            fik.read(vivo, 0, vivo.length);
            byte[] vivo = fik.readAllBytes(); // то же только в одну строку
            fok.write(vivo, 0, vivo.length);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();

        // Классы ByteArrayInputStream и ByteArrayOutputStream, для закрытия объекта ByteArrayInputStream
        // не требуется вызывать метод close
        byte[] b1 = {1,2,7,6};
        ByteArrayInputStream b_1 = new ByteArrayInputStream(b1);
        int i;
        while ((i= b_1.read()) != -1) {
            System.out.print(i+" ");
        }
        System.out.println();

        String bs2 = "Manifest";
        byte[] b2 = bs2.getBytes();
        ByteArrayInputStream b_2 = new ByteArrayInputStream(b2, 0, 4); // только 4 символа
        int i2;
        byte[] b21 = b_2.readAllBytes();
        while ((i2= b_2.read()) != -1) {
            System.out.print((char) i2);
        }
        System.out.println();

        String bs3 = "Kapital";
        byte[] b3 = bs3.getBytes();
        ByteArrayOutputStream b_3 = new ByteArrayOutputStream();
        try {
            b_3.write(b3); // направили массив байтов в поток
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("1 " + b_3);
        System.out.println("2 " + b_3.toString()); // из байтов в стоку
        byte[] b32 = b_3.toByteArray(); // из потока в массив байтов
        for (byte c:
             b32) {
            System.out.print((char) c);
        }
        try (FileOutputStream fok = new FileOutputStream("Marks.txt")) { //направили поток в другой поток, в файл
            b_3.writeTo(fok);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();
        System.out.println();

        // Буферизованные потоки BufferedInputStream и BufferedOutputStream
        // Класс BufferedInputStream
        String bs4 = "Jordan";
        byte[] b4 = bs4.getBytes();
        ByteArrayInputStream b_4 = new ByteArrayInputStream(b4);
        try (BufferedInputStream bu_4 = new BufferedInputStream(b_4)) { // направляем поток в отдельный буфер памяти
            byte[] b41 = bu_4.readAllBytes();
            for (byte b:
                 b41) {
                System.out.print((char) b);
            }
            System.out.println();
        }
        catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
        // Класс BufferedOutputStream
        String bs5 = "Novyhodonoser";
        byte[] b5 = bs5.getBytes();
        try (FileOutputStream b_5 = new FileOutputStream("Marks2.txt");
        BufferedOutputStream bu_5 = new BufferedOutputStream(b_5)) {
            bu_5.write(b5, 0, b5.length);
        }
        catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
        System.out.println();

        // Форматируемый ввод и вывод. PrintStream и PrintWriter
        // Класс PrintStream, предоставляет функционал для чтения текстовой информации
        String bs6 = "Hello mazafaka!";
        try (FileOutputStream b_6 = new FileOutputStream("Marks3.txt");
        PrintStream bp_6 = new PrintStream(b_6)) {
            bp_6.println(bs6);
            bp_6.println("Idi otsuda!");
            System.out.println("Запись успешна!");
        }
        catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
        try(PrintStream b_7 = new PrintStream("Marks4.txt")) { // следующий поток в тот же файл отправляет
            // данные в начало файла txt, стирая предыдущие записи
            b_7.print("Pokemon: ");
            b_7.println("Pikachu!");
            b_7.printf("Pokmon%d: ", 2);
            String bs7 = "Bulbozavr";
            byte[] b7 = bs7.getBytes();
            b_7.write(b7);
            b_7.println();
            System.out.println("Успешно!");
        }
        catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
        // PrintWriter
//        PrintWriter pw = new PrintWriter(System.out, true); // try для того чтобы автоматически закрыть поток, но
//         //после не работает System.out.println
//        pw.println("Hello Mazafaka!");
////        pw.close(); // если не закрывать поток без try, то всё работает
//        System.out.println("Готово!");
//        pw.println("by");

        // Классы DataOutputStream и DataInputStream
        // Запись данных и DataOutputStream. DataOutputStream out = DataOutputStream(OutputStream out)
        Pesonaj c1 = new Pesonaj("Bodya", 31, 75.5, true);
        try(DataOutputStream c_1 = new DataOutputStream(new FileOutputStream("data.bin"))) {
            c_1.writeUTF(c1.name);
            c_1.writeInt(c1.age);
            c_1.writeDouble(c1.ves);
            c_1.writeBoolean(c1.married);
            System.out.println("Готово!");
        }
        catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
        try(DataInputStream c_11 = new DataInputStream(new FileInputStream("data.bin"))) {
            String name = c_11.readUTF();
            int age = c_11.readInt();
            double ves = c_11.readDouble();
            boolean married = c_11.readBoolean();
            System.out.printf("Имя: %s; Возраст: %d; Вес: %.2f; Женат: %b;\n", name, age, ves, married);
        }
        catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
        System.out.println();

        // Чтение и запись текстовых файлов
        // Запись файлов. Класс FileWriter
        try(FileWriter d1 = new FileWriter("note.txt", false);) {
        /* true - с каждым выполнением в файл значения будут добавляться,
        false - с каждым выполнением файл будет перезаписываться*/
            String ds1 = "Ройд_Лойд\n";
            d1.write(ds1);
            d1.append('E'); // символ
            d1.append('\n');
            d1.append("Ebola\n"); // набор символов
            d1.flush(); // просто надо, чё-то там очищает в буфере
        }
        catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
        // передать в файл числа
        try(FileWriter d1 = new FileWriter("note2.txt", false);) {
            int g = 88;
            for (int i3 = 0; i3 < 5; i3++) {
                d1.write("88"); // как строка
//                d1.append("88"); // как набор символов
                d1.append(" ");
                d1.append('7');
                d1.append('7');
                d1.append(" ");
            }
            d1.flush();
        }
        catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
        // Чтение файлов. Класс FileReader
        try(FileReader d2 = new FileReader("note.txt")) {
            char[] dc2 = new char[256];
            int k;
            while ((k=d2.read(dc2)) != -1){
                System.out.println(k); // возвращает кол-во символов, поэтому int k
                for (char b:
                     dc2) {
                    System.out.print((char) b); // перечеркнутые нули - это оставшиеся элементы массива 256-18=238
                }
            }
            System.out.println("V"); // в коце перечёркнтых нулей
            System.out.println();
        }
        catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
        // 2 способ, перебираем каждый байт
        try(FileReader d2 = new FileReader("note.txt")) {
            int l; // int потому что в l будут записаны байты
            while ((l= d2.read()) != -1) {
                System.out.print((char) l);
            }
            System.out.println();
        }
        catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
        // 3 способ, без перечёркнутых нулей
        try(FileReader d2 = new FileReader("note.txt")) {
            char[] dc2 = new char[256];
            int k;
            while ((k=d2.read(dc2)) > 0){ // в массив считываются символы, не байты!
                // d2.read(dc2) возвращает кол-во символов, поэтому у переменной k тип int
                System.out.println(k);
                if (k < 256) {
                    dc2 = Arrays.copyOf(dc2, k); // копируем в массив тот же массив, но обрезая по кол-во символов k
                }
                System.out.println(dc2); // после Ebola переход на следующую строку
            }
        }
        catch (IOException ex) {
            System.out.print(ex.getMessage());
        }

        // Буферизация символьных потоков. BufferedReader и BufferedWriter
        // Запись текста через буфер и BufferedWriter,
        // записывает текст в поток, предварительно буферизируя
        // записываемые символы, тем самым снижая количество обращений к физическому носителю для записи данных
        try(BufferedWriter d3 = new BufferedWriter(new FileWriter("note3.txt"))) {
            String ds3 = "Границы ключ переломлен пополам,\nА наш батюшка Ленин, совсем усох\n";
            d3.write(ds3);
            d3.flush();
        }
        catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
        // Чтение текста и BufferedReader,
        // считывает текст из символьного потока ввода, буферизируя прочитанные
        // символы. Использование буфера призвано увеличить производительность чтения данных из потока
        try(BufferedReader d4 = new BufferedReader(new FileReader("note3.txt"))) {
            int s;
            while ((s = d4.read()) != -1) { // посимвольно
                System.out.print((char) s);
            }
            System.out.println();
            System.out.println();
        }
        catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
        try(BufferedReader d4 = new BufferedReader(new FileReader("note3.txt"))) {
            String s;
            while ((s = d4.readLine()) != null) {
                System.out.println(s);
            }
            System.out.println();
        }
        catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
        // Считывание с консоли в файл
//        try(BufferedReader d4 = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter d41 = new BufferedWriter(new FileWriter("note4.txt"))) {
//            String h;
//            while (!(h = d4.readLine()).equals("esc")) {
//                d41.write(h);
//                d41.append('\n');
//                d41.flush();
//            }
//        }
//        catch (IOException ex) {
//            System.out.print(ex.getMessage());
//        }

        // Сериализация
        // Сериализация. Класс ObjectOutputStream
        try(ObjectOutputStream d5 = new ObjectOutputStream(new FileOutputStream("person.dat"))) {
            Pesonaj2 dp5 = new Pesonaj2("Valera", 38, 86.4, false);
            d5.writeObject(dp5); // сериализация объекта
            d5.flush();
        }
        catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        // Десериализация
        try(ObjectInputStream d6 = new ObjectInputStream(new FileInputStream("person.dat"))) {
            Pesonaj2 dp6 = (Pesonaj2) d6.readObject();
            System.out.printf("Имя: %s; Возраст: %d; Вес: %.2f; Женат: %b;\n", dp6.getName(), dp6.getAge(),
                    dp6.getVes(), dp6.isMarried());
            System.out.println();
        }
        catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        // всё вместе
        try(ObjectOutputStream d7 = new ObjectOutputStream(new FileOutputStream("person2.txt"));
        ObjectInputStream d71 = new ObjectInputStream(new FileInputStream("person2.txt"))) {
            ArrayList<Pesonaj2> da7 = new ArrayList<>(2);
            da7.add(new Pesonaj2("Marla", 26, 46.2, true));
            da7.add(new Pesonaj2("Tailer", 29, 78.8, false));
            d7.writeObject(da7);
            ArrayList<Pesonaj2> da71 = (ArrayList<Pesonaj2>) d71.readObject();
            for (Pesonaj2 l:
                 da71) {
                System.out.printf("Имя: %s; Возраст: %d; Вес: %.2f; Женат: %b;\n", l.getName(), l.getAge(),
                        l.getVes(), l.isMarried());
            }
            System.out.println();
        }
        catch (Exception ex) {
            System.out.print(ex.getMessage());
        }

        // Класс File. Работа с файлами и каталогами
        /* управление информацией о файлах и каталогах*/
        File dir1 = new File("C:\\Users\\dima\\IdeaProjects\\HelloApp"); /* cоздали объект для каталога
         HelloApp, указав в конструкторе путь к нему*/
        File file1 = new File("C:\\Users\\dima\\IdeaProjects\\HelloApp", "note3.txt"); /* создали объект
         для файла в каталоге, указав путь к каталогу и имя файла*/
        File file2 = new File(dir1, "note4.txt"); /* создали объект для файла в каталоге,
         указав имя каталога и имя файла*/
        if (dir1.isDirectory()) {
            for (File v:
                 dir1.listFiles()) {
                if (v.isDirectory()) {
                    if (v.isHidden()) {
                        System.out.println(v.getName() + " - Каталог скрытый");

                    }
                    else {
                        System.out.println(v.getName() + " - Каталог");
                    }
                }
                else {
                    System.out.println(v.getName() + " - Файл");
                }
            }
        }
        System.out.println();
        System.out.println(dir1.getAbsolutePath()); // путь к каталогу
        System.out.println(file1.exists()); // проверяет, существует ли по указанному пути файл или каталог
        System.out.println(file1.getAbsolutePath()); // путь к файлу
        File dir2 = new File("C:\\Users\\dima\\IdeaProjects\\HelloApp\\Dir2");
        if (!(dir2.isDirectory())) { // проверяет начличие каталога по пути указанному в конструкторе
            System.out.println(dir2.mkdir() + " mkdir"); // создание каталога, адрес в конструкторе
        }
        File file3 = new File(dir2, "new_file.txt");
        try {
            if (!(file3.isFile())) { // проверяет начличие файла по пути указанному в конструкторе
                System.out.println(file3.createNewFile() + " createN"); // создание файла, адрес и имя в конструкторе
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        File dir_2 = new File("C:\\Users\\dima\\IdeaProjects\\HelloApp\\Dir_2");
//        if (!(dir_2.isDirectory())) {
//            System.out.println(dir2.renameTo(dir_2) + " rename"); // переименование каталога,
//            // новое название в пути в конструкторе
//        }
//        System.out.println(dir2.delete()); // удаление только пустого каталога

        // Работа с файлами
        File mfile = new File("C:\\Users\\dima\\IdeaProjects\\HelloApp\\note3.txt");
        System.out.println(mfile.getName()); // имя файла
        System.out.println(mfile.getParent()); // имя родительского каталога
        if (mfile.exists()) {
            System.out.println("File exists");
        }
        else {
            System.out.println("File not found");
        }
        System.out.println(mfile.length()); // размер файла в байтах
        if (mfile.canRead()) {
            System.out.println("Доступен для чтения");
        }
        else {
            System.out.println("Недоступен для чтения");
        }
        if (mfile.canWrite()) {
            System.out.println("Доступен для записи");
        }
        else {
            System.out.println("Недоступен для записи");
        }
        System.out.println();
        File m2file = new File("C:\\Users\\dima\\IdeaProjects\\HelloApp\\file");
        try {
            if (!(m2file.isFile())) {
                m2file.createNewFile();
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        fileFolder(dir1);
        System.out.println();

        // Работа с ZIP-архивами
        // ZipOutputStream. Запись архивов
        try(ZipOutputStream dz8 = new ZipOutputStream(
                new FileOutputStream("C:\\Users\\dima\\IdeaProjects\\HelloApp\\arh.zip"));
        FileInputStream d8 = new FileInputStream("C:\\Users\\dima\\IdeaProjects\\HelloApp\\note3.txt");
            FileInputStream d81 = new FileInputStream("C:\\Users\\dima\\IdeaProjects\\HelloApp\\note4.txt")) {
            ZipEntry dze8 = new ZipEntry("note3.txt");
            /* Для записи файлов в архив для каждого файла
             создается объект ZipEntry, в конструктор которого передается имя архивируемого файла, не сам файл*/
            dz8.putNextEntry(dze8);
            /*  А чтобы добавить каждый объект ZipEntry в архив, применяется метод putNextEntry()*/
            dz8.write(d8.readAllBytes()); // записываем считанный массив байтов из потока d8 в поток с архивом dz8
            dz8.closeEntry(); // закрываем текущую запись для новой записи, закрытие ZipEntry
            ZipEntry dze81 = new ZipEntry("note4.txt"); // создаём объект для второго файла
            dz8.putNextEntry(dze81); // добавление второго файла в поток dz8
            dz8.write(d81.readAllBytes());
            dz8.closeEntry(); // закрываем текущую запись для новой записи, закрытие ZipEntry
            System.out.println("Файл добавлен в архив");
            System.out.println();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        // Чтение архивов. ZipInputStream
        try(ZipInputStream d9 = new ZipInputStream(new FileInputStream
                ("C:\\Users\\dima\\IdeaProjects\\HelloApp\\arh.zip"))) {
            ZipEntry b;
            String n;
            long s;
            while ((b = d9.getNextEntry()) != null) { // считываем каждый объект типа ZipEntry в архиве
                n = b.getName();
                byte[] m = d9.readAllBytes(); // поток представляет объект ZipEntry b, а не весь поток
                s = m.length;
                System.out.printf("File name: %s, size: %d\n", n, s);
                FileOutputStream df9 = new FileOutputStream
                        ("C:\\Users\\dima\\IdeaProjects\\HelloApp\\Dir1" + n);
                df9.write(m);
                // обязательные методы
                df9.flush();
                d9.closeEntry();
                df9.close();
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // Класс Console
        Console console = System.console();
        if (console != null) {
            String d = console.readLine("Name: ");
            char[] c = console.readPassword("Password: ");
            console.printf("Vivod Name: %s, Password: %s\n", d, new String(c));
        }
    }
    public static void fileFolder(final File b) { // вывод всех файлов
        for (final File v:
             b.listFiles()) {
            if (v.isDirectory() && !(v.isHidden())) {
//                System.out.println(v.getName() + " - Каталог");
                System.out.println(v.getAbsolutePath() + " - Каталог"); // вывод сслылки на каталог
                fileFolder(v);
            }
            else {
//                System.out.println(v.getName() + " - Файл");
                System.out.println(v.getAbsolutePath() + " - Файл"); // вывод ссылки на файл
            }
        }
    }
}
class Pesonaj {
    public String name;
    public int age;
    public double ves;
    public boolean married;

    public Pesonaj(String name, int age, double ves, boolean married) {
        this.name = name;
        this.age = age;
        this.ves = ves;
        this.married = married;
    }
}
class Pesonaj2 implements Serializable {
    private String name;
    private int age;
    private transient double ves;
    private transient boolean married; // transient - запрет сериализации, выведет false

    public Pesonaj2(String name, int age, double ves, boolean married) {
        this.name = name;
        this.age = age;
        this.ves = ves;
        this.married = married;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getVes() {
        return ves;
    }

    public boolean isMarried() {
        return married;
    }
}
