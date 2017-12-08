package com.stevenprogramming.demo.model;

import java.math.BigDecimal;

/**
 *
 * @author steven.mendez
 * @since 12/07/2016
 * @version 1.0
 */
public class User {
    
    private final String name;

    public User(String name) {
        this.name = name;
    }
 
    @Override
    public boolean equals(Object o) {
        if (o instanceof User) {
            final User user = (User) o;
            return name == null ? user.getName() == null : this.name.equals(user.getName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 29 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

}
