//---------------------------------------------------------------------------------------------------------------------
//***************
// Assignment 4
//***************
// Written by:[NARENDRA MISHRA] [Student ID:40224303]
// For COMP 248 Section: W – Winter 2024
// Date of Submission : 15-04-2024
// --------------------------------------------------------------------------------------------------------------------
/*
=======================
PROGRAM DESCRIPTION:
=======================
This Java program serves as the driver class for a Simple Mobile Dental Clinic Management System (SMDCMS). It includes
the main method where users interact with the system through a menu-based interface. The program displays a welcome
message, presents menu options, and prompts users for input using a scanner. It enables users to perform various tasks
such as defining offices/clinics, adding dentists and dental assistants, registering patients, managing charges, and
displaying statistics. Finally, the program provides a graceful exit option for users.

===========================
ALGORITHM OF THE PROGRAM:
===========================
Main Method (main)
* Import the Scanner class to enable user input.
* Define the main method as the entry point of the program.
* Create a new Scanner object to read user input.
* Instantiate a Clinic object to manage clinic-related operations.
* Display a welcome message and menu options using the displayMenu method.
* Enter a continuous loop to prompt the user for menu codes until the user chooses to exit.
     * Prompt the user to enter a menu code.
     * Use a switch-case statement to perform different actions based on the menu code entered.
     * Handle invalid menu codes by displaying an error message and allowing the user to try again.
     * Ensure proper termination of the loop upon choosing the exit option.

                                 ************* Helper Methods*************
1) displayMenu Method:
* Display the main menu options with corresponding menu codes.
1.1) defineClinic Method:
* Prompt the user to enter office/clinic information (ClinicName, ClinicCode, and Term/Permit) as a single-line entry.
* Validate the input to ensure that at least three pieces of information are provided.
* Set the clinic information in the Clinic object.
* Display a success message upon successful definition of the office/clinic.
* Handle insufficient information provided by displaying an error message.

1.2) addDentist Method:
* Prompt the user to enter dentist information (EmployeeID, FirstName, and LastName) as a single-line entry.
* Validate the input to ensure that at least three pieces of information are provided.
* Create a new Individual object for the dentist.
* Set the dentist in the Clinic object.
* Display a success message upon successful addition of the dentist.
* Handle insufficient information provided by displaying an error message.

1.3) addDentalAssistants Method:
* Prompt the user to enter dental assistant(s) information (ID1,FirstName1,LastName1;ID2,FirstName2,LastName2;) as a single-line entry.
* Split the input into individual assistant details.
* Iterate through each assistant detail and validate the format.
* Check if the assistant already exists in the clinic.
* Add the assistant to the clinic if it doesn't exist.
* Display status messages indicating successful addition or existing assistants.
* Handle invalid format for assistant information by displaying an error message.

1.4) registerPatients Method:
* Prompt the user to enter patient(s) information (ID1,FirstName1,LastName1;ID2,FirstName2,LastName2) as a single-line entry.
* Split the input into individual patient details.
* Iterate through each patient detail and validate the format.
* Check if the patient already exists in the clinic.
* Add the patient to the clinic if it doesn't exist.
* Display status messages indicating successful addition or existing patients.
* Handle invalid format for patient information by displaying an error message.

1.5) deregisterDentalAssistantsAndPatients Method:
* Prompt the user to choose between deregistering dental assistants or patients.
* Prompt the user to enter entity IDs of assistants or patients to deregister.
* Validate the input and perform deregistration accordingly.
* Display status messages indicating successful deregistration or non-existing entries.
* Handle invalid menu options and input by displaying error messages.

1.6) enterUpdatePatientCharges Method:
* Prompt the user to enter patient charges (ID1,Charge1;ID2,Charge2) as a single-line entry.
* Split the input into individual patient charge details.
* Iterate through each charge detail and update the charge for the corresponding patient.
* Display status messages indicating successful charge updates or non-existing patients.
* Handle invalid format for charge information by displaying an error message.

1.7) displayPatientsStatistics Method:
* Display the clinic name and dentist's name.
* Display the number of dental assistants and registered patients.
* Display patient information including last name, first name, and entity ID.
* Iterate through the patient array and print each patient's details.

1.8) displayClinicStatistics Method:
* Display clinic information including name, code, and term/permit.
* Display dentist information if available.
* Display dental assistants' information if available.
* Display the number of registered patients.

1.9) displayChargeSheet Method:
* Display the chargesheet header with column names.
* Copy the patient array to avoid modifying the original array.
* Sort patients based on their charges in ascending order using the insertion sort algorithm.
* Display patient details including entity ID, last name, first name, and charge.
* Iterate through the sorted patients array and print each patient's charge details.

1.10)

Exit the system 

*/

import java.util.Scanner;

public class DentalClinicDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Clinic clinic = new Clinic(); // Initialize a new Clinic object

        // Display welcome message and menu options
        System.out.println("Welcome to Simple Mobile Dental Clinic Management System (SMDCMS)");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        displayMenu();

        // Prompt the user for the first menu code
        int choice;

        // Continue displaying the menu until the user chooses to exit
        while (true) {
            System.out.print("\nEnter a menu code: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1001:
                    // Define Office/Clinic
                    defineClinic(scanner, clinic);
                    break;
                case 1002:
                    // Add Dentist to Office/Clinic
                    addDentist(scanner, clinic);
                    break;
                case 1003:
                    // Add Dental Assistants to Office/Clinic
                    addDentalAssistants(scanner, clinic);
                    break;
                case 1004:
                    // Register Patient(s) to Office/Clinic
                    registerPatients(scanner, clinic);
                    break;
                case 1005:
                    // Deregister Dental Assistant(s) and/or Patient(s)
                    String msg = deregisterDentalAssistantsAndPatients(scanner, clinic);
                    System.out.println(msg);
                    break;
                case 1006:
                    // Enter/Update Patient(s) Charges
                    String message = enterUpdatePatientCharges(scanner, clinic);
                    System.out.println(message);
                    break;
                case 1007:
                    // Display Patients' Statistics
                    displayPatientsStatistics(scanner, clinic);
                    break;
                case 1008:
                    // Display Office/Clinic Statistics
                    displayClinicStatistics(clinic);
                    break;
                case 1009:
                    // Display Chargesheet
                    displayChargeSheet(scanner, clinic);
                    break;
                case 1010:
                    // Exit
                    System.out.println("Simple SMDCMS >>> Exiting...\n" +
                            "\nThank you for fostering our Simple Mobile Dental Clinic Management System (SMDCMS). ");
                    System.exit(0);
                default:
                    System.out.println("Invalid menu code. Please try again.");
            }
        }
    }


    // Method to display the main menu
    private static void displayMenu() {
        System.out.println("\nMenu Options:");
        System.out.println("1001: Define Office/Clinic");
        System.out.println("1002: Add Dentist to Office/Clinic");
        System.out.println("1003: Add Dental Assistants to Office/Clinic");
        System.out.println("1004: Register Patient(s) to Office/Clinic");
        System.out.println("1005: Deregister Dental Assistant(s) and/or Patient(s)");
        System.out.println("1006: Enter/Update Patient(s) Charges");
        System.out.println("1007: Display Patients' Statistics");
        System.out.println("1008: Display Office/Clinic Statistics");
        System.out.println("1009: Display Chargesheet");
        System.out.println("1010: Exit");
    }

    // Method to define Office/Clinic (menu code 1001)
    private static void defineClinic(Scanner scanner, Clinic clinic) {
        System.out.println("...Define Office/Clinic...");
        System.out.println(".........................");
        System.out.println("Enter Office/Clinic information (ClinicName ClinicCode Term/Permit) as a single-line entry:");
        String[] clinicInfo = scanner.nextLine().split("\\s+");

        // Check if at least 3 pieces of information are provided
        if (clinicInfo.length >= 3) {
            String clinicName = clinicInfo[0];
            String clinicCode = clinicInfo[1];
            String clinicTerm = clinicInfo[2];

            // Set the clinic information in the Clinic object
            clinic.setClinicName(clinicName);
            clinic.setClinicCode(clinicCode);
            clinic.setClinicTerm(clinicTerm);

            System.out.println("Office/Clinic defined successfully.");
        } else {
            System.out.println("Insufficient information provided. Please provide ClinicName, ClinicCode, and Term/Permit.");
        }
    }

    // Method to add Dentist to Office/Clinic (menu code 1002)
    private static void addDentist(Scanner scanner, Clinic clinic) {
        System.out.println("...Add Dentist for Office/Clinic...");
        System.out.println(".....................................");
        System.out.println("Enter dentist's information (EmployeeID FirstName LastName) as a single-line entry:");
        String[] dentistInfo = scanner.nextLine().split("\\s+");

        // Check if at least 3 pieces of information are provided
        if (dentistInfo.length >= 3) {
            String entityID = dentistInfo[0];
            String firstName = dentistInfo[1];
            String lastName = dentistInfo[2];

            // Create a new Individual object for the dentist
            Individual dentist = new Individual(entityID, firstName, lastName);

            // Set the dentist in the Clinic object
            clinic.setDentist(dentist);

            System.out.println("Dentist added successfully.");
        } else {
            System.out.println("Insufficient information provided. Please provide EmployeeID, FirstName, and LastName.");
        }
    }

    // Method to add Dental Assistants to Office/Clinic (menu code 1003)
    private static void addDentalAssistants(Scanner scanner, Clinic clinic) {
        System.out.println("...Add Dental Assistant(s) (Hygienists/Clerks) to Office/Clinic...");
        System.out.println("......................................................");
        System.out.println("Enter Dental Assistant(s) information (ID1,FirstName1,LastName1;ID2,FirstName2,LastName2;):");
        String input = scanner.nextLine();

        // Split the input string into individual assistant information using ';' as the delimiter
        String[] assistantInfo = input.split(";");

        StringBuilder statusMessages = new StringBuilder();// StringBuilder to store status messages

        // Iterate over each assistant information
        for (String info : assistantInfo) {
            // Split the assistant information into details using ',' as the delimiter
            String[] details = info.split(",");
            // Check if all details are present (ID, FirstName, LastName)
            if (details.length == 3) {
                // Extract ID, FirstName, and LastName from the details array
                String entityID = details[0];
                String firstName = details[1];
                String lastName = details[2];

                // Check if the assistant already exists in the clinic
                boolean exists = false;
                for (Individual assistant : clinic.getDentalAsst()) {
                    // If an assistant with the same ID is found
                    if (assistant != null && assistant.getEntityID().equals(entityID)) {
                        // Append a message indicating that the assistant already exists
                        statusMessages.append("Already Exists: ").append(assistant.getLastName()).append(", ").append(assistant.getFirstName()).append("(").append(entityID).append(").\n");
                        exists = true;
                        break;// Stop searching once a match is found
                    }
                }

                // If the assistant doesn't exist, add it
                if (!exists) {
                    // Create a new Individual object for the assistant
                    Individual assistant = new Individual(entityID, firstName, lastName);
                    // Add the assistant to the clinic's list of dental assistants
                    clinic.appendToIndividualArr(new Individual[]{assistant});
                    // Append a message indicating that the assistant was successfully added
                    statusMessages.append("Successfully Added: ").append(lastName.toUpperCase()).append(", ").append(firstName).append(" (").append(entityID).append(").\n");
                }
            } else {
                // If the assistant information is not in the correct format, append an error message
                statusMessages.append("Invalid format for assistant information: ").append(info).append("\n");
            }
        }

        // Print the status messages
        System.out.println(statusMessages);
    }

    // Method to register Patient(s) to Office/Clinic (menu code 1004)
    private static void registerPatients(Scanner scanner, Clinic clinic) {
        System.out.println("...Register Patient(s) at Office/Clinic...");
        System.out.println("......................................................");
        // Prompt the user to enter patient information
        System.out.println("Enter patient information (ID1,FirstName1,LastName1;ID2,FirstName2,LastName2):");
        String input = scanner.nextLine();
        // Split the input into individual patient information using ';' as the delimiter
        String[] patientInfo = input.split(";");

        // StringBuilder to store status messages
        StringBuilder statusMessages = new StringBuilder();

        // Iterate over each patient information
        for (String info : patientInfo) {
            // Split the patient information into details using ',' as the delimiter
            String[] details = info.split(",");
            // Check if all details are present (ID, FirstName, LastName)
            if (details.length == 3) {
                // Extract ID, FirstName, and LastName from the details array
                String entityID = details[0];
                String firstName = details[1];
                String lastName = details[2];
                // Check if the patient already exists
                boolean exists = false;
                for (int i = 0;i<clinic.getPatient().length;i++) {
                    // If a patient with the same ID is found
                    if (clinic.getPatient()[i].getEntityID().equals(entityID)) {
                        // Set exists flag to true
                        exists = true;
                        break;
                    }
                }
                // If the patient doesn't exist, add it to the clinic
                if(!exists) {
                    // Create a new Individual object for the patient
                    Individual patient = new Individual(entityID, firstName, lastName);

                    // Add the patient to the clinic
                    clinic.appendToPatientArr(new Individual[]{patient});

                    // Generate status message
                    statusMessages.append("Successfully Added: ").append(lastName.toUpperCase()).append(", ").append(firstName).append(" (").append(entityID).append(").\n");
                }
                // If the patient already exists, append an error message to the status messages
                else
                {
                    statusMessages.append("Patient with id: " + entityID + " already exists");
                    statusMessages.append("\n");
                }
            } else {
                // If the patient information is not in the correct format, append an error message to the status messages
                statusMessages.append("Invalid format for patient information: ").append(info).append("\n");
            }
        }

        // Print the status messages
        System.out.println(statusMessages.toString());
    }


    // Method to deregister Dental Assistant(s) and/or Patient(s) (menu code 1005)
    private static String deregisterDentalAssistantsAndPatients(Scanner scanner, Clinic clinic) {
        System.out.println("...Deregister Dental Assistant (s) and/or Patient (s)...");
        System.out.println("..........................................................");
        System.out.println("Enter '1003' to deregister Dental Assistant(s) and '1004' to deregister patient(s):");
        // Read the menu option entered by the user
        int menuOption = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        // Prompt the user to enter the IDs of entities to be deregistered
        System.out.println("Enter information of entities (ID1;ID2):");
        String input = scanner.nextLine();
        String[] entityIDs = input.split(";");

        // StringBuilder to store status messages
        StringBuilder statusMessages = new StringBuilder();

        // Switch statement to handle different menu options (1003(Dental Assistant) and 1004(Patients))
        switch (menuOption) {
            case 1003:
                // Loop through each entity ID provided by the user
                for (String entityId : entityIDs) {
                    boolean found = false;
                    // Iterate over the array of dental assistants
                    for (int i = 0; i < clinic.getDentalAsst().length; i++) {
                        Individual assistant = clinic.getDentalAsst()[i];
                        // Check if the assistant exists and its ID matches the provided entity ID
                        if (assistant != null && assistant.getEntityID().equals(entityId)) {
                            // If found, remove the assistant from the clinic
                            clinic.removeFromDentistArray(i);
                            // Append a success message to the status messages
                            statusMessages.append("Successfully Deleted: ").append(assistant.getLastName().toUpperCase()).append(", ").append(assistant.getFirstName()).append(" (").append(entityId).append(").\n");
                            found = true;
                            break;
                        }
                    }
                    // If the assistant is not found, append an error message to the status messages
                    if (!found) {
                        statusMessages.append("Entry NOT found: ").append(entityId).append(".\n");
                    }
                }
                break;
            case 1004:
                // Loop through each entity ID provided by the user
                for (String entityId : entityIDs) {
                    boolean found = false;
                    // Iterate over the array of patients
                    for (int i = 0; i < clinic.getPatient().length; i++) {
                        Individual patient = clinic.getPatient()[i];
                        // Check if the patient exists and its ID matches the provided entity ID
                        if (patient != null && patient.getEntityID().equals(entityId)) {
                            // If found, remove the patient from the clinic
                            clinic.removeFromPatientArray(i);
                            // Append a success message to the status messages
                            statusMessages.append("Successfully Deleted: ").append(patient.getLastName().toUpperCase()).append(", ").append(patient.getFirstName()).append(" (").append(entityId).append(").\n");
                            found = true;
                            break;
                        }
                    }
                    // If the patient is not found, append an error message to the status messages
                    if (!found) {
                        statusMessages.append("Entry NOT found: ").append(entityId).append(".\n");
                    }
                }
                break;
            // If an invalid menu option is entered, append an error message to the status messages
            default:
                statusMessages.append("Invalid menu option.").append("\n");
        }
        // Return the status messages
        return statusMessages.toString();
    }

    //Method to Enter/Update Patient(s) Charge (Menu code 1006)
    private static String enterUpdatePatientCharges(Scanner scanner, Clinic clinic) {
        System.out.println("...Enter/Update Patient(s) Charges...");
        System.out.println("....................................");
        System.out.println("Enter Patients' Charges (ID1,Charge1;ID2,Charge2):");
        // Read the input containing patient IDs and charges
        String input = scanner.nextLine();
        // Split the input string to extract patient ID and charge pairs
        String[] updateInfo = input.split(";");
        // StringBuilder to store status messages
        StringBuilder statusMessages = new StringBuilder();

        // Loop through each patient charge information provided by the user
        for (String info : updateInfo) {
            // Split the patient ID and charge
            String[] details = info.split(",");
            String id = details[0]; // Extract patient ID
            Double charge = Double.valueOf(details[1]);  // Extract charge value
            int i;
            // Loop through the array of patients to find the patient with the specified ID
            for (i = 0; i < clinic.getPatient().length; i++) {
                // Check if the patient ID matches
                if (clinic.getPatient()[i].getEntityID().equals(id)) {
                    // If found, update the patient's charge
                    clinic.getPatient()[i].setChargePercent(charge);
                    // Append a success message to the status messages
                    statusMessages.append("Patient with id: " + id + " updated with charges :" + charge);
                    statusMessages.append("\n");
                    break;
                }
            }
            // If the patient ID is not found in the clinic, append an error message to the status messages
            if (i == clinic.getPatient().length) {
                statusMessages.append("Patient with id: " + id + " is not present");
                statusMessages.append("\n");
            }
        }
        // Return the status messages
        return statusMessages.toString();
    }

    // Method to display Patients' Statistics (menu code 1007)
    private static void displayPatientsStatistics(Scanner scanner, Clinic clinic) {
        System.out.println("...Display Patients' Statistics...");
        System.out.println("..................................");
        System.out.println(clinic.getClinicName()+" "+clinic.getClinicTerm()); // Display clinic name
        // Display the dentist's name
        System.out.println("Dr. "+ clinic.getDentist().getLastName().toUpperCase() +", "+ clinic.getDentist().getFirstName() +
                " "+clinic.getDentist().getEntityID());
        // Calculate and display the total number of dental assistants
        int totalDentalAssistants = clinic.getDentalAsst().length;
        System.out.println("Dentist Assistant: " + totalDentalAssistants);

        // Calculate and display the total number of registered patients
        int totalPatients = clinic.getPatient().length;
        System.out.println("The Number of patient registered with the clinic: " + totalPatients);
        System.out.println("...................................................");
        // Display patient information
        System.out.println("Displaying patient information:");
        // Loop through each patient and display their information
        for (int i = 0; i < clinic.getPatient().length; i++) {
            Individual patient = clinic.getPatient()[i];
            System.out.println((i + 1) + ": " + patient.getLastName().toUpperCase() + ", " + patient.getFirstName() + " (" + patient.getEntityID() + ")");
        }
    }

    // Method to display Office/Clinic Statistics (menu code 1008)
    private static void displayClinicStatistics(Clinic clinic) {
        System.out.println(".................Office/Clinic Statistics....................");
        System.out.println(".............................................................");
        // Display clinic information
        System.out.println(String.format("%-25s: %s", "Clinic name", clinic.getClinicName()));//Clinic Name
        System.out.println(String.format("%-25s: %s", "Clinic Code", clinic.getClinicCode()));// Clinic Code
        System.out.println(String.format("%-25s: %s", "Term/Permit", clinic.getClinicTerm()));// Clinic Term

        // Display Dentist information
        Individual dentist = clinic.getDentist();
        if (dentist != null) {
            String dentistName = "Dr. " + dentist.getLastName().toUpperCase() + " " + dentist.getFirstName() + " (" + dentist.getEntityID() + ")";
            System.out.println(String.format("%-25s: %s", "Dentist Name", dentistName));
        } else {
            // Notify if no dentist is added to the clinic
            System.out.println("No dentist added to the clinic.");
        }

        // Display Dental Assistants information
        Individual[] dentalAssistants = clinic.getDentalAsst();

        if (dentalAssistants != null && dentalAssistants.length > 0) {
            // Loop through dental assistants and display their information
            for (int i = 0; i < dentalAssistants.length; i++) {
                Individual assistant = dentalAssistants[i];
                if (assistant != null) {
                    // Format and display dental assistant's information
                    System.out.println(String.format("%-22s %d: %s, %s (%s)", "Dental Assistant", (i + 1), assistant.getLastName(), assistant.getFirstName(), assistant.getEntityID()));
                }
            }
        } else {
            // Notify if no dental assistants are added to the clinic
            System.out.println("No dental assistants added to the clinic.");
        }

        // Display number of registered patients
        Individual[] patients = clinic.getPatient();
        int totalPatients = patients != null ? patients.length : 0;
        System.out.println(String.format("%-24s: %d", "Registered patients", totalPatients));//display total number of registered patients
    }


    //   Method to display Charge-sheet (menu code 1009)
    private static void displayChargeSheet(Scanner sc, Clinic clinic) {
        System.out.println(".................Office/Clinic Chargesheet...................");
        // Format and display column headers for patient ID, surname, firstname, and charge
        System.out.printf("%-4s %-12s %-10s %-10s %s\n", "P/N.", "Patient ID", "Surname", "Firstname", "Charge");
        System.out.println(".............................................................");
        // Copy the patient array to avoid modifying the original array
        Individual[] patients = clinic.getPatient().clone();

        // Perform insertion sort to sort patients by charge percent
        for (int i = 1; i < patients.length; i++) {
            Individual key = patients[i];
            int j = i - 1;
            // Sort patients based on charge percent in ascending order
            while (j >= 0 && patients[j].getChargePercent() > key.getChargePercent()) {
                patients[j + 1] = patients[j];
                j = j - 1;
            }
            patients[j + 1] = key;
        }

        // Display patient details
        for (int i = 0; i < patients.length; i++) {
            Individual patient = patients[i];
            // Format charge to display with two decimal places
            String formattedCharge = String.format("%.2f", patient.getChargePercent());
            // Display patient information including patient ID, surname, firstname, and charge
            System.out.printf("%-4d %-12s %-10s %-10s %s\n",
                    i + 1,
                    patient.getEntityID(),
                    patient.getLastName().toUpperCase(),
                    patient.getFirstName(),
                    formattedCharge);
        }
        // Display footer for the chargesheet
        System.out.println(".............................................................");
    }

}
