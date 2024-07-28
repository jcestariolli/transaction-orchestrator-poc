package com.jcestariolli.testApp.persistence.jpa

import com.jcestariolli.testApp.persistence.jpa.dao.TestDao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TestRepositoryJpa : JpaRepository<TestDao?, String?>