package com.example.nyt_mp.domain.usecase

import com.example.nyt_mp.domain.repository.MostPopularArticleRepo
import javax.inject.Inject

class GetMostPopularArticlesUseCase @Inject constructor(
    private val repository: MostPopularArticleRepo
) {
    suspend operator fun invoke() = repository.getMostPopularArticles()
}