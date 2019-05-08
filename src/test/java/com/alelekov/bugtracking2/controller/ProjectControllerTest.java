package com.alelekov.bugtracking2.controller;

import com.alelekov.bugtracking2.ProjectTestData;
import org.junit.Test;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

public class ProjectControllerTest {

    private static ProjectRestController controller = new ProjectRestController();

    @Test
    public void delete() throws Exception {
        controller.delete(ProjectTestData.PROJECT_ID);
        Collection projects = controller.list();
        assertEquals(projects.size(), 2);
        assertEquals(projects.iterator().next().toString(), ProjectTestData.RESULT_AFTER_DELETE);
    }
}