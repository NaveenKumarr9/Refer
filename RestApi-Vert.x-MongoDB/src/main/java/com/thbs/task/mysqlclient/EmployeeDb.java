package com.thbs.task.mysqlclient;

import io.vertx.core.json.JsonObject;
import io.vertx.mysqlclient.MySQLConnectOptions;
import io.vertx.mysqlclient.MySQLPool;
import io.vertx.sqlclient.PoolOptions;
import io.vertx.sqlclient.Row;
import io.vertx.sqlclient.RowSet;
import io.vertx.sqlclient.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDb  {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDb.class);
    List<JsonObject> list = new ArrayList<>();
        MySQLConnectOptions connectOptions = new MySQLConnectOptions()
                .setPort(3306)
                .setHost("127.0.0.1")
                .setDatabase("task")
                .setUser("root")
                .setPassword("root");
        PoolOptions pool = new PoolOptions().setMaxSize(4);
       MySQLPool client =MySQLPool.pool(connectOptions, pool);

    public List<JsonObject> getAllEmployees() {
       client
               .preparedQuery("SELECT * FROM employee")
               .execute(result->{
                   if (result.succeeded()){
                       RowSet<Row> row = result.result();
                      for(Row rowSet : row){
                          list.add(rowSet.toJson());
                      }
                   }else {
                       LOGGER.error("Failed to get GET data: {}",result.cause().getMessage());
                   }
               });
        return list;
    }

    public void createEmployee(Employee employee){
        client
                .preparedQuery("INSERT INTO employee (name, dob, qualification, details ) VALUES (?, ?, ?, ?)")
                .execute(Tuple.of(employee.getName(),employee.getDob(),employee.getQualification(),employee.getDetails()),result->{
                    if (result.succeeded()){
                        RowSet<Row> rowSet = result.result();
                        LOGGER.debug("{} Rows Added in POST Successfully!!!",rowSet.rowCount());
                    }else {
                        LOGGER.error("Failed to add data in POST method {}",result.cause().getMessage());
                    }
                });
    }

    public void updateEmployee(Employee employee){
        client
                .preparedQuery("UPDATE employee SET name = ?,dob=?,qualification=?,details=? WHERE id="+employee.getId())
                .execute(Tuple.of(employee.getName(),employee.getDob(),employee.getQualification(),employee.getDetails()),result->{
                    if (result.succeeded()){
                        RowSet<Row> rowSet = result.result();
                        LOGGER.debug("{} Rows Updated in PUT Successfully!!!",rowSet.rowCount());
                    }else {
                        LOGGER.error("Failed to update data in PUT method {}",result.cause().getMessage());
                    }
                });
    }
    public void deleteEmployee(int id){
        client
                .preparedQuery("DELETE FROM employee WHERE id ="+ id)
                .execute(result->{
                    if (result.succeeded()){
                        LOGGER.info("Deleted Successfully");
                    }else {
                        LOGGER.error("Failed to delete: {}",result.cause().getMessage());
                    }
                });
    }
}
