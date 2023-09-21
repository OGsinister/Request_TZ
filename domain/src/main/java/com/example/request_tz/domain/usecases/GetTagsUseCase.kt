package com.example.request_tz.domain.usecases

import com.example.request_tz.domain.model.Tags
import com.example.request_tz.domain.repository.ApiRepository
import javax.inject.Inject

class GetTagsUseCase @Inject constructor(
    private val repository: ApiRepository
){
    operator fun invoke(): List<Tags> {
        return repository.getTags()
    }
}