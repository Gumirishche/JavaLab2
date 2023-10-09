import exceptions.DuplicateModelNameException;
import transports.Bike;
import transports.Transport;
import transports.Transports;
import transports.Vehicle;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, DuplicateModelNameException {
        ///// 1 задание
        Vehicle vehicle = new Vehicle("BMW", 5);
        Bike bike = new Bike("Arasa", 5);
        String brand11 = vehicle.getBrand();
        String[] names11 = vehicle.allNames();
        double[] prices11 = vehicle.allPrices();
        String brand22 = bike.getBrand();
        String[] names22 = bike.allNames();
        double[] prices22 = bike.allPrices();
        Transports.outputTransport(vehicle, new FileOutputStream("dataVehicle.bin"));
        Transports.outputTransport(bike, new FileOutputStream("dataBike.bin"));
        Transport transport1 = Transports.inputTransport(new FileInputStream("dataVehicle.bin"));
        Transport transport2 = Transports.inputTransport(new FileInputStream("dataBike.bin"));
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
        System.out.println("Brand of transport1: " + brand1);
        for (int i = 0; i < transport1.getSize(); i++) {
            System.out.println("transport1:  name-" + names1[i] + "  price-" + prices1[i]);
        }
        System.out.println("-------------------------");
        System.out.println("Class Bike-------------------------");
        System.out.println("Brand of Bike: " + brand22);
        for (int i = 0; i < bike.getSize(); i++) {
            System.out.println("Bike:  name-" + names22[i] + "  price-" + prices22[i]);
        }
        System.out.println("Brand of transport2: " + brand2);
        for (int i = 0; i < transport2.getSize(); i++) {
            System.out.println("transport2:  name-" + names2[i] + "  price-" + prices2[i]);
        }
        ////////////////////////////
    }
}
