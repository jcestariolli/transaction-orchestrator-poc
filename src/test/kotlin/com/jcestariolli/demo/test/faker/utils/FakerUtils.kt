package com.jcestariolli.demo.test.faker.utils

import io.github.serpro69.kfaker.faker

val localizedFaker = faker { fakerConfig { locale = "pt-BR" } }
