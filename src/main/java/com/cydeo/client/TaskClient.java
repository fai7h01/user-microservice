package com.cydeo.client;

import com.cydeo.dto.TaskResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "task-microservice", url = "localhost:8083")
public interface TaskClient {

    @GetMapping("/api/v1/task/count/employee/{assignedEmployee}")
    ResponseEntity<TaskResponse> getNonCompletedCountByAssignedEmployee(@RequestHeader(value = "authorization") String authorizationHeader,
                                                                        @PathVariable("assignedEmployee") String assignedEmployee);

}
