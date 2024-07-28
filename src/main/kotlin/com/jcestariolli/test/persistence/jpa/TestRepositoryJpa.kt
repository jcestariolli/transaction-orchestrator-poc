package com.jcestariolli.test.persistence.jpa

import com.jcestariolli.test.persistence.jpa.dao.TestDao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TestRepositoryJpa : JpaRepository<TestDao?, String?>