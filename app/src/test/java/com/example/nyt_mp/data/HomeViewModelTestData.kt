package com.example.nyt_mp.data

import com.example.nyt_mp.data.remote.dto.ArticleDto
import com.example.nyt_mp.data.remote.dto.MediaDto
import com.example.nyt_mp.data.remote.dto.MediaMetadataDto
import com.example.nyt_mp.data.remote.dto.MostPopularArticlesResponse
import com.example.nyt_mp.domain.model.Article
import com.example.nyt_mp.domain.model.Media

object HomeViewModelTestData {

    fun getMostPopularArticlesResponse() = MostPopularArticlesResponse(
        copyright = "Copyright (c) 2023 The New York Times Company.  All Rights Reserved.",
        numOfResults = 20,
        articles = getArticlesDto(),
        status = "OK"
    )

    fun getMostPopularArticlesResponseWithOneArticleMissingATitle() = MostPopularArticlesResponse(
        copyright = "Copyright (c) 2023 The New York Times Company.  All Rights Reserved.",
        numOfResults = 20,
        articles = getArticlesDtoWithOneArticleMissingATitle(),
        status = "OK"
    )

    private fun getArticlesDto() = listOf<ArticleDto>(
        ArticleDto(
            uri = "nyt://article/eecf39d5-7939-5cb7-b7da-02d4ecce50e6",
            url = "https://www.nytimes.com/2023/06/08/us/pat-robertson-dead.html",
            id = 100000006662350,
            assetId = 100000006662350,
            source = "New York Times",
            publishedDate = "2023-06-08",
            updated = "2023-06-09 17:03:10",
            section = "U.S.",
            subSection = "",
            nytSection = "u.s.",
            adxKeywords = "Deaths (Obituaries);Television;Christians and Christianity;Robertson, Pat;Christian Broadcasting Network",
            column = null,
            byLine = "By Douglas Martin",
            type = "Article",
            title = "Pat Robertson, Who Gave Christian Conservatives Clout, Is Dead at 93",
            abstract = "A Baptist minister and a broadcaster, he turned evangelicals into a powerful constituency that helped Republicans capture Congress in 1994. He earlier ran for president.",
            desFacet = listOf(
                "Deaths (Obituaries)",
                "Television",
                "Christians and Christianity"
            ),
            orgFacet = listOf("Christian Broadcasting Network"),
            perFacet = listOf("Robertson, Pat"),
            geoFacet = listOf(),
            media =
            listOf(
                MediaDto(
                    type = "image",
                    subtype = "photo",
                    caption = "Pat Robertson on the set of the Christian Broadcasting Network. He built an entrepreneurial empire based on his Christian faith.",
                    copyright = "Marty Katz/The LIFE Images Collection, via Shutterstock",
                    approvedForSyndication = 1,
                    mediaMetadata = listOf(
                        MediaMetadataDto(
                            url =
                            "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-thumbStandard.jpg",
                            format = "Standard Thumbnail",
                            height = 75,
                            width = 75
                        ),
                        MediaMetadataDto(
                            url =
                            "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-mediumThreeByTwo210.jpg",
                            format = "mediumThreeByTwo210",
                            height = 140,
                            width = 210
                        ),
                        MediaMetadataDto(
                            url =
                            "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-mediumThreeByTwo440.jpg",
                            format = "mediumThreeByTwo440",
                            height = 293,
                            width = 440
                        ),
                    )
                )
            ),
            etaId = 0
        ),
        ArticleDto(
            uri = "nyt://article/eecf39d5-7939-5cb7-b7da-02d4ecce50e6",
            url = "https://www.nytimes.com/2023/06/08/us/pat-robertson-dead.html",
            id = 100000006662350,
            assetId = 100000006662350,
            source = "New York Times",
            publishedDate = "2023-06-08",
            updated = "2023-06-09 17:03:10",
            section = "U.S.",
            subSection = "",
            nytSection = "u.s.",
            adxKeywords = "Deaths (Obituaries);Television;Christians and Christianity;Robertson, Pat;Christian Broadcasting Network",
            column = null,
            byLine = "By Douglas Martin",
            type = "Article",
            title = "Pat Robertson, Who Gave Christian Conservatives Clout, Is Dead at 93",
            abstract = "A Baptist minister and a broadcaster, he turned evangelicals into a powerful constituency that helped Republicans capture Congress in 1994. He earlier ran for president.",
            desFacet = listOf(
                "Deaths (Obituaries)",
                "Television",
                "Christians and Christianity"
            ),
            orgFacet = listOf("Christian Broadcasting Network"),
            perFacet = listOf("Robertson, Pat"),
            geoFacet = listOf(),
            media =
            listOf(
                MediaDto(
                    type = "image",
                    subtype = "photo",
                    caption = "Pat Robertson on the set of the Christian Broadcasting Network. He built an entrepreneurial empire based on his Christian faith.",
                    copyright = "Marty Katz/The LIFE Images Collection, via Shutterstock",
                    approvedForSyndication = 1,
                    mediaMetadata = listOf(
                        MediaMetadataDto(
                            url =
                            "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-thumbStandard.jpg",
                            format = "Standard Thumbnail",
                            height = 75,
                            width = 75
                        ),
                        MediaMetadataDto(
                            url =
                            "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-mediumThreeByTwo210.jpg",
                            format = "mediumThreeByTwo210",
                            height = 140,
                            width = 210
                        ),
                        MediaMetadataDto(
                            url =
                            "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-mediumThreeByTwo440.jpg",
                            format = "mediumThreeByTwo440",
                            height = 293,
                            width = 440
                        ),
                    )
                )
            ),
            etaId = 0
        ),
        ArticleDto(
            uri = "nyt://article/eecf39d5-7939-5cb7-b7da-02d4ecce50e6",
            url = "https://www.nytimes.com/2023/06/08/us/pat-robertson-dead.html",
            id = 100000006662350,
            assetId = 100000006662350,
            source = "New York Times",
            publishedDate = "2023-06-08",
            updated = "2023-06-09 17:03:10",
            section = "U.S.",
            subSection = "",
            nytSection = "u.s.",
            adxKeywords = "Deaths (Obituaries);Television;Christians and Christianity;Robertson, Pat;Christian Broadcasting Network",
            column = null,
            byLine = "By Douglas Martin",
            type = "Article",
            title = "Pat Robertson, Who Gave Christian Conservatives Clout, Is Dead at 93",
            abstract = "A Baptist minister and a broadcaster, he turned evangelicals into a powerful constituency that helped Republicans capture Congress in 1994. He earlier ran for president.",
            desFacet = listOf(
                "Deaths (Obituaries)",
                "Television",
                "Christians and Christianity"
            ),
            orgFacet = listOf("Christian Broadcasting Network"),
            perFacet = listOf("Robertson, Pat"),
            geoFacet = listOf(),
            media =
            listOf(
                MediaDto(
                    type = "image",
                    subtype = "photo",
                    caption = "Pat Robertson on the set of the Christian Broadcasting Network. He built an entrepreneurial empire based on his Christian faith.",
                    copyright = "Marty Katz/The LIFE Images Collection, via Shutterstock",
                    approvedForSyndication = 1,
                    mediaMetadata = listOf(
                        MediaMetadataDto(
                            url =
                            "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-thumbStandard.jpg",
                            format = "Standard Thumbnail",
                            height = 75,
                            width = 75
                        ),
                        MediaMetadataDto(
                            url =
                            "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-mediumThreeByTwo210.jpg",
                            format = "mediumThreeByTwo210",
                            height = 140,
                            width = 210
                        ),
                        MediaMetadataDto(
                            url =
                            "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-mediumThreeByTwo440.jpg",
                            format = "mediumThreeByTwo440",
                            height = 293,
                            width = 440
                        ),
                    )
                )
            ),
            etaId = 0
        )
    )

    private fun getArticlesDtoWithOneArticleMissingATitle() = listOf<ArticleDto>(
        ArticleDto(
            uri = "nyt://article/eecf39d5-7939-5cb7-b7da-02d4ecce50e6",
            url = "https://www.nytimes.com/2023/06/08/us/pat-robertson-dead.html",
            id = 100000006662350,
            assetId = 100000006662350,
            source = "New York Times",
            publishedDate = "2023-06-08",
            updated = "2023-06-09 17:03:10",
            section = "U.S.",
            subSection = "",
            nytSection = "u.s.",
            adxKeywords = "Deaths (Obituaries);Television;Christians and Christianity;Robertson, Pat;Christian Broadcasting Network",
            column = null,
            byLine = "By Douglas Martin",
            type = "Article",
            title = "Pat Robertson, Who Gave Christian Conservatives Clout, Is Dead at 93",
            abstract = "A Baptist minister and a broadcaster, he turned evangelicals into a powerful constituency that helped Republicans capture Congress in 1994. He earlier ran for president.",
            desFacet = listOf(
                "Deaths (Obituaries)",
                "Television",
                "Christians and Christianity"
            ),
            orgFacet = listOf("Christian Broadcasting Network"),
            perFacet = listOf("Robertson, Pat"),
            geoFacet = listOf(),
            media =
            listOf(
                MediaDto(
                    type = "image",
                    subtype = "photo",
                    caption = "Pat Robertson on the set of the Christian Broadcasting Network. He built an entrepreneurial empire based on his Christian faith.",
                    copyright = "Marty Katz/The LIFE Images Collection, via Shutterstock",
                    approvedForSyndication = 1,
                    mediaMetadata = listOf(
                        MediaMetadataDto(
                            url =
                            "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-thumbStandard.jpg",
                            format = "Standard Thumbnail",
                            height = 75,
                            width = 75
                        ),
                        MediaMetadataDto(
                            url =
                            "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-mediumThreeByTwo210.jpg",
                            format = "mediumThreeByTwo210",
                            height = 140,
                            width = 210
                        ),
                        MediaMetadataDto(
                            url =
                            "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-mediumThreeByTwo440.jpg",
                            format = "mediumThreeByTwo440",
                            height = 293,
                            width = 440
                        ),
                    )
                )
            ),
            etaId = 0
        ),
        ArticleDto(
            uri = "nyt://article/eecf39d5-7939-5cb7-b7da-02d4ecce50e6",
            url = "https://www.nytimes.com/2023/06/08/us/pat-robertson-dead.html",
            id = 100000006662350,
            assetId = 100000006662350,
            source = "New York Times",
            publishedDate = "2023-06-08",
            updated = "2023-06-09 17:03:10",
            section = "U.S.",
            subSection = "",
            nytSection = "u.s.",
            adxKeywords = "Deaths (Obituaries);Television;Christians and Christianity;Robertson, Pat;Christian Broadcasting Network",
            column = null,
            byLine = "By Douglas Martin",
            type = "Article",
            title = null,
            abstract = "A Baptist minister and a broadcaster, he turned evangelicals into a powerful constituency that helped Republicans capture Congress in 1994. He earlier ran for president.",
            desFacet = listOf(
                "Deaths (Obituaries)",
                "Television",
                "Christians and Christianity"
            ),
            orgFacet = listOf("Christian Broadcasting Network"),
            perFacet = listOf("Robertson, Pat"),
            geoFacet = listOf(),
            media =
            listOf(
                MediaDto(
                    type = "image",
                    subtype = "photo",
                    caption = "Pat Robertson on the set of the Christian Broadcasting Network. He built an entrepreneurial empire based on his Christian faith.",
                    copyright = "Marty Katz/The LIFE Images Collection, via Shutterstock",
                    approvedForSyndication = 1,
                    mediaMetadata = listOf(
                        MediaMetadataDto(
                            url =
                            "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-thumbStandard.jpg",
                            format = "Standard Thumbnail",
                            height = 75,
                            width = 75
                        ),
                        MediaMetadataDto(
                            url =
                            "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-mediumThreeByTwo210.jpg",
                            format = "mediumThreeByTwo210",
                            height = 140,
                            width = 210
                        ),
                        MediaMetadataDto(
                            url =
                            "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-mediumThreeByTwo440.jpg",
                            format = "mediumThreeByTwo440",
                            height = 293,
                            width = 440
                        ),
                    )
                )
            ),
            etaId = 0
        ),
        ArticleDto(
            uri = "nyt://article/eecf39d5-7939-5cb7-b7da-02d4ecce50e6",
            url = "https://www.nytimes.com/2023/06/08/us/pat-robertson-dead.html",
            id = 100000006662350,
            assetId = 100000006662350,
            source = "New York Times",
            publishedDate = "2023-06-08",
            updated = "2023-06-09 17:03:10",
            section = "U.S.",
            subSection = "",
            nytSection = "u.s.",
            adxKeywords = "Deaths (Obituaries);Television;Christians and Christianity;Robertson, Pat;Christian Broadcasting Network",
            column = null,
            byLine = "By Douglas Martin",
            type = "Article",
            title = "Pat Robertson, Who Gave Christian Conservatives Clout, Is Dead at 93",
            abstract = "A Baptist minister and a broadcaster, he turned evangelicals into a powerful constituency that helped Republicans capture Congress in 1994. He earlier ran for president.",
            desFacet = listOf(
                "Deaths (Obituaries)",
                "Television",
                "Christians and Christianity"
            ),
            orgFacet = listOf("Christian Broadcasting Network"),
            perFacet = listOf("Robertson, Pat"),
            geoFacet = listOf(),
            media =
            listOf(
                MediaDto(
                    type = "image",
                    subtype = "photo",
                    caption = "Pat Robertson on the set of the Christian Broadcasting Network. He built an entrepreneurial empire based on his Christian faith.",
                    copyright = "Marty Katz/The LIFE Images Collection, via Shutterstock",
                    approvedForSyndication = 1,
                    mediaMetadata = listOf(
                        MediaMetadataDto(
                            url =
                            "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-thumbStandard.jpg",
                            format = "Standard Thumbnail",
                            height = 75,
                            width = 75
                        ),
                        MediaMetadataDto(
                            url =
                            "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-mediumThreeByTwo210.jpg",
                            format = "mediumThreeByTwo210",
                            height = 140,
                            width = 210
                        ),
                        MediaMetadataDto(
                            url =
                            "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-mediumThreeByTwo440.jpg",
                            format = "mediumThreeByTwo440",
                            height = 293,
                            width = 440
                        ),
                    )
                )
            ),
            etaId = 0
        )
    )

    fun get3Articles() = listOf(
        Article(
            url = "https://www.nytimes.com/2023/06/08/us/pat-robertson-dead.html",
            id = 100000006662350,
            publishedDate = "2023-06-08",
            updated = "2023-06-09 17:03:10",
            section = "U.S.",
            subSection = "",
            byLine = "By Douglas Martin",
            title = "Pat Robertson, Who Gave Christian Conservatives Clout, Is Dead at 93",
            abstract = "A Baptist minister and a broadcaster, he turned evangelicals into a powerful constituency that helped Republicans capture Congress in 1994. He earlier ran for president.",
            desFacet = listOf(
                "Deaths (Obituaries)",
                "Television",
                "Christians and Christianity"
            ),
            geoFacet = listOf(),
            media = Media(
                type = "image",
                caption = "Pat Robertson on the set of the Christian Broadcasting Network. He built an entrepreneurial empire based on his Christian faith.",
                thumbnailUrl = "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-thumbStandard.jpg",
                mediumImgUrl = "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-mediumThreeByTwo210.jpg",
                largeImgUrl = "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-mediumThreeByTwo440.jpg",
            )
        ),
        Article(
            url = "https://www.nytimes.com/2023/06/08/us/pat-robertson-dead.html",
            id = 100000006662350,
            publishedDate = "2023-06-08",
            updated = "2023-06-09 17:03:10",
            section = "Art",
            subSection = "",
            byLine = "By Douglas Martin",
            title = "Pat Robertson, Who Gave Christian Conservatives Clout, Is Dead at 93",
            abstract = "A Baptist minister and a broadcaster, he turned evangelicals into a powerful constituency that helped Republicans capture Congress in 1994. He earlier ran for president.",
            desFacet = listOf(
                "Deaths (Obituaries)",
                "Television",
                "Christians and Christianity"
            ),
            geoFacet = listOf(),
            media = Media(
                type = "image",
                caption = "Pat Robertson on the set of the Christian Broadcasting Network. He built an entrepreneurial empire based on his Christian faith.",
                thumbnailUrl = "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-thumbStandard.jpg",
                mediumImgUrl = "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-mediumThreeByTwo210.jpg",
                largeImgUrl = "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-mediumThreeByTwo440.jpg",
            )
        ),
        Article(
            url = "https://www.nytimes.com/2023/06/08/us/pat-robertson-dead.html",
            id = 100000006662350,
            publishedDate = "2023-06-08",
            updated = "2023-06-09 17:03:10",
            section = "Sport",
            subSection = "",
            byLine = "By Douglas Martin",
            title = "Pat Robertson, Who Gave Christian Conservatives Clout, Is Dead at 93",
            abstract = "A Baptist minister and a broadcaster, he turned evangelicals into a powerful constituency that helped Republicans capture Congress in 1994. He earlier ran for president.",
            desFacet = listOf(
                "Deaths (Obituaries)",
                "Television",
                "Christians and Christianity"
            ),
            geoFacet = listOf(),
            media = Media(
                type = "image",
                caption = "Pat Robertson on the set of the Christian Broadcasting Network. He built an entrepreneurial empire based on his Christian faith.",
                thumbnailUrl = "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-thumbStandard.jpg",
                mediumImgUrl = "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-mediumThreeByTwo210.jpg",
                largeImgUrl = "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-mediumThreeByTwo440.jpg",
            )
        )
    )

    fun getArticlesWithoutSections() = listOf(
        Article(
            url = "https://www.nytimes.com/2023/06/08/us/pat-robertson-dead.html",
            id = 100000006662350,
            publishedDate = "2023-06-08",
            updated = "2023-06-09 17:03:10",
            section = "",
            subSection = "",
            byLine = "By Douglas Martin",
            title = "Pat Robertson, Who Gave Christian Conservatives Clout, Is Dead at 93",
            abstract = "A Baptist minister and a broadcaster, he turned evangelicals into a powerful constituency that helped Republicans capture Congress in 1994. He earlier ran for president.",
            desFacet = listOf(
                "Deaths (Obituaries)",
                "Television",
                "Christians and Christianity"
            ),
            geoFacet = listOf(),
            media = Media(
                type = "image",
                caption = "Pat Robertson on the set of the Christian Broadcasting Network. He built an entrepreneurial empire based on his Christian faith.",
                thumbnailUrl = "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-thumbStandard.jpg",
                mediumImgUrl = "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-mediumThreeByTwo210.jpg",
                largeImgUrl = "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-mediumThreeByTwo440.jpg",
            )
        ),
        Article(
            url = "https://www.nytimes.com/2023/06/08/us/pat-robertson-dead.html",
            id = 100000006662350,
            publishedDate = "2023-06-08",
            updated = "2023-06-09 17:03:10",
            section = "",
            subSection = "",
            byLine = "By Douglas Martin",
            title = "Pat Robertson, Who Gave Christian Conservatives Clout, Is Dead at 93",
            abstract = "A Baptist minister and a broadcaster, he turned evangelicals into a powerful constituency that helped Republicans capture Congress in 1994. He earlier ran for president.",
            desFacet = listOf(
                "Deaths (Obituaries)",
                "Television",
                "Christians and Christianity"
            ),
            geoFacet = listOf(),
            media = Media(
                type = "image",
                caption = "Pat Robertson on the set of the Christian Broadcasting Network. He built an entrepreneurial empire based on his Christian faith.",
                thumbnailUrl = "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-thumbStandard.jpg",
                mediumImgUrl = "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-mediumThreeByTwo210.jpg",
                largeImgUrl = "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-mediumThreeByTwo440.jpg",
            )
        ),
        Article(
            url = "https://www.nytimes.com/2023/06/08/us/pat-robertson-dead.html",
            id = 100000006662350,
            publishedDate = "2023-06-08",
            updated = "2023-06-09 17:03:10",
            section = "",
            subSection = "",
            byLine = "By Douglas Martin",
            title = "Pat Robertson, Who Gave Christian Conservatives Clout, Is Dead at 93",
            abstract = "A Baptist minister and a broadcaster, he turned evangelicals into a powerful constituency that helped Republicans capture Congress in 1994. He earlier ran for president.",
            desFacet = listOf(
                "Deaths (Obituaries)",
                "Television",
                "Christians and Christianity"
            ),
            geoFacet = listOf(),
            media = Media(
                type = "image",
                caption = "Pat Robertson on the set of the Christian Broadcasting Network. He built an entrepreneurial empire based on his Christian faith.",
                thumbnailUrl = "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-thumbStandard.jpg",
                mediumImgUrl = "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-mediumThreeByTwo210.jpg",
                largeImgUrl = "https://static01.nyt.com/images/2023/06/09/obituaries/00Robertson1-sub/00Robertson1-sub-mediumThreeByTwo440.jpg",
            )
        )
    )
}