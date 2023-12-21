import java.util.ArrayList;
import java.util.List;

// Generic class representing an appliance service item
class ApplianceServiceItem<T> {
    private T appliance;

    public ApplianceServiceItem(T appliance) {
        this.appliance = appliance;
    }

    public T getAppliance() {
        return appliance;
    }

    public void setAppliance(T appliance) {
        this.appliance = appliance;
    }

    @Override
    public String toString() {
        return "ApplianceServiceItem{" +
                "appliance=" + appliance +
                '}';
    }
}

// Generic interface for appliance service operations
interface ApplianceServiceOperations<T> {
    void scheduleService(T appliance);
    void cancelService(T appliance);
}

// Generic class for managing a collection of appliance service items
class ApplianceServiceManager<T extends ApplianceServiceItem<S>, S> implements ApplianceServiceOperations<T> {
    private List<T> serviceItems;

    public ApplianceServiceManager() {
        this.serviceItems = new ArrayList<>();
    }

    public void addItemToServices(T serviceItem) {
        serviceItems.add(serviceItem);
    }

    public void displayServices() {
        System.out.println("Appliance Services:");
        for (T item : serviceItems) {
            System.out.println(item);
        }
    }

    @Override
    public void scheduleService(T serviceItem) {
        System.out.println("Scheduling service for: " + serviceItem);
        // Implement scheduling logic here
    }

    @Override
    public void cancelService(T serviceItem) {
        System.out.println("Canceling service for: " + serviceItem);
        // Implement cancel service logic here
    }
}

// Example usage
public class Labexercise6 {
    public static void main(String[] args) {
        // Creating service items for appliances
        ApplianceServiceItem<Appliance> applianceServiceItem1 =
                new ApplianceServiceItem<>(new Appliance("Refrigerator", "Samsung"));
        ApplianceServiceItem<Appliance> applianceServiceItem2 =
                new ApplianceServiceItem<>(new Appliance("Washing Machine", "LG"));

        // Creating a service manager for appliance services
        ApplianceServiceManager<ApplianceServiceItem<Appliance>, Appliance> applianceServiceManager =
                new ApplianceServiceManager<>();

        // Adding items to the services
        applianceServiceManager.addItemToServices(
                new ApplianceServiceItem<>(new Appliance("Microwave Oven", "Whirlpool")));
        applianceServiceManager.addItemToServices(applianceServiceItem1);
        applianceServiceManager.addItemToServices(applianceServiceItem2);

        // Displaying the services
        applianceServiceManager.displayServices();

        // Scheduling and canceling services
        applianceServiceManager.scheduleService(applianceServiceItem1);
        applianceServiceManager.cancelService(applianceServiceItem2);

        // Displaying the updated services
        applianceServiceManager.displayServices();
    }
}

// Class representing an appliance
class Appliance {
    private String type;
    private String brand;

    public Appliance(String type, String brand) {
        this.type = type;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Appliance{" +
                "type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
