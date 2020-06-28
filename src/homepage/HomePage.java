/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homepage;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mehed
 */
public class HomePage {

    DSIVehicleShowroom vehicleShowroom = new DSIVehicleShowroom();
    public static int hypeVisitor = 20;

    HomePage() {

        String welcomeMessage = "Welcome to The DSI Vehicle Showroom! \n";
        boolean isTheFirstTime = true;

        System.out.println(welcomeMessage);

        Scanner scanner = new Scanner(System.in);

        while (true) {

            int nextStep = 1;

            if (isTheFirstTime == false) {
                System.out.println("+------------------------------+");
                System.out.println("| Want to Continue or Exit?    |");
                System.out.println("+------------------------------+");
                System.out.println("| 1. Continue                  |");
                System.out.println("| 2. Exit                      |");
                System.out.println("+------------------------------+\n");

                boolean isOptionConfirmed = true;
                int confirmNextStep = 0;

                while (confirmNextStep < 1 || confirmNextStep > 2) {
                    if (isOptionConfirmed == false) {
                        System.out.println("Error!");
                    }
                    isOptionConfirmed = false;
                    System.out.print("Please enter a valid number: ");
                    confirmNextStep = scanner.nextInt();
                }
                nextStep = confirmNextStep;

            }
            isTheFirstTime = false;
            if (nextStep == 2) {
                System.out.println("Closed!");
                break;

            } else if (nextStep == 1) {

                System.out.println("+----------------------------------------+");
                System.out.println("|                 MENU                   |");
                System.out.println("+----------------------------------------+");
                System.out.println("| 1.Add Vehicle                          |");
                System.out.println("| 2.Remove Vehicle                       |");
                System.out.println("| 3.Show Vehicle Details                 |");
                System.out.println("| 4.Show Expected Visitors               |");
                System.out.println("| 5.Exit                                 |");
                System.out.println("+----------------------------------------+\n");
                System.out.print("Enter an Option Number: ");

                int userChoice = 0;
                while (userChoice == 0) {
                    userChoice = scanner.nextInt();

                    if (userChoice == 1) {
                        addVehicle(vehicleShowroom);
                        //System.out.println("Add Vehicle Option");
                    } else if (userChoice == 2) {
                        deleteVehicle(vehicleShowroom);
                    } else if (userChoice == 3) {
                        showVehicleListWithDetails(vehicleShowroom);
                    } else if (userChoice == 4) {
                        showExpectedVisitors(vehicleShowroom);
                    } else if (userChoice == 5) {
                        System.out.println("System is closing...");
                        System.out.println("Closed!");
                        break;
                    } else {
                        System.out.print("Error! Please read the option carefully and enter the valid option");
                        userChoice = 0;
                    }
                }
            }
        }

    }

    // ADD VEHICLE
    private static void addVehicle(DSIVehicleShowroom vehicleShowroom) {

        VehicleType vehicleType = null;
        String modelNumber = null;
        EngineType engineType = null;

        int enginePower = 0;
        int tireSize = 0;
        int weight = 0;

        boolean isturbo = false;

        List<Vehicle> vehicles = vehicleShowroom.getVehicleList(); // list for vehicles

        Scanner userChoice = new Scanner(System.in);

        // vehicle type
        System.out.println("+----------------------------------------+");
        System.out.println("|      Choose Your Vehicle Type!         |");
        System.out.println("+----------------------------------------+");
        System.out.println("|              1. Normal                 |");
        System.out.println("|              2. Heavy                  |");
        System.out.println("|              3. Sports                 |");
        System.out.println("+----------------------------------------+");
        System.out.print("Enter vehicle type number: ");

        int userVehicleChoice = 0;

        while (userVehicleChoice == 0) {
            userVehicleChoice = userChoice.nextInt();

            if (userVehicleChoice == 1) {
                vehicleType = VehicleType.Normal;
            } else if (userVehicleChoice == 2) {
                vehicleType = VehicleType.Heavy;
            } else if (userVehicleChoice == 3) {
                vehicleType = VehicleType.Sports;
            } else {
                System.out.print("Error! Please enter correctly: ");
                userVehicleChoice = 0;
            }
        }

        //vehicle type properties
        //normal vehicle
        if (vehicleType == VehicleType.Normal) {
            int userEngineType = 0;

            System.out.println("+----------------------------------------+");
            System.out.println("|      Choose Your Engine Type!          |");
            System.out.println("+----------------------------------------+");
            System.out.println("|              1. Oil                    |");
            System.out.println("|              2. Gas                    |");
            System.out.println("|              3. Diesel                 |");
            System.out.println("+----------------------------------------+");
            System.out.print("Enter the option's number: ");

            while (userEngineType == 0) {
                userEngineType = userChoice.nextInt();

                if (userEngineType == 1) {
                    engineType = EngineType.Oil;
                } else if (userEngineType == 2) {
                    engineType = EngineType.Gas;
                } else if (userEngineType == 3) {
                    engineType = EngineType.Diesel;
                } else {
                    System.out.print("Error! Please enter the valid number: ");
                    userEngineType = 0;
                }
            }
        }

        //sports vehicle
        if (vehicleType == VehicleType.Sports) {
            engineType = EngineType.Oil;
            System.out.println("+----------------------------------------+");
            System.out.println("|       Turbo Included with Vehicle?     |");
            System.out.println("+----------------------------------------+");
            System.out.println("|              1. YES                    |");
            System.out.println("|              2. NO                     |");
            System.out.println("+----------------------------------------+");
            System.out.print("Enter the option number: ");

            int turboOption = 0;
            while (turboOption == 0) {
                turboOption = userChoice.nextInt();

                if (turboOption == 2) {
                    isturbo = false;
                } else if (turboOption == 1) {
                    isturbo = true;
                } else {
                    System.out.print("Error! Enter correctly! ");
                    turboOption = 0;
                }
            }
            int visitor = vehicleShowroom.getExpectedVisitors();
            vehicleShowroom.setExpectedVisitors(visitor + hypeVisitor);
        }

        //heavy vehicle
        if (vehicleType == VehicleType.Heavy) {
            engineType = EngineType.Diesel;
            System.out.print("Please enter the weight of the vehicle: ");
            weight = userChoice.nextInt();
        }
        userChoice.nextLine();  // previously scanned integer value. Thats why it will work as a restart.

        // vehicle model 
        System.out.println("Please Enter your Vehicle Model Number: ");
        modelNumber = userChoice.nextLine();

        // vehicle engine power
        System.out.println("Enter the vehicle Engine Power: ");
        enginePower = userChoice.nextInt();

        // vehicle tire size
        System.out.println("Enter the tire size of the vehicle: ");
        tireSize = userChoice.nextInt();

        // Add vehicles to list
        if (vehicleType == VehicleType.Normal) {
            NormalVehicle theVehicle = new NormalVehicle(vehicleType, modelNumber, engineType, enginePower, tireSize);
            vehicles.add(theVehicle);

        } else if (vehicleType == VehicleType.Heavy) {
            HeavyVehicle theVehicle = new HeavyVehicle(vehicleType, modelNumber, enginePower, tireSize, weight);
            vehicles.add(theVehicle);

        } else if (vehicleType == VehicleType.Sports) {
            SportsVehicle theVehicle = new SportsVehicle(vehicleType, modelNumber, enginePower, tireSize, isturbo);
            vehicles.add(theVehicle);
        }
        System.out.println(vehicleType + " type vehicle is added successfully!");

    }

    // DELETE VEHICLE
    private static void deleteVehicle(DSIVehicleShowroom vehicleShowroom) {

        List<Vehicle> vehicles = vehicleShowroom.getVehicleList();

        Scanner scan = new Scanner(System.in);

        if (vehicles.size() == 0) {
            System.out.println("+----------------------------------------+");
            System.out.println("|         No Vehicles are Here!          |");
            System.out.println("+----------------------------------------+");

        } else {
            int index = -1;
            boolean isFirstTime = true;
            while (index < 0 || index >= vehicles.size()) {
                showVehicleListWithDetails(vehicleShowroom);
                if (isFirstTime == false) {
                    System.out.println("Error!");
                }
                isFirstTime = false;
                System.out.println("Please enter a valid index to delete: ");
                index = scan.nextInt();
            }
            Vehicle vehicle = vehicles.get(index);

            if (vehicle.getVehicleType() == VehicleType.Sports) {
                int visitors = vehicleShowroom.getExpectedVisitors();
                vehicleShowroom.setExpectedVisitors(visitors - hypeVisitor);
            }

            vehicles.remove(index);
            System.out.println("A vehicle has been removed!");
        }

    }

    // SHOW EXPECTED VISITORS
    private static void showExpectedVisitors(DSIVehicleShowroom vehicleShowroom) {

        List<Vehicle> vehicles = vehicleShowroom.getVehicleList();

        // 
        int gap = 20 - Integer.toString(vehicleShowroom.getExpectedVisitors()).length();
        String Gaps = "";
        for (int j = 0; j <= gap; j++) {
            Gaps = Gaps + " ";
        }

        System.out.println("+----------------------------------------+");
        System.out.println("|            Expected Visitors           |");
        System.out.println("+----------------------------------------+");
        System.out.println("|                   " + vehicleShowroom.getExpectedVisitors() + Gaps + "|");
        System.out.println("+----------------------------------------+");
        System.out.println();
        if (vehicles.size() == 0) {
            System.out.println("+----------------------------------------+");
            System.out.println("|         No Vehicles are added!         |");
            System.out.println("+----------------------------------------+");
        }

    }

    private static void showVehicleListWithDetails(DSIVehicleShowroom vehicleShowroom) {
        List<Vehicle> vehicleList = vehicleShowroom.getVehicleList();
        if (vehicleList.size() == 0) {
            System.out.println("+----------------------------------------+");
            System.out.println("|         No Vehicles are added!         |");
            System.out.println("+----------------------------------------+");
        } else {
            System.out.println("The vehicles are: ");
            System.out.println("+--------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("|Index     Vehicle Type    Model Number    Engine Type     Engine Power    Tire Size       Turbo           Weight          |");
            System.out.println("+--------------------------------------------------------------------------------------------------------------------------+");
            for (int i = 0; i < vehicleList.size(); i++) {
                Vehicle vehicle = vehicleList.get(i);
                // index gap calulate korar jonno
                int indexGap = 9 - Integer.toString(i).length();
                String indexGaps = "";
                for (int j = 0; j <= indexGap; j++) {
                    indexGaps = indexGaps + " ";
                }
                /////////////////////////////////
                System.out.println("|" + i + indexGaps + vehicle.getDetails() + "|");

            }
            System.out.println("+--------------------------------------------------------------------------------------------------------------------------+");

        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        new HomePage();
    }

}
