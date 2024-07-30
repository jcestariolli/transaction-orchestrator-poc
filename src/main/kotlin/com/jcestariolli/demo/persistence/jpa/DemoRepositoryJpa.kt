package com.jcestariolli.demo.persistence.jpa

import com.jcestariolli.demo.persistence.jpa.dao.DemoDao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DemoRepositoryJpa : JpaRepository<DemoDao?, String?>