package com.lusitania.labs.aigenda.github.controller

import com.lusitania.labs.aigenda.github.dto.RepositoryMetadataDto
import com.lusitania.labs.aigenda.github.service.GitHubRepositoriesService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/github")
@Tag(
    name = "GitHub Repository Management Plugin",
    description = "Manages your organisation's github repositories operations"
)
class GitHubRepositoryController(
    private val gitHubRepositoriesService: GitHubRepositoriesService
) {

    private val logger = LoggerFactory.getLogger(GitHubRepositoryController::class.java)

    @GetMapping(
        value = ["/total-repos"],
        produces = [MediaType.TEXT_PLAIN_VALUE]
    )
    @Operation(
        summary = "Total number of repositories",
        description = "Returns the total number of repositories available on your organisation " +
            "and the total number of archived repositories"
    )
    fun getTotalRepos(): String {
        logger.info("Request for total number of repositories")
        return gitHubRepositoriesService.getTotalRepos()
    }

    @GetMapping(
            value = ["/repository-metadata"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @Operation(
            summary = "Returns a list of repositories names with matching metadata",
            description = "Returns a key value pair, where the key represents the repository name, " +
                    "and the value is an object with the latestCommit, archived status, " +
                    "language, defaultBranch, description, visibility and license"
    )
    fun getLatestCommitList(): Map<String, RepositoryMetadataDto> {
        logger.info("Request for list of repositories metadata")
        return gitHubRepositoriesService.getReposMetadata()
    }
}
