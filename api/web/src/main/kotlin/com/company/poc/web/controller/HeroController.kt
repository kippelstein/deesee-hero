package com.company.poc.web.controller


import com.company.poc.application.heros.add.AddHeroCommand
import com.company.poc.application.heros.getBySuperpower.GetHeroByNameQuery
import com.company.poc.application.heros.getBySuperpower.GetHeroBySuperpowerQuery
import com.company.poc.domain.entities.SuperPower
import com.company.poc.web.models.HeroDto
import com.company.poc.web.models.common.ListResultDto
import com.company.poc.web.models.toDto
import com.trendyol.kediatr.CommandBus
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/heros")
internal class HeroController(
    private val bus: CommandBus,
) {
    @Operation(summary = "Get all heros")
    @GetMapping()
    fun getAll(
        @RequestParam superpowers: List<SuperPower>?,
        @RequestParam encryptionKey: Int?
    ): ResponseEntity<ListResultDto<HeroDto>> {
        val result = this.bus.executeQuery(GetHeroBySuperpowerQuery(superpowers, encryptionKey))
        return ResponseEntity.ok(result.toDto())
    }

    @Operation(summary = "Get one hero by name")
    @GetMapping("{name}")
    fun getByName(
        @PathVariable name: String,
    ): ResponseEntity<HeroDto> {
        val result = this.bus.executeQuery(GetHeroByNameQuery(name))
        return ResponseEntity.ok(result.toDto())
    }

    @Operation(summary = "Add a new hero")
    @PostMapping()
    fun add(
        @RequestBody addHero: AddHeroCommand
    ): ResponseEntity<HeroDto> {
        val res = this.bus.executeCommand(
            addHero
        )
        return ResponseEntity.ok(res.toDto())
    }
}
