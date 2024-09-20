# Simple Dental Clinic Management System (SMDCMS)

## Overview
This Java program implements a Simple Mobile Dental Clinic Management System (SMDCMS) for Healthy Teeth©, aimed at assisting clinics' personal assistants, dentists, and management in handling daily tasks. This project was developed as part of COMP 248 - Winter 2024, Assignment 4 at Concordia University.

## Features
The SMDCMS provides a menu-driven interface that supports various administrative and clinical tasks:
- **Define Office/Clinic**: Set up new clinic details.
- **Add Dentist and Assistants**: Register dentists and dental assistants to the clinic.
- **Register and Deregister Patients**: Manage patient records.
- **Enter/Update Charges**: Manage and update patient charges.
- **Display Statistics**: View detailed statistics for patients and clinics.
- **Display Chargesheet**: Generate a summary of all patient charges.

## Classes and Methods

### 1. `DentalClinicDriver` Class
Serves as the main driver class for the SMDCMS application, providing the menu and facilitating user interaction.
- **Methods**:
  - `main(String[] args)`: Entry point of the application, presenting menu options and calling relevant methods.

### 2. `Clinic` Class
Manages clinic-level data and operations.
- **Attributes**: Clinic name, code, term, dentist, dental assistants, and patients.
- **Methods**:
  - Accessors and Mutators: Get and set clinic details.
  - `appendToIndividualArr(Individual[], int)`: Appends new individuals to existing arrays.
  - `deleteFromIndividualArr(String, int)`: Deletes specified individuals based on their ID.
  - `updateIndividualCharge(String, int)`: Updates charge information for patients.
  - `clinicStats()`: Displays clinic statistics.
  - `chargeSheet()`: Displays a detailed chargesheet for the clinic.

### 3. `Individual` Class
Handles information for individuals such as dentists, assistants, and patients.
- **Attributes**: Entity ID, first name, last name, and charge percentage.
- **Methods**:
  - Accessors and Mutators: Get and set individual details.
  - `equals(Individual)`: Compares two individuals based on their IDs.
  - `toString()`: Provides a formatted string of the individual's details.
  - Utility Methods: Includes methods for string formatting and converting input data to individual objects.

## Usage
1. Clone the repository to your local machine.
2. Compile and run the `DentalClinicDriver` class to start the SMDCMS application.
3. Follow the on-screen prompts to manage clinics, register individuals, and view reports.

## Installation
Ensure Java is installed. Compile the code with:
```bash
javac DentalClinicDriver.java
