package transports;

import exceptions.DuplicateModelNameException;

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

    public static Transport inputTransport(InputStream in) throws IOException, DuplicateModelNameException {
        DataInputStream dataIn = new DataInputStream(in);
        Transport transport;
        String classOfCar = dataIn.readUTF();
        String brand = dataIn.readUTF();
        if (classOfCar.equals("class transports.Vehicle")) {
            transport = new Vehicle(brand, 0);
        } else {
            transport = new Bike(brand, 0);
        }
        System.out.println(brand);
        while (in.available() > 0) {
            transport.addModel(dataIn.readUTF(), dataIn.readDouble());
        }
        return transport;
    }

    public static void main(String[] args) {
        String[] strings = {"sfgs", "124", "sdgfs"};
        System.out.println(Arrays.toString(strings));
    }
}
