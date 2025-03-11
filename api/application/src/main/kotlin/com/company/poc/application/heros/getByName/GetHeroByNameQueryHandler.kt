package com.company.poc.application.heros.getByName

import com.company.poc.application.common.interfaces.HeroRepository
import com.company.poc.application.heros.getBySuperpower.GetHeroByNameQuery
import com.company.poc.domain.entities.Hero
import com.trendyol.kediatr.QueryHandler
import org.springframework.stereotype.Component

@Component
internal class GetHeroByNameQueryHandler(
    private val repo: HeroRepository
) : QueryHandler<GetHeroByNameQuery, Hero> {
    override fun handle(query: GetHeroByNameQuery): Hero {
        return this.repo.findByName(query.name)
    }
}
