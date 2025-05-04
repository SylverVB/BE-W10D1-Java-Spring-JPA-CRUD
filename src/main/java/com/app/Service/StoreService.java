package com.app.Service;

import com.app.Model.Store;
import com.app.Repository.StoreRepository;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {
    private final StoreRepository storeRepository;
    // @Autowired is not required if there's only one constructor in the class
    public StoreService(StoreRepository storeRepository){
        this.storeRepository = storeRepository;
    }

    /**
     * Persists a new store entity to the database.
     * @param store a transient store entity to be persisted
     * @return the persisted store entity
     */
    public Store persistStore(Store store){
        return storeRepository.save(store);
    }

    /**
     * Retrieves all store entities from the database.
     * @return a list of all store entities
     */
    public List<Store> getAllStores(){
        return storeRepository.findAll();
    }

    /**
     * Retrieves a store entity by its ID.
     * @param id the ID of the store entity
     * @return the store entity if found, otherwise null
     */
    public Store getStoreById(long id){
        Optional<Store> optionalStore = storeRepository.findById(id);
    
        /**
         * Option 1: Using isPresent() and .get()
         * 
         * Here we manually check for the presence of a value before calling .get(). 
         * This avoids potential NullPointerException because we're explicitly checking 
         * before accessing the value. This approach is more verbose but very explicit.
         */
        if (optionalStore.isPresent()) {
            return optionalStore.get();  // Return the store if present
        } else {
            return null;  // Return null if store is not found
        }
    
        /**
         * Option 2: Using orElse()
         * 
         * .orElse(null) returns null if the Optional is empty, so there’s no risk of a 
         * NullPointerException in the code itself. This is a more concise way of handling 
         * the Optional, but we need to ensure the result is checked for null before usage.
         */
        // return optionalStore.orElse(null);  // Return the store if present, or null if not found
    }

    /**
     * Deletes a store entity by its ID.
     * @param id the ID of the store entity to delete
     */
    public void deleteStore(long id){
        storeRepository.deleteById(id);
    }

    /**
     * Updates an existing store entity with new data.
     * @param id the ID of the store to update
     * @param replacement the store entity containing updated data
     * @return the updated store entity, or null if the store was not found
     */
    public Store updateStore(long id, Store replacement){
        Optional<Store> optionalStore = storeRepository.findById(id);
        
        /** 
         * Option 1: Using isPresent()
         * 
         * Check if the Optional<Store> contains a value (isPresent()). If it contains a value,
         * access the store using .get(), modify it, and save it. Return the updated store, or null if the 
         * store is not found.
         */
        if (optionalStore.isPresent()) {
            Store store = optionalStore.get();
            store.setName(replacement.getName());
            store.setAddress(replacement.getAddress());
            return storeRepository.save(store);  // Return the updated store after saving
        }
        return null;  // Return null if store is not found
    
        /** 
         * Option 2: Using ifPresent()
         * 
         * ifPresent() takes a lambda expression that will only be executed if the Optional contains a
         * value. If the Optional contains a store, the lambda is executed, and the store is updated, 
         * saved, and returned. If the Optional is empty, the lambda is not executed, and the method returns 
         * null.
         */
        // optionalStore.ifPresent(store -> {
        //     store.setName(replacement.getName());
        //     store.setAddress(replacement.getAddress());
        //     storeRepository.save(store);
        // });
        // return optionalStore.orElse(null);  // Return the store if updated, or null if not found
    }
}