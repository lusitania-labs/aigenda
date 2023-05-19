package com.lusitania.labs.aigenda.core.controller

import com.lusitania.labs.aigenda.core.dto.GreetingRequestDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
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
    @PostMapping(
        value = ["/todos"],
        produces = [MediaType.TEXT_PLAIN_VALUE]
    )
    fun getTodoList(@RequestBody request: GreetingRequestDto?): String {
        return "beep bop ${request?.greeting}."
    }
}
