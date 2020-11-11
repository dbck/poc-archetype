# Usage

```
mvn install
```

# Deploy

```
mvn deploy
```

or

```
mvn deploy -Pgithub
```

or 

```
mvn deploy -Dregistry=https://maven.pkg.github.com/dbck -Dtoken=GH_TOKEN
```

## Debug profiles

```
mvn help:active-profiles
```

# Maintenance

```
mvn versions:display-dependency-updates
mvn versions:display-plugin-updates
```