package com.thbs.tasks;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.MessageConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;
import static com.thbs.tasks.EmpVerticle.ADDRESS;

public class ProjectVerticle extends AbstractVerticle {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectVerticle.class);
    Map<Integer,Project> projectMap = new HashMap<>();
    Project project = new Project(909,"Coupler");
    @Override
    public void start() throws Exception {
        projectMap.put(project.getProjectid(), project);
        EventBus eventBus = vertx.eventBus();
        MessageConsumer<Integer> employeeMessageConsumer = eventBus.consumer(ADDRESS,  message->{
            LOGGER.debug("Project details is:-> {}",projectMap.get(message.body()));
        });
    }
}

