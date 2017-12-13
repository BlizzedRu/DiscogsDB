# DiscogsDB
Simple Java library for [Discogs's Database][doc] API

**DiscogsDB** provides easy access to all available methods of Discogs's Database API. 
Can be useful for grabbing data of artists, releases, labels, etc.

* Contains Java object wrappers for any API response
* Supports paginated result response (search or lists with many objects)
* Convenient request builders

Full list of methods available in [Discogs's Database Documentation][doc]

## Installing

#### Maven

In your pom.xml inside the *\<dependencies>* tag
```xml
<dependencies>
    ...
    <dependency>
        <groupId>ru.blizzed</groupId>
        <artifactId>discogsdb</artifactId>
        <version>1.0.2</version>
    </dependency>
</dependencies>
```

#### Gradle

In your build.gradle file inside the *dependencies* section

* Gradle 3.0 and above
``` 
dependencies {
   ...
   implementation 'ru.blizzed:discogsdb:1.0.2'
}
```
  
* Below 3.0
``` 
dependencies {
    ...
    compile 'ru.blizzed:discogsdb:1.0.2'
}
```
  
## Usage

#### Initialization

* You're not going to use `search` method

```java 
DiscogsDBApi.initialize();
```

* You are planned to use `search` method

```java 
DiscogsDBApi.initialize(new DiscogsAuthData("your-consumer-key", "your-consumer-secret"));
```

#### Building and executing requests

All methods of Discogs's Database API are available in `DiscogsDBApi` class after initialization.
You can pass any params to the call – just take a look at static class `DiscogsDBParams` that 
contains completed instances of all parameters.

Imagine that you need to check if user's input artist name is correct. Then you need to 
learn an artist's ID first. 

```java 
String userInput = "KoЯn";
```

```java 
Page<BaseSearchResult> page = DiscogsDBApi.searchArtist(
        DiscogsDBParams.QUERY.of(userInput)
).execute();
```

or the same but with a set of params

```java 
Page<BaseSearchResult> page = DiscogsDBApi.searchArtist(
        DiscogsDBParams.QUERY.of(userInput),
        DiscogsDBParams.COUNTRY.of("Russia")
).execute();
```

```java 
long kornId = page.getContent().get(0).getId();     // Congrats!
```


#### Callbacks
That's nice! Now you have Korn's ID in Discogs so you can get all their name variations. 
You can receive callbacks in two ways:

* Catching exceptions
```java 
try {
    DiscogsDBApi.getArtist(kornId).execute().getNameVariations().forEach(System.out::println);
} catch (DiscogsDBCallException | DiscogsDBErrorException e) {
    // Handle error
} 
```
* With listener
```java 
DiscogsDBApi.getArtist(kornId).execute(new DiscogsDBCaller.Listener<Artist>() {
    @Override
    public void onComplete(Artist result, DiscogsDBCaller<Artist> caller) {
        result.getNameVariations().forEach(System.out::println);
    }
    @Override
    public void onError(Error error, DiscogsDBCaller<Artist> caller) {
        /* This method triggers you when API has been called but response contains an error */
        // Handle Api Error
    }
    @Override
    public void onFailure(DiscogsDBCallException e, DiscogsDBCaller<Artist> caller) {
        /* This method triggers you when call to API cannot be established. E.g. no internet connection */
        // Handle Failure
    }
});
```
**Tip:** you can override not all callback methods

#### Requests cancelling
It goes without saying that you can also cancel request immediately if needs
```java 
caller.cancel();
```

## License

```
Copyright (c) 2017 BlizzedRu (Ivan Vlasov)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

[doc]: http://www.discogs.com/developers/#page:database