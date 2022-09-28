package com.thbs.tasks;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.MessageCodec;
import io.vertx.core.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class EmpVerticle extends AbstractVerticle implements MessageCodec<Employee,Project> {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmpVerticle.class);
    public static final String ADDRESS = "Employee-Data";
    Employee employee = new Employee(1,"Naveen","Developer",909);

    Map<Integer,Employee> employeeMap = new HashMap<>();

    @Override
    public void start() throws Exception {
        DeploymentOptions options = new DeploymentOptions().setHa(true);
        vertx.deployVerticle(new ProjectVerticle(), options,result->{
            if (result.failed()){
                LOGGER.error("Failed",result.cause());
            }
        });
        employeeMap.put(employee.getEmployeeId(),employee);

        EventBus eventBus = vertx.eventBus();
        eventBus.registerDefaultCodec(Employee.class,new EmpVerticle());
        //LOGGER.debug("Employee data is:-> {}",employee);
        eventBus.send(ADDRESS,employee.getProjectId());
    }


    @Override
    public void encodeToWire(Buffer buffer, Employee employee) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.put("id", employee.getEmployeeId());
        jsonObject.put("name", employee.getName());
        jsonObject.put("role", employee.getRole());
        jsonObject.put("ProjectId",employee.getProjectId());

        String str = jsonObject.encode();
        int length=str.getBytes().length;

        buffer.appendInt(length);
        buffer.appendString(str);
    }

    @Override
    public Project decodeFromWire(int pos, Buffer buffer) {
            int length = buffer.getInt(pos);
            String str = buffer.getString(pos + 4, pos + 4 + length);
            JsonObject jsonObject = new JsonObject(str);
            int projectId = jsonObject.getInteger("ProjectId");
            String projectDetails= jsonObject.getString("projectDetails");
        return new Project(projectId, projectDetails);
    }

    @Override
    public Project transform(Employee employee) {
        return  new Project();
    }

    @Override
    public String name() {
        return this.getClass().getSimpleName();
    }

    @Override
    public byte systemCodecID() {
        return -1;
    }
}