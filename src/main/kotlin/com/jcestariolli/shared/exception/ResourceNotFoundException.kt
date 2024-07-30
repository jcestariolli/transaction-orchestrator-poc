package com.jcestariolli.shared.exception

class ResourceNotFoundException(
    resourceName: String,
    resourceId: String,
) : Exception("Resource $resourceName with id $resourceId not found")