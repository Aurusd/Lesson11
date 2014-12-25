package Human_10;


import java.io.*;

public class Main implements Serializable {


    public static void main(String[] args) throws CloneNotSupportedException {
        Human h1 = new Human("Dima", 29, Human.Sex.MAN, Human.Temperament.MELANCHOLIC);
        Human h2 = new Human("Dima", 29, Human.Sex.MAN, Human.Temperament.PHLEGMATIC);
        Human h3 = new Human("Vasil", 30, Human.Sex.MAN, Human.Temperament.MELANCHOLIC);

        System.out.println("String 1-st is " + h1.toString());
        System.out.println("String 2-nd is " + h2.toString());
        System.out.println("String 3-d is " + h3.toString());

        System.out.println("---------------------------");

        System.out.println("hashCode 1-st is " + h1.hashCode());
        System.out.println("hashCode 2-nd is " + h2.hashCode());
        System.out.println("hashCode 3-d is " + h3.hashCode());

        System.out.println("---------------------------");

        if (h1.equals(h2)) System.out.println(h1.Name + " and " + h2.Name + " are equal");
        else System.out.println(h1.Name + " and " + h2.Name + " are not equal");
        if (h2.equals(h3)) System.out.println(h2.Name + " and " + h3.Name + " are equal");
        else System.out.println(h2.Name + " and " + h3.Name + " are not equal");


        Human h4 = (Human) h3.clone();
        System.out.println("Human h4 is clone of Human h3 " + h4.Name + " " + h4.age + " " + h4.sex);
        h3.Name = "Viktor";
        h3.age = 39;

        System.out.println(h3.Name + "," + h3.age);
        System.out.println(h4.Name + "," + h4.age);

        try {
            // запись
            FileOutputStream fos = new FileOutputStream("temp.out");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            try {
                oos.writeObject(h1);
            } finally {
                oos.close();
            }

            //чтение
            Human h1_1;
        FileInputStream fis = new FileInputStream("temp.out");
        ObjectInputStream oin  = new ObjectInputStream(fis);
            try {
                h1_1 = (Human) oin.readObject();
                System.out.println("Human Name" + h1_1.Name);
            } finally {
                oin.close();
            }


        } catch (IOException | ClassNotFoundException ex) {};

    }
}

