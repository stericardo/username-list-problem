package com.stevenprogramming.demo.dao;

import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author steven.mendez
 * @since Dec 07 2017
 * @version 1.0
 */
public interface UserNameDao {

    void addRestrictedWord(String restrictedWord);

    boolean checkIfUserNameExist(String userName, TreeSet<String> elements);

    boolean checkIfUserNameIsValid(String userName, TreeSet<String> elements);

    String getError();
    
    Set<String> getRestrictedWords();

    Set<String> getUserNameList();

    boolean saveUserName(String userName);
    
    void setError(String Error);

}
