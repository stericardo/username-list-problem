package com.stevenprogramming.demo.services;

import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author steven.mendez
 * @since Dec 07 2017
 * @version 1.0
 */
public interface UserNameService {

    void addRestrictedWord(String restrictedWord);

    void fillRestrictedWord(Set<String> restrictedValues);
    
    TreeSet<String> generateSuggestionValues(String base);
    
    String getError();
    
    Set<String> getRestrictedWords();
    
    Set<String> getUserNameList();

    boolean saveUserName(String userName);

}
