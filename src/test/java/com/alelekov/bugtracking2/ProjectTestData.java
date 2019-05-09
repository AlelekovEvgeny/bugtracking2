package com.alelekov.bugtracking2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectTestData {
    public static final String PROJECT_ID = "1";
    public static final String RESULT_AFTER_DELETE = "{name=Second project, id=2}";

    private int counter = 4;

    private List<Map<String, String>> projects = new ArrayList<Map<String, String>>() {{
        add(new HashMap<String, String>() {{ put("id", "1"); put("name", "First project"); }});
        add(new HashMap<String, String>() {{ put("id", "2"); put("name", "Second project"); }});
        add(new HashMap<String, String>() {{ put("id", "3"); put("name", "Third project"); }});
    }};
}
