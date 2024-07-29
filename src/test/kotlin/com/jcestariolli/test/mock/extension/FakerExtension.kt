package com.jcestariolli.test.mock.extension

import io.github.serpro69.kfaker.faker

val localizedFaker = faker { fakerConfig { locale = "pt-BR" } }
