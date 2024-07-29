package com.jcestariolli.shared.exception

class ResourceNotFoundException(
    private val resourceName: String,
    private val resourceId: String,
) : Exception("Resource $resourceName with id $resourceId not found")