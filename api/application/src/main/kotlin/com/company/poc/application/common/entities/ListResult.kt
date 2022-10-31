package com.company.poc.application.common.entities

class ListResult<TObj> private constructor(
    val total: Int,
    val items: List<TObj>
) {
    companion object {
        fun <TObj> of(
            total: Int,
            items: List<TObj>
        ): ListResult<TObj> =
            ListResult(
                total,
                items
            )
    }
}
