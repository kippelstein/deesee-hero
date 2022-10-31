package com.company.poc.web.models.common

internal class ListResultDto<TObj>(
    val total: Number,
    val items: List<TObj>
)
