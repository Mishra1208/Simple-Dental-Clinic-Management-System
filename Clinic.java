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
The provided Java program defines a class named Clinic, representing a dental clinic. It encapsulates essential clinic
details like name, code, and term, along with references to a dentist, dental assistants, and patients. The class offers
a range of functionalities to interact with and manipulate these attributes. Upon instantiation, the class can be
initialized either through a default constructor or a parameterized one, allowing for flexible setup of clinic instances.
Accessor methods (getters) and mutator methods (setters) are provided for all private fields, enabling retrieval and
modification of clinic information.Accessor methods (getters) and mutator methods (setters) are provided for all private
fields, enabling retrieval and modification of clinic information.Methods such as appendToPatientArr and
appendToDentalAsstArr facilitate the addition of new patients and dental assistants to the clinic, while corresponding
removal methods like removeFromPatientArr and removeFromDentalAsstArr enable the deletion of existing individuals.

===========================
ALGORITHM OF THE PROGRAM:
===========================
1) Start the Clinic Class Definition:
Define a class named Clinic to encapsulate clinic-related functionality.
2) Declare Class Variables:
Declare private variables to hold clinic details such as clinicName, clinicCode, and clinicTerm.
Include variables for a dentist, an array of dentalAsst (dental assistants), and an array of patient.
3) Write Constructors:
Implement a default constructor to initialize arrays with size 0 to avoid null pointer exceptions.
Provide a parameterized constructor to set initial values for clinic details and staff/patient arrays.
4) Accessor and Mutator Methods:
Write getter and setter methods for all private variables to access and modify their values.
5) Appending and Removing Individuals:
Implement methods like appendToPatientArr and appendToDentalAsstArr to add new patients and dental assistants respectively.
Include corresponding removal methods like removeFromPatientArr and removeFromDentalAsstArr to delete individuals.
6) Updating Patient Charges:
Create a method updatePatientCharges to modify the charge percentage for a specific patient.
7) Displaying Clinic and Patient Statistics:
Develop methods such as displayClinicStatistics and displayPatientsStatistics to showcase relevant statistics.
Ensure these methods print information such as the number of patients, number of dental assistants, and detailed patient information.
8) Displaying Charge Sheet:
Implement a method displayChargeSheet to present a summary of patient charges.
9) Utility Methods:
Write utility methods like copyArray to handle array operations efficiently.
 */
public class Clinic {
    // Declare private variables to hold clinic information
    private String clinicName; // Clinic name
    private String clinicCode; // Clinic code
    private String clinicTerm; // Clinic term
    private Individual dentist; // Dentist object
    private Individual[] dentalAsst; // Array of dental assistants
    private Individual[] patient; // Array of patients

    // Getters and setters for clinic information
    public String getClinicName() { // Getter for clinic name
        return clinicName;
    }

    public void setClinicName(String clinicName) { // Setter for clinic name
        this.clinicName = clinicName;
    }

    public String getClinicCode() { // Getter for clinic code
        return clinicCode;
    }

    public void setClinicCode(String clinicCode) { // Setter for clinic code
        this.clinicCode = clinicCode;
    }

    public String getClinicTerm() { // Getter for clinic term
        return clinicTerm;
    }

    public void setClinicTerm(String clinicTerm) { // Setter for clinic term
        this.clinicTerm = clinicTerm;
    }

    public Individual getDentist() { // Getter for dentist
        return dentist;
    }

    public void setDentist(Individual dentist) { // Setter for dentist
        this.dentist = dentist;
    }

    public Individual[] getDentalAsst() { // Getter for dental assistants
        return dentalAsst;
    }

    public void setDentalAsst(Individual[] dentalAsst) { // Setter for dental assistants
        this.dentalAsst = dentalAsst;
    }

    public Individual[] getPatient() { // Getter for patients
        return patient;
    }

    public void setPatient(Individual[] patient) { // Setter for patients
        this.patient = patient;
    }

    // Default constructor
    public Clinic() {
        // Initialize arrays with size 0 to avoid NullPointerException
        this.dentalAsst = new Individual[0]; // Initialize dental assistants array
        this.patient = new Individual[0]; // Initialize patients array
    }

    // Custom constructor
    public Clinic(String clinicName, String clinicCode, String clinicTerm, Individual dentist,
                  Individual[] dentalAsst, Individual[] patient) {
        // Initialize clinic with provided details
        this.clinicName = clinicName;
        this.clinicCode = clinicCode;
        this.clinicTerm = clinicTerm;
        this.dentist = dentist;
        this.dentalAsst = dentalAsst;
        this.patient = patient;
    }

    // Override toString method to provide string representation of clinic object
    @Override
    public String toString() {
        // Create string representation of dental assistants array
        StringBuilder dentalAsstString = new StringBuilder("[");
        for (int i = 0; i < dentalAsst.length; i++) {
            dentalAsstString.append(dentalAsst[i]);
            if (i < dentalAsst.length - 1) {
                dentalAsstString.append(", ");
            }
        }
        dentalAsstString.append("]");

        // Create string representation of patients array
        StringBuilder patientString = new StringBuilder("[");
        for (int i = 0; i < patient.length; i++) {
            patientString.append(patient[i]);
            if (i < patient.length - 1) {
                patientString.append(", ");
            }
        }
        patientString.append("]");

        // Return string representation of clinic object
        return "Clinic{" +
                "clinicName='" + clinicName + '\'' +
                ", clinicCode='" + clinicCode + '\'' +
                ", clinicTerm='" + clinicTerm + '\'' +
                ", dentist=" + dentist +
                ", dentalAsst=" + dentalAsstString +
                ", patient=" + patientString +
                '}';
    }

    // Method to append new individuals to the patient array
    public void appendToPatientArr(Individual[] individuals) {
        int currentLength = patient.length;
        int newLength = currentLength + individuals.length;
        patient = copyArray(patient, newLength);
        for (int i = 0; i < individuals.length; i++) {
            patient[currentLength + i] = individuals[i];
        }
    }

    // Method to remove individuals from the patient array
    public void removeFromPatientArr(String entityID) {
        Individual[] filteredPatients = new Individual[patient.length];
        int index = 0;
        for (Individual individual : patient) {
            if (!individual.getEntityID().equals(entityID)) {
                filteredPatients[index++] = individual;
            }
        }
        patient = copyArray(filteredPatients, index);
    }

    // Method to update patient charges
    public void updatePatientCharges(String entityID, double chargePercent) {
        for (Individual individual : patient) {
            if (individual.getEntityID().equals(entityID)) {
                individual.setChargePercent(chargePercent);
                break;
            }
        }
    }

    // Method to calculate and display patients' statistics
    public void displayPatientsStatistics() {
        System.out.println("Patients Statistics:");
        for (Individual individual : patient) {
            System.out.println("Patient: " + individual.getFirstName() + " " + individual.getLastName() +
                    ", Entity ID: " + individual.getEntityID() +
                    ", Charge Percent: " + individual.getChargePercent());
        }
    }

    // Method to calculate and display clinic statistics
    public void displayClinicStatistics() {
        int numPatients = patient.length;
        int numDentalAssistants = dentalAsst.length;

        System.out.println("Clinic Statistics:");
        System.out.println("Number of Patients: " + numPatients);
        System.out.println("Number of Dental Assistants: " + numDentalAssistants);
        System.out.println("Dentist: " + dentist.getFirstName() + " " + dentist.getLastName());
    }

    // Method to display chargesheet
    public void displayChargeSheet() {
        System.out.println("Charge Sheet:");
        for (Individual individual : patient) {
            System.out.println("Patient: " + individual.getFirstName() + " " + individual.getLastName() +
                    ", Entity ID: " + individual.getEntityID() +
                    ", Charge Percent: " + individual.getChargePercent());
        }
    }

    // Method to append new individuals to the dental assistant array
    public void appendToDentalAsstArr(Individual[] individuals) {
        int currentLength = dentalAsst.length;
        int newLength = currentLength + individuals.length;
        dentalAsst = copyArray(dentalAsst, newLength);
        for (int i = 0; i < individuals.length; i++) {
            dentalAsst[currentLength + i] = individuals[i];
        }
    }

    // Utility method to copy array with new length
    private Individual[] copyArray(Individual[] array, int length) {
        Individual[] newArray = new Individual[length];
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }

    // Method to append new individuals to the dental assistant array
    public void appendToIndividualArr(Individual[] assistants) {
        // Copy existing dental assistants
        Individual[] actualList = getDentalAsst();
        Individual[] newList = new Individual[actualList.length + assistants.length];
        int index = 0;
        // Add existing assistants to the new list
        for(int i=0;i< actualList.length;i++) {
            newList[index] = new Individual(actualList[i]);
            index++;
        }
        // Add new assistants to the new list
        for(int i=0;i< assistants.length;i++) {
            newList[index] = new Individual(assistants[i]);
            index++;
        }
        // Set the updated list of dental assistants
        setDentalAsst(newList);
        // TODO Auto-generated method stub
        // Method to deregister Dental Assistant(s) and/or Patient(s)
    }

    // Method to remove a dental assistant from the array
    public void removeFromDentistArray(int index) {
        Individual[] newList = new Individual[dentalAsst.length - 1];
        int newIndex=0;
        for(int i=0;i<dentalAsst.length;i++) {
            if(index == i) {
                continue;
            }
            // Clone the individual data to avoid reference issues
            newList[newIndex] = dentalAsst[i].cloneData();
            newIndex++;
        }
        // Set the updated array of dental assistants
        setDentalAsst(newList);
    }

    // Method to remove a patient from the array
    public void removeFromPatientArray(int index) {
        Individual[] newList = new Individual[patient.length - 1];
        int newIndex=0;
        for(int i=0;i<patient.length;i++) {
            if(index == i) {
                continue;
            }
            // Clone the individual data to avoid reference issues
            newList[newIndex] = patient[i].cloneData();
            newIndex++;
        }
        // Set the updated array of patients
        setPatient(newList);
    }
}
