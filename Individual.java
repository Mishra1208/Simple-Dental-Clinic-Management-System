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
The Individual class serves as a fundamental component for managing individual entities within a clinic system.
It encapsulates four private attributes: entityID, firstName, lastName, and chargePercent, which respectively represent
unique identifiers, first names, last names, and associated charge percentages. Accessor methods (getEntityID(),
getFirstName(), getLastName(), getChargePercent()) retrieve attribute values, while mutator methods (setEntityID(String),
setFirstName(String), setLastName(String), setChargePercent(double)) enable the modification of these attributes.
The class features constructors for default initialization and custom instantiation with specific attribute values,
as well as a copy constructor for creating deep copies of Individual objects. Additional methods include equals(Individual)
for comparing objects based on entityID, toString() for generating formatted string representations, and utility methods
like upperCamelCase(String), multiUpperCamelCase(String), upperCase(String), and inStrToIndividualArr(String) for string
manipulation and object creation. These functionalities collectively facilitate the effective management, retrieval, and
manipulation of individual records within a clinic system.
===========================
ALGORITHM OF THE PROGRAM:
1) Class Definition:
* Define a class named Individual.
* Declare four private attributes: entityID, firstName, lastName, and chargePercent.
2) Constructor:
Define a copy constructor Individual(Individual i) that takes an Individual object as a parameter and initializes a new
object with the same attribute values.
3) Accessor and Mutator Methods:
Implement getter and setter methods for each attribute (getEntityID(), setEntityID(String), getFirstName(),
setFirstName(String), getLastName(), setLastName(String), getChargePercent(), setChargePercent(double)).
4) Default Constructor:
Implement a default constructor Individual() that initializes all attributes with default values
(empty string for names, 0.0 for charge percent).
5) Custom Constructor:
Define a custom constructor Individual(String entityID, String firstName, String lastName) that initializes attributes
with provided values and sets charge percent to the default value of 0.0.
6) Override toString Method:
Override the toString() method to provide a formatted string representation of the Individual object, including all
attribute values.
7) Clone Method:
Implement a cloneData() method that creates a new Individual object with the same attribute values as the current object and returns it.
===========================
 */
public class Individual {
    // Private attributes
    private String entityID;  // Stores the unique identifier for the individual
    private String firstName; // Stores the first name of the individual
    private String lastName;  // Stores the last name of the individual
    private double chargePercent; // Stores the charge percentage for the individual

    // Copy constructor
    public Individual(Individual i){
        this.entityID = i.getEntityID();  // Copies the entity ID from the given Individual object
        this.chargePercent = i.getChargePercent();  // Copies the charge percentage from the given Individual object
        this.firstName = i.getFirstName();  // Copies the first name from the given Individual object
        this.lastName = i.getLastName();    // Copies the last name from the given Individual object
    }

    // Getters and setters
    public String getEntityID() {  // Getter for entityID attribute
        return entityID;
    }

    public void setEntityID(String entityID) {  // Setter for entityID attribute
        this.entityID = entityID;
    }

    public String getFirstName() {  // Getter for firstName attribute
        return firstName;
    }

    public void setFirstName(String firstName) {  // Setter for firstName attribute
        this.firstName = firstName;
    }

    public String getLastName() {  // Getter for lastName attribute
        return lastName;
    }

    public void setLastName(String lastName) {  // Setter for lastName attribute
        this.lastName = lastName;
    }

    public double getChargePercent() {  // Getter for chargePercent attribute
        return chargePercent;
    }

    public void setChargePercent(double chargePercent) {  // Setter for chargePercent attribute
        this.chargePercent = chargePercent;
    }

    // Default constructor
    public Individual() {
        // Initialize attributes with default values
        this.entityID = "";  // Default value for entityID attribute
        this.firstName = ""; // Default value for firstName attribute
        this.lastName = "";  // Default value for lastName attribute
        this.chargePercent = 0.0;  // Default value for chargePercent attribute
    }

    // Custom constructor
    public Individual(String entityID, String firstName, String lastName) {
        // Initialize attributes with provided values
        this.entityID = entityID;    // Initialize entityID attribute with provided value
        this.firstName = firstName;  // Initialize firstName attribute with provided value
        this.lastName = lastName;    // Initialize lastName attribute with provided value
        this.chargePercent = 0.0;    // Default value for chargePercent attribute
    }

    // Override toString method
    @Override
    public String toString() {
        return "Individual{" +
                "entityID='" + entityID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", chargePercent=" + chargePercent +
                '}';
    }

    // Method to clone data of an individual
    public Individual cloneData() {
        Individual newIndividual = new Individual(this.getEntityID(), this.getFirstName(), this.getLastName());
        return newIndividual;
    }
}
