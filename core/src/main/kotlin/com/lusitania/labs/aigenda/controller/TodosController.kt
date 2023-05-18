package com.lusitania.labs.aigenda.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(
        name = "AIgenda day to day management Plugin",
        description = "Plugin that helps you manage your day to day activities"
)
class TodosController {

    @Operation(
            summary = "Returns a list of your todos",
            description = "Returns a list of your todos"
    )
    @GetMapping(
            value = ["/todos"],
            produces = [MediaType.TEXT_PLAIN_VALUE]
    )
    fun getTodoList(): String {
        return "beep bop"
    }
}