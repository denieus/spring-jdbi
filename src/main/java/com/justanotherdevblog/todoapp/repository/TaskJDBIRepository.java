package com.justanotherdevblog.todoapp.repository;

import com.justanotherdevblog.todoapp.model.Task;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.UUID;

@RegisterBeanMapper(Task.class)
public interface TaskJDBIRepository {

    @GetGeneratedKeys
    @SqlUpdate("insert into task (description) values (:description)")
    Task insertTask(@Bind("description") String description);

    @SqlQuery("select * from task where id = :id")
    Task findById(@Bind("id") UUID taskId);

}
