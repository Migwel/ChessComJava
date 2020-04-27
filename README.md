This library is a Java Library that allows you to easily make calls to chess.com APIs without having to deal with complexities (making the call, parsing the response, etc.)

## Example
Instead of calling yourself the API https://api.chess.com/pub/player/username/stats, you can execute the following piece of code:

```
PlayerService playerService = ServiceFactory.getPlayerService();
Player player = playerService.getPlayer("username");
```

## Modules
This library is composed of two modules:
- api which defines the objects (such as Player above) as well as the difference services interfaces
- implementation which defines the actual implementations to the services defined in api

This way, if you want to, you can only import the api module and create the implementations yourselves or use someone else's.

## Requirements
I wanted to be fancy and use records, so you need at least Java 14

## Import to your project
Coming to maven central soon