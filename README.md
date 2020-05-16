# convexHull
create the [convex hull](https://en.wikipedia.org/wiki/Convex_hull) from a set of 2 dimensional points

## Features

Implementation of two [convex hull algorithms](https://en.wikipedia.org/wiki/Convex_hull_algorithms):
* [Jarvis march / gift wrapping](https://en.wikipedia.org/wiki/Gift_wrapping_algorithm)
* [Graham scan](https://en.wikipedia.org/wiki/Graham_scan)
 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

* Java 8 JDK or later 
* [Maven](https://maven.apache.org/) - Dependency Management

### Installing

Add this dependency to your project Maven config:

```
<dependency>
    <groupId>de.baule</groupId>
    <artifactId>convexHull</artifactId>
    <version>0.0.2</version>
</dependency>
```

## Running the tests

```
mvn test
```

## Deployment

```
mvn clean deploy
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [git](https://git-scm.com/) for versioning. For the versions available, see the [tags on this repository](https://github.com/baulea/convexHull/tags). 

## Authors

* **Alois Baule**

See also the list of [contributors](https://github.com/baulea/convexHull/contributors) who participated in this project.

## License

This project is licensed under the Apache-2.0 License - see the [LICENSE](LICENSE) file for details

