# PunkApiDemo
Android app that shows data from [PunkAPI](https://punkapi.com/documentation/v2) and allows the user to mark the beers as available or unavailable.

It shows a list of beers, received from the PunkAPI and marks with a gray background any beer that is unavailable at the moment.
It also allows to see the details of any beer, and mark/unmark it as available.

## Purpose
The purpose of this repo is to implement a simple project using best practices and taking advantage of Android Jetpack tools.

Some of the architectures/patterns/tools used in this project are:
*   [MVVM Architecture Pattern](https://developer.android.com/jetpack/guide)
*   [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
*   [SOLID Principles](https://en.wikipedia.org/wiki/SOLID)
*   [Repository Pattern](https://martinfowler.com/eaaCatalog/repository.html)
*   Dependency Injection with [Koin](https://insert-koin.io/)
*   Data persistance with [Room](https://developer.android.com/training/data-storage/room)
*   Network calls with [Retrofit2](https://square.github.io/retrofit/)
*   Image loading with [Glide](https://github.com/bumptech/glide)
*   [Jetpack Paging](https://developer.android.com/topic/libraries/architecture/paging) with DB as Single Source of Truth and Network API to feed the DB
*   [Jetpack Navigation](https://developer.android.com/guide/navigation)
*   [Jetpack Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle)
*   [Jetpack Data Binding](https://developer.android.com/topic/libraries/data-binding)

## Testing
*   [Room DAO testing](https://developer.android.com/training/data-storage/room/testing-db)
*   Unit Testing with [JUnit](https://developer.android.com/training/testing/unit-testing/local-unit-tests)

## License

            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
                    Version 2, December 2004

          Copyright (C) 2004 Sam Hocevar <sam@hocevar.net>

    Everyone is permitted to copy and distribute verbatim or modified
    copies of this license document, and changing it is allowed as long
    as the name is changed.

            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
    TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION

    0. You just DO WHAT THE FUCK YOU WANT TO.
  
    This program is free software. It comes without any warranty, to
    the extent permitted by applicable law. You can redistribute it
    and/or modify it under the terms of the Do What The Fuck You Want
    To Public License, Version 2, as published by Sam Hocevar. See
    http://www.wtfpl.net/ for more details.

