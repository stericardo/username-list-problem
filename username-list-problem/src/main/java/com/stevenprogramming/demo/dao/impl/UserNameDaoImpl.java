package com.stevenprogramming.demo.dao.impl;

import com.stevenprogramming.demo.constants.DemoConstants;
import com.stevenprogramming.demo.dao.UserNameDao;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

/**
 *
 * @author steven.mendez
 * @since Dec 07 2017
 * @version 1.0
 */
@Repository
public class UserNameDaoImpl implements UserNameDao {

    private TreeSet<String> setDataBase;
    private TreeSet<String> keysRestricted;
    private String error;

    public UserNameDaoImpl() {
        setDataBase = new TreeSet<>();
        keysRestricted = new TreeSet<>();
    }

    /**
     * 
     * @param restrictedWord parameter to add in collection keysRestricted
     */
    @Override
    public void addRestrictedWord(String restrictedWord) {
        keysRestricted.add(restrictedWord);
    }

    /**
     * 
     * @param userName to validate
     * @param elements in the case that it have serve as a util from other collection
     * @return boolean validation
     */
    @Override
    public boolean checkIfUserNameExist(String userName, TreeSet<String> elements) {
        if (null == elements) {
            if (setDataBase.contains(userName)) {
                error = DemoConstants.ALREADY_EXIST;
                return true;
            }
            error = "";
        } else {
            if (elements.contains(userName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param userName to validate
     * @param elements in the case that it have serve as a util from other collection
     * @return boolean validation
     */
    @Override
    public boolean checkIfUserNameIsValid(String userName, TreeSet<String> elements) {
        if (null == elements) {
            TreeSet<String> stream2 = keysRestricted.stream().filter(e -> e.contains(userName) || userName.indexOf(e) >= 0)
                    .collect(Collectors.toCollection(() -> new TreeSet<>()));
            if (stream2.isEmpty()) {
                return false;
            }
            error = DemoConstants.INVALID_USER;
        } else {
            TreeSet<String> stream2 = elements.stream().filter(e -> e.contains(userName) || userName.indexOf(e) >= 0)
                    .collect(Collectors.toCollection(() -> new TreeSet<>()));
            if (stream2.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 
     * In order to keep consistent data will return a copy of data.
     * @return Set Elements
     */
    @Override
    public TreeSet<String> getRestrictedWords() {
        TreeSet<String> keysRestrictedCopy = new TreeSet<>();
        for (String element : keysRestricted) {
            keysRestrictedCopy.add(element);
        }
        return keysRestrictedCopy;
    }

    /**
     * In order to keep consistent data will return a copy of data.
     * @return Set Elements
     * 
     */
    @Override
    public TreeSet<String> getUserNameList() {
        TreeSet<String> setDataBaseCopy = new TreeSet<>();
        for (String element : setDataBase) {
            setDataBaseCopy.add(element);
        }
        return setDataBaseCopy;
    }

    /**
     * 
     * @param userName paramter to be added
     * @return boolean
     */
    @Override
    public boolean saveUserName(String userName) {
        setDataBase.add(userName);
        error = "";
        return true;
    }

    /**
     * 
     * @return Error given by validation
     */
    @Override
    public String getError() {
        return error;
    }

    @Override
    public void setError(String error) {
        this.error = error;
    }

}
