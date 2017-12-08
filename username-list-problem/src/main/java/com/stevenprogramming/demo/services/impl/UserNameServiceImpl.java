package com.stevenprogramming.demo.services.impl;

import com.stevenprogramming.demo.constants.DemoConstants;
import com.stevenprogramming.demo.dao.UserNameDao;
import com.stevenprogramming.demo.services.UserNameService;
import com.stevenprogramming.demo.util.DemoUtil;
import static com.stevenprogramming.demo.util.DemoUtil.appendValue;
import java.util.Set;
import java.util.TreeSet;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author steven.mendez
 * @since Dec 07 2017
 * @version 1.0
 */
@Service
public class UserNameServiceImpl implements UserNameService {

    private static final Logger LOGGER = Logger.getLogger(UserNameServiceImpl.class.getName());

    private UserNameDao userNameDao;

    @Autowired
    public UserNameServiceImpl(UserNameDao userNameDao) {
        this.userNameDao = userNameDao;
    }

    /**
     *
     * @param restrictedWord Add new word to restricted list
     */
    @Override
    public void addRestrictedWord(String restrictedWord) {
        userNameDao.addRestrictedWord(restrictedWord);
    }

    /**
     *
     * @param word this is necessary because if you have word restricted you
     * need to change something within the word
     * @return
     */
    private String changeWord(String word) {
        int max = word.length() - 1;
        char[] charArray = word.toCharArray();
        char[] charArrayResult = new char[charArray.length + 1];
        int position = (int) (Math.random() * max) + 1;
        int cont = 0;
        for (char c : charArray) {
            if (position == cont) {
                charArrayResult[cont] = DemoConstants.UNDERSCORE_CHAR;
                charArrayResult[cont + 1] = c;
                cont += 2;
            } else {
                charArrayResult[cont] = c;
                ++cont;
            }

        }
        return new String(charArrayResult);
    }

    /**
     * 
     * @param userName Value to test
     * @param elements Collection to review
     * @return 
     */
    private boolean checkIfUserNameExist(String userName, TreeSet<String> elements) {
        return userNameDao.checkIfUserNameExist(userName, elements);
    }

    /**
     * 
     * @param userName value to check
     * @param elements Collection to review
     * @return 
     */
    private boolean checkIfUserNameIsValid(String userName, TreeSet<String> elements) {
        return userNameDao.checkIfUserNameIsValid(userName, elements);
    }

    /**
     *
     * @param restrictedValues Initialization of words at beginning of the
     * system
     */
    @Override
    public void fillRestrictedWord(Set<String> restrictedValues) {
        for (String restrictedValue : restrictedValues) {
            userNameDao.addRestrictedWord(restrictedValue);
        }
    }

    /**
     *
     * @param base Based in business rules here this method will try to generate
     * 3 times 14 suggestions
     * @return
     */
    private String generateString(String base) {
        String error = getError();
        int max = 5;
        if (error.equals(DemoConstants.INVALID_USER) || error.equals(DemoConstants.INVALID_LENGTH)) {
            // Only for Invalid Length or Invalid User since invalid lenght string could be carry restrict word
            base = changeWord(base);
        }
        StringBuilder value = new StringBuilder();
        max = 5;
        int times = 1;
        int number = (int) (Math.random() * max) + 1;
        times = (int) (Math.random() * max) + 1;
        switch (number) {
            case 1:
                //duplicate String
                DemoUtil.appendValue(times, value, base, false);
                break;
            case 2:
                //Secuency Username ramdom e.g: John1,John2,John3
                value.append(base);
                DemoUtil.appendValue(times, value, "", true);
                break;
            case 3:
                //Secuency Username ramdom e.g: John_1,John_2,John_3
                value.append(base);
                DemoUtil.appendValue(times, value, DemoConstants.UNDERSCORE, true);
                break;
            case 4:
                //Secuency Username ramdom e.g: John-1,John-2,John-3
                value.append(base);
                DemoUtil.appendValue(times, value, DemoConstants.DASH, true);
                break;
            case 5:
                //Generate ramdom at the final e.g: John999
                value.append(base);
                value.append(String.valueOf((int) (Math.random() * 1000) + 100));
                break;
            default:
                value.append(base.concat(base));
                break;
        }
        return value.toString();
    }

    /**
     *
     * @param base this String will be taken as base for generate suggestion
     * values
     * @return
     */
    @Override
    public TreeSet<String> generateSuggestionValues(String base) {
        TreeSet<String> valuesGenerated = new TreeSet<>();
        int cont = 0;
        int intent = 0;
        while (cont < 14 && intent < 3) {
            for (int i = cont; i < 14; i++) {
                String userNameSuggestion = generateString(base);
                if (!checkIfUserNameExist(userNameSuggestion, null)) {
                    if (!checkIfUserNameIsValid(userNameSuggestion, null)) {
                        valuesGenerated.add(userNameSuggestion);
                        ++cont;
                    }
                }
            }
            ++intent;
        }
        return valuesGenerated;
    }

    /**
     *
     * @param userName this parameter will be the new username value in list
     * This method comply with several validations
     * @return
     */
    @Override
    public boolean saveUserName(String userName) {
        if (userName.length() < 6) {
            userNameDao.setError(DemoConstants.INVALID_LENGTH);
            return false;
        }
        if (!checkIfUserNameExist(userName, null)) {
            if (!checkIfUserNameIsValid(userName, null)) {
                return userNameDao.saveUserName(userName);
            }
        }
        return false;
    }

    @Override
    public String getError() {
        return userNameDao.getError();
    }

    @Override
    public Set<String> getRestrictedWords() {
        return userNameDao.getRestrictedWords();
    }

    @Override
    public Set<String> getUserNameList() {
        return userNameDao.getUserNameList();
    }

}
