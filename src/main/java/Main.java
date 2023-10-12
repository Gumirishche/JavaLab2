import exceptions.DuplicateModelNameException;
import transports.Bike;
import transports.Transport;
import transports.Transports;
import transports.Vehicle;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException, DuplicateModelNameException, ClassNotFoundException {
        ///// 1.0 задание
//        Vehicle vehicle = new Vehicle("BMW", 5);
//        Bike bike = new Bike("Arasa", 5);
//        String brand11 = vehicle.getBrand();
//        String[] names11 = vehicle.allNames();
//        double[] prices11 = vehicle.allPrices();
//        String brand22 = bike.getBrand();
//        String[] names22 = bike.allNames();
//        double[] prices22 = bike.allPrices();
//        Transports.outputTransport(vehicle, new FileOutputStream("dataVehicle.txt"));
//        Transports.outputTransport(bike, new FileOutputStream("dataBike.txt"));
//        Transport transport1 = Transports.inputTransport(new FileInputStream("dataVehicle.txt"));
//        Transport transport2 = Transports.inputTransport(new FileInputStream("dataBike.txt"));
//        System.out.println(Arrays.toString(bike.allNames()));
//        System.out.println(Arrays.toString(bike.allPrices()));
//        System.out.println(Arrays.toString(transport2.allNames()));
//        System.out.println(Arrays.toString(transport2.allPrices()));
//        String brand1 = transport1.getBrand();
//        String[] names1 = transport1.allNames();
//        double[] prices1 = transport1.allPrices();
//        String brand2 = transport2.getBrand();
//        String[] names2 = transport2.allNames();
//        double[] prices2 = transport2.allPrices();
//        System.out.println("Class Vehicle-------------------------");
//        System.out.println("Brand of Vehicle: " + brand11);
//        for (int i = 0; i < vehicle.getSize(); i++) {
//            System.out.println("Vehicle:  name-" + names11[i] + "  price-" + prices11[i]);
//        }
//        System.out.println("Brand of transport1: " + brand1);
//        for (int i = 0; i < transport1.getSize(); i++) {
//            System.out.println("transport1:  name-" + names1[i] + "  price-" + prices1[i]);
//        }
//        System.out.println("-------------------------");
//        System.out.println("Class Bike-------------------------");
//        System.out.println("Brand of Bike: " + brand22);
//        for (int i = 0; i < bike.getSize(); i++) {
//            System.out.println("Bike:  name-" + names22[i] + "  price-" + prices22[i]);
//        }
//        System.out.println("Brand of transport2: " + brand2);
//        for (int i = 0; i < transport2.getSize(); i++) {
//            System.out.println("transport2:  name-" + names2[i] + "  price-" + prices2[i]);
//        }
        ////////////////////////////
        //1.5 задание
//        Vehicle vehicle = new Vehicle("BMW", 5);
//        Bike bike = new Bike("Arasa", 5);
//        String brand11 = vehicle.getBrand();
//        String[] names11 = vehicle.allNames();
//        double[] prices11 = vehicle.allPrices();
//        String brand22 = bike.getBrand();
//        String[] names22 = bike.allNames();
//        double[] prices22 = bike.allPrices();
//        Transports.writeTransport(vehicle, new FileWriter("writerVehicle.txt"));
//        Transports.writeTransport(bike, new FileWriter("writerBike.txt"));
//        Transport transport1 = Transports.readTransport(new FileReader("writerVehicle.txt"));
//        Transport transport2 = Transports.readTransport(new FileReader("writerBike.txt"));
//        System.out.println(Arrays.toString(bike.allNames()));
//        System.out.println(Arrays.toString(bike.allPrices()));
//        System.out.println(Arrays.toString(transport2.allNames()));
//        System.out.println(Arrays.toString(transport2.allPrices()));
//        String brand1 = transport1.getBrand();
//        String[] names1 = transport1.allNames();
//        double[] prices1 = transport1.allPrices();
//        String brand2 = transport2.getBrand();
//        String[] names2 = transport2.allNames();
//        double[] prices2 = transport2.allPrices();
//        System.out.println("Class Vehicle-------------------------");
//        System.out.println("Brand of Vehicle: " + brand11);
//        for (int i = 0; i < vehicle.getSize(); i++) {
//            System.out.println("Vehicle:  name-" + names11[i] + "  price-" + prices11[i]);
//        }
//        System.out.println("Brand of transport1: " + brand1);
//        for (int i = 0; i < transport1.getSize(); i++) {
//            System.out.println("transport1:  name-" + names1[i] + "  price-" + prices1[i]);
//        }
//        System.out.println("-------------------------");
//        System.out.println("Class Bike-------------------------");
//        System.out.println("Brand of Bike: " + brand22);
//        for (int i = 0; i < bike.getSize(); i++) {
//            System.out.println("Bike:  name-" + names22[i] + "  price-" + prices22[i]);
//        }
//        System.out.println("Brand of transport2: " + brand2);
//        for (int i = 0; i < transport2.getSize(); i++) {
//            System.out.println("transport2:  name-" + names2[i] + "  price-" + prices2[i]);
//        }
        ////////////////////////////
        ///// 2 задание
        Vehicle vehicle = new Vehicle("BMW", 5);
        Bike bike = new Bike("Arasa", 5);
        ObjectOutputStream outputStreamV = new ObjectOutputStream(new FileOutputStream("fileVehicle.bin"));
        ObjectOutputStream outputStreamB = new ObjectOutputStream(new FileOutputStream("fileBike.bin"));
        outputStreamV.writeObject(vehicle);
        outputStreamB.writeObject(bike);
        ObjectInputStream inputStreamV = new ObjectInputStream(new FileInputStream("fileVehicle.bin"));
        ObjectInputStream inputStreamB = new ObjectInputStream(new FileInputStream("fileBike.bin"));
        Object object1 = inputStreamV.readObject();
        Object object2 = inputStreamB.readObject();
        Transport transport1;
        Transport transport2;
        if(object1.getClass().equals(Vehicle.class)){
            transport1 = (Vehicle)object1;
        }
        else {
            transport1 = (Bike)object1;
        }
        if(object2.getClass().equals(Vehicle.class)){
            transport2 = (Vehicle)object2;
        }
        else {
            transport2 = (Bike)object2;
        }
        String brand11 = vehicle.getBrand();
        String[] names11 = vehicle.allNames();
        double[] prices11 = vehicle.allPrices();
        String brand22 = bike.getBrand();
        String[] names22 = bike.allNames();
        double[] prices22 = bike.allPrices();
        String brand1 = transport1.getBrand();
        String[] names1 = transport1.allNames();
        double[] prices1 = transport1.allPrices();
        String brand2 = transport2.getBrand();
        String[] names2 = transport2.allNames();
        double[] prices2 = transport2.allPrices();
        System.out.println("Class Vehicle-------------------------");
        System.out.println("Brand of Vehicle: " + brand11);
        for (int i = 0; i < vehicle.getSize(); i++) {
            System.out.println("Vehicle:  name-" + names11[i] + "  price-" + prices11[i]);
        }
        System.out.println("Brand of Transport1: " + brand1);
        for (int i = 0; i < transport1.getSize(); i++) {
            System.out.println("Transport1:  name-" + names1[i] + "  price-" + prices1[i]);
        }
        System.out.println("-------------------------");
        System.out.println("Class Bike-------------------------");
        System.out.println("Brand of Bike: " + brand22);
        for (int i = 0; i < bike.getSize(); i++) {
            System.out.println("Bike:  name-" + names22[i] + "  price-" + prices22[i]);
        }
        System.out.println("Brand of Transport2: " + brand2);
        for (int i = 0; i < transport2.getSize(); i++) {
            System.out.println("Transport2:  name-" + names2[i] + "  price-" + prices2[i]);
        }
    }
}
