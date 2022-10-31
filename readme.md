# DeeSee HeroService

## API Documentation

See the [api documentation](./api/readme.md) for more details

## Some words to say

I didn't wrote tests for everything, as it is just a prototype so showcase how 
i would implement such an application. Hopefully this is fine and is matching the 
requirements. 

Parts i wanna pinpoint as they might be interesting.

- oriented on [Clean Architecture](https://github.com/jasontaylordev/CleanArchitecture) by Json Taylor
- mediator pattern applied with [kediator](https://github.com/Trendyol/kediatR)
- parts of DDD applied
- swagger ui can be used for inspecting the api (fyi: i didn't wrote the spec first :P)
- global error handling and usage of [zalandos problem details](https://github.com/zalando/problem)

Based on those design decision it is easy to write unit tests for the most parts of the code,
what wasn't fully applied as mentioned above.

Have fun on checking this out, i am looking forward to hear from you guys :)
