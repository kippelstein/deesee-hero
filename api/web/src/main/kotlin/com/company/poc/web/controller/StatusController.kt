package com.company.poc.web.controller

import com.company.poc.web.models.common.StatusDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/.infrastructure/status")
internal class StatusController {
    @GetMapping
    fun getStatus(): ResponseEntity<StatusDto> {
        return ResponseEntity.ok(StatusDto(true))
    }
}
