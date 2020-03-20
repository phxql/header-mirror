# Header mirror

A small micronaut application which returns all request headers as plain text to the caller.

## Why?

Useful for debugging stuff like the Keycloak Gatekeeper.

## Running

1. `./gradlew run`
1. Open http://localhost:12345/

## Building

1. `./gradlew build`
1. See `build/distributions/` folder

## FAQ

### How can I change the port?

Set the `MICRONAUT_SERVER_PORT` variable to the port you want to run it on. e.g. `MICRONAUT_SERVER_PORT=8080 bin/header-mirror` runs the server on port 8080.

## License

[CC0](https://creativecommons.org/publicdomain/zero/1.0/deed.en)
