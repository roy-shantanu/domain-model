package test.com.company.service.test;

import com.company.domain.User;
import com.company.service.UserService;
import com.company.service.impl.UserServiceImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

/**
 * User: Shantanu Roy
 * Date: 07-Nov-17
 * Time: 9:49 PM
 */
public class UserServiceImplTest {

    Long userIdToUpdate;
    Long userIdToDelete;

    @Test(priority = 1)
    public void testUserSignup() throws Exception {
        File file = new File("C:\\Users\\Shantanu Roy\\Desktop\\Test\\User\\users.ser");
        file.delete();
        UserService userService = new UserServiceImpl();

        Long firstUserId = userService.userSignup("User One", "user.one", "user.one@ideascale.com");
        Assert.assertEquals("User One", userService.getUserInfo(firstUserId).getFullName());
        Assert.assertEquals("user.one", userService.getUserInfo(firstUserId).getUserName());
        Assert.assertEquals("user.one@ideascale.com", userService.getUserInfo(firstUserId).getEmail());

        Long secondUserId = userService.userSignup("Shantanu Roy", "another.username", "shantanu.roy@ideascale.com");
        Assert.assertEquals("Shantanu Roy", userService.getUserInfo(secondUserId).getFullName());
        Assert.assertEquals("another.username", userService.getUserInfo(secondUserId).getUserName());
        Assert.assertEquals("shantanu.roy@ideascale.com", userService.getUserInfo(secondUserId).getEmail());

        this.userIdToUpdate = firstUserId;
        this.userIdToDelete = secondUserId;
    }

    @Test(priority = 2)
    public void testUserUpdate() throws Exception {
        UserService userService = new UserServiceImpl();
        userService.userUpdate(userIdToUpdate, "New FullName", "new.fullName", "new.full.name@ideascale.com");
        Assert.assertEquals("New FullName", userService.getUserInfo(userIdToUpdate).getFullName());
        Assert.assertEquals("new.fullName", userService.getUserInfo(userIdToUpdate).getUserName());
        Assert.assertEquals("new.full.name@ideascale.com", userService.getUserInfo(userIdToUpdate).getEmail());
    }

    @Test(priority = 3)
    public void testUserDelete() throws Exception {
        UserService userService = new UserServiceImpl();
        User userBefore = userService.getUserInfo(userIdToDelete);
        Assert.assertEquals("Shantanu Roy", userBefore.getFullName());
        userService.userDelete(userIdToDelete);
        User userAfter = userService.getUserInfo(userIdToDelete);
        Assert.assertNull(userAfter);
    }

}