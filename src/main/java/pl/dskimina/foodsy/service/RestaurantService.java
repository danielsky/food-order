package pl.dskimina.foodsy.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dskimina.foodsy.entity.Restaurant;
import pl.dskimina.foodsy.entity.data.RestaurantData;
import pl.dskimina.foodsy.repository.RestaurantRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final ToDataService toDataService;

    public RestaurantService(RestaurantRepository restaurantRepository, ToDataService toDataService) {
        this.restaurantRepository = restaurantRepository;
        this.toDataService = toDataService;
    }

    @Transactional
    public void addRestaurant(String name, String phone, String Description){
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(UUID.randomUUID().toString());
        restaurant.setName(name);
        restaurant.setPhone(phone);
        restaurant.setDescription(Description);
        restaurantRepository.save(restaurant);
    }

    @Transactional
    public RestaurantData getRestaurantByRestaurantId(String restaurantId){
        Restaurant restaurant = restaurantRepository.findByRestaurantId(restaurantId);
        return toDataService.convert(restaurant);
    }

    @Transactional
    public List<RestaurantData> getRestaurants(){
        List<Restaurant> restaurantList = restaurantRepository.findAll();
        return restaurantList.stream().map(toDataService::convert).collect(Collectors.toList());
    }
}
