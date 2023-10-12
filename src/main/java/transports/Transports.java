package transports;

import exceptions.DuplicateModelNameException;

import java.io.*;

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
        dataOut.writeInt(transport.getClass().toString().length());
        dataOut.writeBytes(transport.getClass().toString());
        dataOut.writeInt(transport.getSize());
        dataOut.writeInt(transport.getBrand().length());
        dataOut.writeBytes(transport.getBrand());
        double[] prices = transport.allPrices();
        String[] names = transport.allNames();
        for (int i = 0; i < prices.length; i++) {
            dataOut.writeInt(names[i].length());
            dataOut.writeBytes(names[i]);
            dataOut.writeDouble(prices[i]);
        }
    }

    public static Transport inputTransport(InputStream in) throws IOException, DuplicateModelNameException {
        DataInputStream dataIn = new DataInputStream(in);
        Transport transport;
        int length = dataIn.readInt();
        String classOfCar = new String(dataIn.readNBytes(length));
        int size = dataIn.readInt();
        length = dataIn.readInt();
        String brand = new String(dataIn.readNBytes(length));
        if (classOfCar.equals(Vehicle.class.toString())) {
            transport = new Vehicle(brand, 0);
        } else {
            transport = new Bike(brand, 0);
        }
        System.out.println(brand);
        while (in.available() > 0) {
            length = dataIn.readInt();
            transport.addModel(new String(dataIn.readNBytes(length)), dataIn.readDouble());
        }
        return transport;
    }

    public static void writeTransport(Transport transport, Writer out) {
        PrintWriter printWriter = new PrintWriter(out);
        printWriter.println(transport.getClass());
        printWriter.println(transport.getBrand());
        printWriter.println(transport.getSize());
        String[] names = transport.allNames();
        double[] prices = transport.allPrices();
        for (int i = 0; i < transport.getSize(); i++) {
            printWriter.println(names[i]);
            printWriter.println(prices[i]);
        }
        printWriter.flush();
        printWriter.close();
    }

    public static Transport readTransport(Reader in) throws IOException, DuplicateModelNameException {
        Transport transport;
        BufferedReader bufferedReader = new BufferedReader(in);
        String classOfCar = bufferedReader.readLine();
        String brand = bufferedReader.readLine();
        int size = Integer.parseInt(bufferedReader.readLine());
        String[] names = new String[size];
        double[] prices = new double[size];
        if(classOfCar.equals(Vehicle.class.toString())){
            transport = new Vehicle(brand,0);
        }
        else {
            transport = new Bike(brand,0);
        }
        for (int i =0;i<size;i++){
            transport.addModel(bufferedReader.readLine(),Double.parseDouble(bufferedReader.readLine()));
        }
        bufferedReader.close();
        return transport;
    }

    public static void main(String[] args) {
        System.out.println(Vehicle.class.toString());
    }
}
