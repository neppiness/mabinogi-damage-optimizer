package com.ether.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/damage")
class DamageController {

    @GetMapping
    fun getDamage(): Map<String, Any> {
        return mapOf(
            "minDamage" to 100,
            "maxDamage" to 200,
            "critical" to true
        )
    }

}
