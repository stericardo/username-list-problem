package com.stevenprogramming.demo;

import com.stevenprogramming.demo.config.SpringConfiguration;
import com.stevenprogramming.demo.services.UserNameService;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author steven.mendez
 * @since Dec 08 2017
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class UserNameServiceTest {

    private static final Logger LOGGER = Logger.getLogger(UserNameServiceTest.class.getName());
    
    @Autowired
    UserNameService userNameService;

    @Before
    public void executedBeforeEach() {
        Set<String> defaultKeysRestricted = new HashSet<>();
        defaultKeysRestricted.add("Cannabis");
        defaultKeysRestricted.add("Abuse");
        defaultKeysRestricted.add("Crack");
        defaultKeysRestricted.add("Damn");
        defaultKeysRestricted.add("Drunk");
        defaultKeysRestricted.add("Drass");
        userNameService.fillRestrictedWord(defaultKeysRestricted);
    }

    @Test
    public void testNotNullUserNameService() {
        Assert.assertNotNull(userNameService);
    }

    @Test
    public void testSaveUserName() {
        Assert.assertTrue("User Name added", userNameService.saveUserName("Steven"));
    }

    @Test
    public void testDuplicateSaveUserName() {
        userNameService.saveUserName("Steven");
        Assert.assertFalse("User Name added", userNameService.saveUserName("Steven"));
    }
    
    @Test
    public void testRestrictedSaveUserName() {
        Assert.assertFalse("User Name Not added", userNameService.saveUserName("Cannabis"));
        Assert.assertFalse("User Name Not added", userNameService.saveUserName("Cannabiss"));
        Assert.assertFalse("User Name Not added", userNameService.saveUserName("CCannabis"));
        Assert.assertFalse("User Name Not added", userNameService.saveUserName("CCannabiss"));
    }
    
    @Test
    public void testSuggestionInvalidWord() {
        Assert.assertFalse("User Name Not added", userNameService.saveUserName("Cannabis"));
        Set<String> suggestions = userNameService.generateSuggestionValues("Cannabis");
        for (String suggestion : suggestions) {
            LOGGER.info(suggestion);
        }
    }
    
    @Test
    public void testSuggestionInvalidLength() {
        Assert.assertFalse("User Name Not added", userNameService.saveUserName("John"));
        Set<String> suggestions = userNameService.generateSuggestionValues("John");
        for (String suggestion : suggestions) {
            LOGGER.info(suggestion);
        }
    }

}
