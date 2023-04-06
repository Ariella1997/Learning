The Adapter Pattern allows us to enable objects with incompatible interfaces to work together. 

Steps 

1. Locate the Adaptee Class, and the Target class. 
2. Create the AbstractAdaptee interface, and place any methods you need adapted from the Adaptee class into the Adapter Class as an abstract method. 
3. (Skip if the Adaptee source code is not accessible.). Have the Adaptee class implement the AbstractAdaptee interface This should not change anything, as all the methods from AbstractAdaptee are extracted from Adaptee. 
4. Create the Adapter class, and have it implement the AbstractAdaptee interface. Also create a blank final Target class object that you will use. The Adapter class constructor should finish instantiating the final Target class object. The implemented methods should return or use the appropriate method from the Target object
5. Create any necessary conversion methods to convert parameters from the adaptee class into the parameters necessary for the Target object. 
6. Client should now be able to call the adapter class, and pass in the old parameters and get the desired result in the Target object. 
