package com.app.Service;

import com.app.Model.Grocery;
import com.app.Repository.GroceryRepository;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroceryService {
    private final GroceryRepository groceryRepository;
    // @Autowired is not required if there's only one constructor in the class
    public GroceryService(GroceryRepository groceryRepository){
        this.groceryRepository = groceryRepository;
    }

    /**
     * Given a brand new transient grocery (meaning, no such grocery exists yet in the database),
     * persist the grocery to the database (create a new database record for the grocery entity.)
     */
    public Grocery persistGrocery(Grocery grocery){
        return groceryRepository.save(grocery);
    }

    /**
     * finaAll() will return all grocery entities stored in the DB table.
     * @return all Grocery entities.
     */
    public List<Grocery> getAllGroceries(){
        return groceryRepository.findAll();
    }

    /**
     * Because fingById() returns a type of Optional<Grocery>, we also need to apply .get() to convert the
     * Optional<Grocery> to Grocery. Optionals help the developer to avoid null pointer exceptions.
     * @param id the ID of the Grocery entity.
     * @return Grocery entity
     */
    public Grocery getGroceryById(long id){
        // findById returns a type Optional<Grocery>. This helps the developer avoid null pointer
        // exceptions. We can use the method .get() to convert an Optional<Grocery> to Grocery.
        Optional<Grocery> optionalGrocery = groceryRepository.findById(id);

        // Option 1: Check if a value is present and return it using .get(); otherwise, return null.
        // This is more explicit and allows for additional logic in the future if needed.
        if(optionalGrocery.isPresent()){
            return optionalGrocery.get();
        }else{
            return null;
        }

        // Option 2: A more concise alternative using orElse().
        // return optionalGrocery.orElse(null); 
    }

    /**
     * Delete a grocery entity by its ID.
     * 
     * @param id the ID of the Grocery entity to delete
     */
    public void deleteGrocery(long id){
        groceryRepository.deleteById(id);
    }

    /**
     * Given a Grocery ID and a replacement object, update the Grocery's name with the replacement's name.
     *
     * @param id the ID of the Grocery entity to update
     * @param replacement the Grocery object containing updated values
     */
    public void updateGrocery(long id, Grocery replacement){
        // findById returns a type Optional<Grocery>. This helps the developer avoid null pointer
        // exceptions. We can use the method .get() to convert an Optional<Grocery> to Grocery.
        Optional<Grocery> optionalGrocery = groceryRepository.findById(id);
        if(optionalGrocery.isPresent()){
            Grocery grocery = optionalGrocery.get();
            grocery.setName(replacement.getName());
            groceryRepository.save(grocery);
        }
    }
}