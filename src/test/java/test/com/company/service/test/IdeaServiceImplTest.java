package test.com.company.service.test;

import com.company.domain.Idea;
import com.company.service.IdeaService;
import com.company.service.UserService;
import com.company.service.impl.IdeaServiceImpl;
import com.company.service.impl.UserServiceImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * User: Shantanu Roy
 * Date: 08-Nov-17
 * Time: 10:42 PM
 */
public class IdeaServiceImplTest {

    Long ideaIdToUpdate;

    @Test(priority = 1)
    public void testPostIdea() throws Exception {

        UserService userService = new UserServiceImpl();
        IdeaService ideaService = new IdeaServiceImpl();

        Long userId = userService.userSignup("Idea Poster", "idea.poster", "idea.poster@ideascale.com");

        Long ideaId = ideaService.postIdea(userService.getUserInfo(userId), "This is an Idea Title", "This is An Idea Description");

        Idea idea = ideaService.getIdeaInfo(ideaId);
        Assert.assertEquals("Idea Poster", idea.getUser().getFullName());
        Assert.assertEquals("idea.poster", idea.getUser().getUserName());
        Assert.assertEquals("idea.poster@ideascale.com", idea.getUser().getEmail());

        Assert.assertEquals("This is an Idea Title", idea.getIdeaTitle());
        Assert.assertEquals("This is An Idea Description", idea.getIdeaDescription());

        this.ideaIdToUpdate = ideaId;
    }

    @Test(priority = 2)
    public void testUpdateIdea() throws Exception {

        IdeaService ideaService = new IdeaServiceImpl();
        ideaService.updateIdea(ideaIdToUpdate, "This is updated title", "This is updated description");

        Idea idea = ideaService.getIdeaInfo(ideaIdToUpdate);

        Assert.assertEquals("Idea Poster", idea.getUser().getFullName());
        Assert.assertEquals("idea.poster", idea.getUser().getUserName());
        Assert.assertEquals("idea.poster@ideascale.com", idea.getUser().getEmail());

        Assert.assertEquals("This is updated title", idea.getIdeaTitle());
        Assert.assertEquals("This is updated description", idea.getIdeaDescription());
    }

    @Test(priority = 3)
    public void testDeleteIdea() throws Exception {
        IdeaService ideaService = new IdeaServiceImpl();
        Idea ideaBefore = ideaService.getIdeaInfo(ideaIdToUpdate);
        Assert.assertEquals("This is updated title", ideaBefore.getIdeaTitle());
        ideaService.deleteIdea(ideaIdToUpdate);
        Idea ideaAfter = ideaService.getIdeaInfo(ideaIdToUpdate);
        Assert.assertNull(ideaAfter);
    }

}