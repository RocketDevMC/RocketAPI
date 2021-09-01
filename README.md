
# Rocket API
[![MIT License](https://img.shields.io/badge/license-MIT-blue.svg)](https://opensource.org/licenses/MIT)

A minecraft plugin API to speed through development and remove boilerplate code.

## Installation

RocketAPI uses maven to handle all of its dependencies. You can install it using the following commands:

```xml
	<repository>
	    <id>jitpack.io</id>
        <url>https://jitpack.io</url>
	</repository>
```

```xml
	<dependency>
	    <groupId>com.github.InvisRaidinq.RocketAPI</groupId>
	    <artifactId>API</artifactId>
	    <version>64d04885bf</version>
        <scope>compile</scope>
	</dependency>
```

Alternatively, you can install it to your local repository using the following commands:

```bash
  git clone https://github.com/InvisRaidinq/RocketAPI.git
  cd RocketAPI
  mvn clean install
```
    
You can either use one of the JAR releases found in the releases section, or you can shade the API into your plugin.
## Features

- A pre-instantiated scheduler so you don't have to inject everywhere
- An easy-to-use and functional command handler
- Multiple different config handlers
- Holograms
- Useful serializables
- Easy itembuilders and string formatters

  
## Getting Started with the API

```java
public class MyPlugin extends RocketPlugin {

    @Override
    public void onServerStart() {
        this.getScheduler().runSyncRepeating(() -> Bukkit.broadcastMessage("This is a scheduler task"), 20L);
        //Plugin startup logic here
    }

    @Override
    public void onServerStop() {
        //Plugin shutdown logic here
    }

}
```

## Connecting to a database

```java
    public void connectToMongo() {
        MongoDatabase MongoDatabase = new RocketMongo(
            "databaseName",
            "127.0.0.1",
            27017,
            false,
            "username",
            "password",
            "admin"
        ).connect();

        MongoCollection<Document> someMongoCollection = MongoDatabase.getCollection("someCollection");
    }
```

  
## Contributing

Contributions are always welcome! Feel free to make a pull request, detailing the changes that you made and why you made them. Please ensure that all code committed is your own or you have permission to use it.

  
## FAQ

#### Can I use this in my plugins?

Yes! RocketAPI has an MIT license, so you can use it and re-sell it in any plugins as you wish.

#### Why should I use this?

The purpose of this API was to remove boilerplate code from all plugins. We compiled multiple useful utilities to make plugin creation a breeze, rather than having to copy and paste utilities each time a new plugin is made.

  
