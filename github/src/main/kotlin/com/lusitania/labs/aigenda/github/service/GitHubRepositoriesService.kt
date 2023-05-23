package com.lusitania.labs.aigenda.github.service

import com.lusitania.labs.aigenda.github.dto.RepositoryMetadataDto
import org.kohsuke.github.GitHub
import org.kohsuke.github.GitHubBuilder
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class GitHubRepositoriesService(
        @Value("\${aigenda.github.orgName}")
        val orgName: String,
        @Value("\${aigenda.github.access.token}")
        val pat: String,
) {

    private val logger = LoggerFactory.getLogger(GitHubRepositoriesService::class.java)

    fun getTotalRepos(): String {
        val client = buildGitHubClient()
        val org = client.getOrganization(orgName)
        val archivedNumber = org.repositories.filter { repo -> repo.value.isArchived }.size

        return "The organisation $orgName has ${org.repositories.size} repositories and $archivedNumber are archived"
    }

    fun getReposMetadata(): Map<String, RepositoryMetadataDto> {
        val client = buildGitHubClient()
        val org = client.getOrganization(orgName)
        val response = mutableMapOf<String, RepositoryMetadataDto>()

        org.repositories.forEach { repo ->
            response[repo.key] = RepositoryMetadataDto(
                    language = repo.value.language,
                    archived = repo.value.isArchived,
                    latestCommit = repo.value.listCommits().first().commitDate,
                    defaultBranch = repo.value.defaultBranch,
                    description = repo.value.description,
                    visibility = repo.value.visibility.name,
                    license = repo.value.license.name
            )
        }

        return response
    }

    private fun buildGitHubClient(): GitHub {
        return GitHubBuilder().withOAuthToken(pat).build()
    }
}
