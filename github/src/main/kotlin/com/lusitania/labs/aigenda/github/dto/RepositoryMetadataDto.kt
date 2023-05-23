package com.lusitania.labs.aigenda.github.dto

import java.util.*

class RepositoryMetadataDto(
        val latestCommit: Date,
        val archived: Boolean,
        val language: String?,
        val defaultBranch: String,
        val description: String?,
        val visibility: String?,
        val license: String?,
)