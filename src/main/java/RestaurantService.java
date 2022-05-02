import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName){
        List<Restaurant> restaurantList = getRestaurants();

        for(Restaurant res : restaurantList){
            if (res.getName().contains(restaurantName)){
                return res;
            }
        }
        return null;
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {

        return restaurants;
    }

    public int getTotalAmount(Restaurant restaurant, List<String> itemList){
        int totalAmount = 0;
        List<Item> menu = restaurant.getMenu();
        for(Item eachItem : menu){
            if (itemList.contains(eachItem.getName())){
                totalAmount += eachItem.getPrice();
            }
        }
        return totalAmount;
    }
}
