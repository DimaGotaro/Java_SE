package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main6 {
    public static void main(String[] args) {

        // Работа со строками
        // строка - это набор символов
        //Введение в строки. Класс String
        // При работе со строками важно понимать, что объект String является неизменяемым (immutable).
        // То есть при любых операциях над строкой, которые изменяют эту строку,
        // фактически будет создаваться новая строка.
        String str1 = "Java";
        String str2 = new String(); // пустая строка
        String str3 = new String("Alabama");
        String str4 = new String(new char[] {'N', 'e', 'w', ' ', 'Y', 'o', 'r', 'k'}); // строка из символов
        String str5 = new String(new char[] {'A', 'A', 'w', 'o', 'r', 'k'}, 2, 4); // 2 - начальный индекс
        // 4 - кол-во символов
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
        System.out.println(str5);
        // строка рассматривается как набор символов, мы можем применить метод length() для нахождения длины
        // строки или длины набора символов
        System.out.println(str5.length());
        char[] mass = str4.toCharArray();
        System.out.println(mass);

        String str21 = "";
        System.out.println(str21.length()); // 0 элементов
        System.out.println(str2.isEmpty()); // проверяет строку на пустоту, boolean
        System.out.println(str21.isEmpty()); // проверяет строку на пустоту, boolean
        if (str21.length() == 0) {
            System.out.println("0 элементов");
        }

        String str6 = null; // не указывает на объект
        System.out.println(str6);
//        System.out.println(str6.isEmpty()); // null и пустая строка разные вещи, ошибка
//        System.out.println(str6.length()); // null и пустая строка разные вещи, ошибка
        if (str6 != null) {
        System.out.println(str6.length()); // ничего, str6 = null
        }
        System.out.println();

        // Основные операции со строками
        // Соединение строк
        String rum = "Shtern";
        String rum2 = "Ritter";
        String rum3 = rum + " " + rum2; // сложение
        System.out.println(rum3);
        String rum4 = "Silbern" + 228; // не строковое значение преобразуется в строке
        System.out.println(rum4);
        System.out.println(rum.concat(rum2)); // то же объединение
        // join - статический метод
        String rum5 = String.join(" ", rum, rum2, rum4); // то же объединение, пробел после каждой переменной
        System.out.println(rum5);

        // Извлечение символов и подстрок
        String as = "Sakazyki";
        String as2 = "sakazyki";
        String as3 = "I love sakazyki";
        char c = as.charAt(5); // символ 5-го индекса
        System.out.println(c);
        char[] mass2 = new char[as.length() - 4];
        as.getChars(4, as.length(), mass2, 0); // начало заимствования, конец, массив
        // куда запишутся символы, с какого индекса начнётся запись в массиве
        System.out.println(mass2);
        System.out.println(as.equals(as2));
        System.out.println(as.equalsIgnoreCase(as2)); // true - не читывает регистр
        System.out.println("regionMatches: " +
                as2.regionMatches(true, 0, as3, 7, as2.length()));
        // позволяют узнать больше ли одна строка, чем другая или нет. Если возвращаемое значение больше 0,
        // то первая строка больше второй, если меньше нуля, то, наоборот, вторая больше первой. Если строки равны,
        // то возвращается 0
        System.out.println(as2.compareTo(as3));
        System.out.println(as3.compareTo(as2));
        System.out.println();

        // Поиск в строке
        System.out.println(as2.indexOf("a")); // 1 - индекс в строке первой 'a'
        System.out.println(as2.lastIndexOf("a")); // 3 - индекс в строке последней 'a'
        System.out.println(as2.indexOf("zy"));
        // Метод startsWith() позволяют определить начинается ли строка с определенной подстроки,
        // а метод endsWith() позволяет определить заканчивается строка на определенную подстроку
        String as4 = "rifma.exe";
        System.out.println(as4.startsWith("ri"));
        System.out.println(as4.endsWith("xe"));
        System.out.println();

        // Замена в строке
        String repas4 = as4.replace("exe", "txt");
        System.out.println(repas4);
        System.out.println();

        // Обрезка строки
        String as5 = "  Notorius  ";
        as5 = as5.trim(); // удаляет пробелы
        System.out.println(as5);
        String as6 = "Vanderreih";
        System.out.println(as6.substring(6)); // возвращает символы из сироки начиная с 6 индекса
        System.out.println(as6.substring(0, 6)); // возвращает с 0 по 6 индексы
        byte[] bytes = as6.getBytes(); // стоку в байты
        for (byte b:
             bytes) {
            System.out.print((char) b);
        }
        System.out.println();
        byte n = bytes[0];
        bytes[0] = bytes[as6.length()-1];
        bytes[as6.length()-1] = n;
        // поменял местами первый байт и последний
        for (byte b:
                bytes) {
            System.out.print((char) b);
        }
        System.out.println();
        System.out.println();

        // Изменение регистра
        System.out.println(as6.toLowerCase()); // все символы с нижним регистром
        System.out.println(as6.toUpperCase()); // все символы с верхним регистром
        System.out.println();

        // Split
        String as7 = "I love this language.";
        String[] as7m = as7.split(" "); // разделение на строки, пробел как разделитель
        for (String v:
             as7m) {
            System.out.print(v + " ");
        }
        System.out.println();

        // StringBuffer и StringBuilder
        // StringBuffer для многопоточных приложений, а StringBuilder для не многопоточных приложений, он быстрее
        String as8 = "SeptimaEspada";
        StringBuffer bufas8 = new StringBuffer(as8);
        System.out.println("Ёмкость: " + bufas8.capacity()); // 29
        bufas8.ensureCapacity(30); // увеличивает минимальную ёмкость
        System.out.println("Ёмкость: " + bufas8.capacity()); // 60
        System.out.println("Размер: " + bufas8.length()); // 13
        System.out.println(bufas8.toString());
        System.out.println(bufas8);
        System.out.println();

        // Получение и установка символов
        StringBuffer bas9 = new StringBuffer("Ausveller");
        System.out.println(bas9.charAt(0));
        bas9.setCharAt(8, 'n');
        System.out.println(bas9);
        int intro = 5;
        int end = bas9.length();
        char[] chars = new char[end - intro];
        bas9.getChars(intro, end, chars, 0);
        System.out.println(chars);

        // Добавление в строку
        bas9.append(" it's lie");
        System.out.println(bas9);
        bas9.insert(9, ","); // добавление по индексу
        System.out.println(bas9);
        System.out.println();

        // Удаление символов
        StringBuffer bas10 = new StringBuffer("Ierusalim");
        bas10.delete(4, bas10.length()); // удаление участка строки по индексам
        System.out.println(bas10);
        bas10.deleteCharAt(3); // удаление символа по индексу
        System.out.println(bas10);
        System.out.println();

        // Обрезка строки
        StringBuffer bas11 = new StringBuffer("Terraform");
        String bas11_s = bas11.substring(7, bas11.length());
        String bas11_s2 = bas11.substring(5);;
        System.out.println(bas11_s);
        System.out.println(bas11_s2);
        System.out.println();

        // Изменение длины
        StringBuffer bas12 = new StringBuffer("Cahen_Jonko");
        bas12.setLength(5);
        System.out.println(bas12);
        bas12.setLength(10);
        System.out.println(bas12);
        System.out.println(bas12.length());
        System.out.println();

        // Замена в строке
        StringBuffer bas13 = new StringBuffer("Cahen_Jonko");
        bas13.replace(5, bas13.length(), "Kvinsi");
        System.out.println(bas13);
        System.out.println();

        // Обратный порядок в строке
        bas13.reverse();
        System.out.println(bas13);
        System.out.println();

        // Регулярные выражения
        // split
        String db = "Com  to me";
        String[] dbm = db.split("\\s*(\\s|,|!|\\.)\\s*");
        for (String v:
             dbm) {
            System.out.print(v + " ");
        }
        System.out.println();

        // Соответствие строки. matches
        String db2 = "+25493547632";
        if (db2.matches("(\\+*)\\d{11}")) { // boolean
            System.out.println("Numbr");
        }
        else {
            System.out.println("Eror!");
        }
        // группа "(\\+*)". То есть вначале может идти знак плюса, но также он может отсутствовать. Далее смотрим,
        // соответствуют ли последующие 11 символов цифрам. Выражение "\\d" представляет цифровой символ,
        // а число в фигурных скобках - {11} - сколько раз данный тип символов должен повторяться

        // Класс Pattern
        String db3 = "Varvelt";
        if (Pattern.matches("Varvelt", db3)) { // проверяет полное соответствие со строкой
            System.out.println("Yes");
        }
        else {
            System.out.println("No");

        }
        System.out.println();
        // Класс Matcher
        String db4 = "War";
        Pattern db4p = Pattern.compile("War");
        Matcher db4m = db4p.matcher(db4);
        if (db4m.matches()) { // true - если вся строка совпадает с шаблоном
            System.out.println("Ok");
        }
        else {
            System.out.println("Eror!");
        }
        // поиск подстрок в стоке
        String db5 = "Warworld dfg, djfgl war. War.";
        Pattern db5p = Pattern.compile("War(\\w*)");
        Matcher db5m = db5p.matcher(db5);
        while (db5m.find()) {
            System.out.println(db5m.group());
        }
        System.out.println();

        // Замена в строке
        String db6 = "Warworld dfg, djfgl war. War.";
        Pattern db6p = Pattern.compile("War(\\w*)");
        Matcher db6m = db6p.matcher(db6);
        String db6new = db6m.replaceAll("Pyton"); // на что нужно заменить
        System.out.println(db6new);
        // можно через String
        String db7 = "Warworld dfg, djfgl war. War.";
        String db7new = db7.replaceAll("War(\\w*)", "C#");
        System.out.println(db7new);
        System.out.println();

        // Разделение строки на лексемы
        String db8 = "Warworld dfg, djfgl War. War.";
        Pattern db8p = Pattern.compile("[ ,.!?]");
        String[] db8s = db8p.split(db8);
        System.out.println("Вывод:");
        for (String a:
             db8s) {
            System.out.println(a);
        }
        System.out.println();
        // с помощью регулярных выражений
        String db9 = "Warworld dfg, djfgl War. War.";
        Pattern db9p = Pattern.compile("\\s*(\\s|,|!\\.)\\s*");
        String[] db9s = db9p.split(db9);
        System.out.println("Вывод2:");
        for (String a2:
                db9s) {
            System.out.println(a2);
        }
        System.out.println();

        // Лямбда-выражения
        //Введение в лямбда-выражения
    }
}








