package com.widdyjp.tvshows.data.model

fun getDummyTvShows(): List<TvModel> {
    val dummies = mutableListOf<TvModel>()

    dummies.add(
        TvModel(
            id = 60735,
            name = "The Flash",
            overview = "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            firstAirDate = "2014-10-07",
            backdropPath = "/jC1KqsFx8ZyqJyQa2Ohi7xgL7XC.jpg",
            posterPath = "/fki3kBlwJzFp8QohL43g9ReV455.jpg",
            voteAverage = 6.6
        )
    )
    dummies.add(
        TvModel(
            id = 62286,
            name = "Fear the Walking Dead",
            overview = "What did the world look like as it was transforming into the horrifying apocalypse depicted in \\\"The Walking Dead\\\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.",
            firstAirDate = "2015-08-23",
            backdropPath = "/nUXzdD2Jo3wV9Q7mIZjK46Yyty4.jpg",
            posterPath = "/lZMb3R3e5vqukPbeDMeyYGf2ZNG.jpg",
            voteAverage = 6.3
        )
    )
    dummies.add(
        TvModel(
            id = 1412,
            name = "Arrow",
            overview = "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            firstAirDate = "2012-10-10",
            backdropPath = "/dKxkwAJfGuznW8Hu0mhaDJtna0n.jpg",
            posterPath = "/mo0FP1GxOFZT4UDde7RFDz5APXF.jpg",
            voteAverage = 5.8
        )
    )
    dummies.add(
        TvModel(
            id = 71809,
            name = "The Dark Crystal: Age of Resistance",
            overview = "Return to the world of Thra, where three Gelfling discover the horrifying secret behind the Skeksis' power and set out to ignite the fires of rebellion and save their world.",
            firstAirDate = "2019-08-30",
            backdropPath = "/rnMx4rYjDgONuRVkKClCv1Vp6VY.jpg",
            posterPath = "/rG6bC26xi10i8Mx0ZTyJ7nBkeWv.jpg",
            voteAverage = 7.5
        )
    )
    dummies.add(
        TvModel(
            id = 1434,
            name = "Family Guy",
            overview = "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
            firstAirDate = "1999-01-31",
            backdropPath = "/3OFrs1ets87VmRvG78Zg5eJTZeq.jpg",
            posterPath = "/gBGUL1UTUNmdRQT8gA1LUV4yg39.jpg",
            voteAverage = 6.5
        )
    )

    return dummies
}