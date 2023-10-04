package transports;

import java.io.*;
import java.util.Arrays;

public class Transports {
    public static double arifMidl(Transport transport) {
        double sum = 0;
        for (double p : transport.allPrices()
        ) {
            System.out.println(sum);
            sum += p;
        }
        return sum / transport.allPrices().length;
    }

    public static void allPrices(Transport transport) {
        for (double price : transport.allPrices()
        ) {
            System.out.println("Марка:" + transport.getBrand());
            System.out.println("Цены:");
            System.out.println(price);
        }
    }

    public static void allNames(Transport transport) {
        for (String name : transport.allNames()
        ) {
            System.out.println("Марка:" + transport.getBrand());
            System.out.println("Название моделей:");
            System.out.println(name);
        }
    }

    public static void outputTransport(Transport transport, OutputStream out) throws IOException {
        DataOutputStream dataOut = new DataOutputStream(out);
        dataOut.writeUTF(transport.getClass().toString());
        dataOut.writeUTF(transport.getBrand());
        double[] prices = transport.allPrices();
        String[] names = transport.allNames();
        for (int i = 0; i < prices.length; i++) {
            dataOut.writeUTF(names[i]);
            dataOut.writeDouble(prices[i]);
        }
    }

    public static Transport inputTransport(InputStream in) throws IOException {
        DataInputStream dataIn = new DataInputStream(in);
        String classOfCar = dataIn.readUTF();
        String brand = dataIn.readUTF();
        System.out.println(brand);
        int size = 0, i=0;
        while (in.available() > 0) {
            dataIn.readUTF();
            dataIn.readDouble();
            size++;
        }
        double[] prices = new double[size];
        String[] names = new String[size];
        while (i < size) {
            names[i] = dataIn.readUTF();
            prices[i] = dataIn.readDouble();
            System.out.println("Name: "+ names[i]+ "   Price: "+ prices[i]);
            i++;
        }
        System.out.println(dataIn.readUTF());
        if (classOfCar.equals("class transports.Vehicle")) {
            return new Vehicle(brand,names,prices);
        }
        else {
            return new Bike(1);
        }
    }

    public static void main(String[] args) {
        String[] strings = {"sfgs", "124", "sdgfs"};
        System.out.println(Arrays.toString(strings));
    }
}
