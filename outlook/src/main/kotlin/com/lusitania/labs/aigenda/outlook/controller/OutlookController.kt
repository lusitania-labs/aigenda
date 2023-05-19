package com.lusitania.labs.aigenda.outlook.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/outlook")
@Tag(name = "Outlook Management Plugin", description = "Manages your organisation's outlook operations")
class OutlookController {

    @Operation(
        summary = "Returns a list of your todos",
        description = "Returns a list of your todos"
    )
    @GetMapping(
        value = ["/todos"],
        produces = [MediaType.TEXT_PLAIN_VALUE]
    )
    @Suppress("FunctionOnlyReturningConstant")
    fun getTodoList(): String {
        return "beep bop"
    }
}
