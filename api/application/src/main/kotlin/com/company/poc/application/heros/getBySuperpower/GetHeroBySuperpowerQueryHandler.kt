package com.company.poc.application.heros.getBySuperpower

import com.company.poc.application.common.StringEncryption.Companion.encrypt
import com.company.poc.application.common.entities.ListResult
import com.company.poc.application.common.interfaces.HeroRepository
import com.company.poc.domain.entities.Hero
import com.trendyol.kediatr.QueryHandler
import org.springframework.stereotype.Component
@Component
internal class GetHeroBySuperpowerQueryHandler(
    private val repo: HeroRepository
) : QueryHandler<GetHeroBySuperpowerQuery, ListResult<Hero>> {
    override fun handle(query: GetHeroBySuperpowerQuery): ListResult<Hero> {
        val result =  if (query.superpowers == null) {
            this.repo.findAll()
        } else {
            this.repo.findAll(query.superpowers)
        }

        return if (query.encryptionKey != null) {
            encryptIdentities(result, query.encryptionKey)
        } else {
            result
        }
    }

    private fun encryptIdentities(heros: ListResult<Hero>, key: Int): ListResult<Hero> {
        val encrypted = heros.items.map {
            Hero.create(it.name,
                it.identity.firstName.encrypt(key),
                it.identity.lastName.encrypt(key),
                it.birthday,
                it.superpowers
            )
        }
        return ListResult.of(heros.total, encrypted)
    }
}
