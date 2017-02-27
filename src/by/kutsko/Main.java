package by.kutsko;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        LocalTime start = LocalTime.now();

        Scanner dataFromFile = new Scanner(Paths.get(System.getProperty("user.dir") + "/input.txt"), "UTF-8");
        String[] dataBoltArray = dataFromFile.nextLine().split(" ");
        String[] dataNutArray = dataFromFile.nextLine().split(" ");
        dataFromFile.close();

        int numberOfBolts = Integer.valueOf(dataBoltArray[0]);
        int restOfBolts = numberOfBolts - (numberOfBolts * Integer.valueOf(dataBoltArray[1]) / 100);

        int numberOfNuts = Integer.valueOf(dataNutArray[0]);
        int restOfNuts = numberOfNuts - (numberOfNuts * Integer.valueOf(dataNutArray[1]) / 100);

        int losses = 0;
        if (restOfBolts <= restOfNuts) {
            losses = ((numberOfBolts - restOfBolts) * Integer.valueOf(dataBoltArray[2])) + ((numberOfNuts - restOfBolts) * Integer.valueOf(dataNutArray[2]));
        } else {
            losses = ((numberOfBolts - restOfNuts) * Integer.valueOf(dataBoltArray[2])) + ((numberOfNuts - restOfNuts) * Integer.valueOf(dataNutArray[2]));
        }

        PrintWriter printWriter = new PrintWriter(System.getProperty("user.dir") + "/output.txt", "UTF-8");
        printWriter.write(String.valueOf(losses));
        printWriter.close();

        LocalTime end = LocalTime.now();

        int mils = (end.getNano() - start.getNano()) / 1000_000;
        System.out.println(String.format("Время выполнения: %d мс", mils));

    }
}
