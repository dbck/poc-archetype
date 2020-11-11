# Generate project from archetype

```
export ARCHETYPE_VERSION="0.0.1-SNAPSHOT"
export GROUP_ID="de.dbck.poc"
export ARTIFACT_ID="poc-artifactid"
mvn archetype:generate -DinteractiveMode=false \
                       -DarchetypeGroupId=de.dbck.poc \
                       -DarchetypeArtifactId=poc-archetype \
                       -DarchetypeVersion=${ARCHETYPE_VERSION} \
                       -DgroupdId=${GROUP_ID} \
                       -DartifactId=${ARTIFACT_ID} \
                       -Dpackage=${GROUP_ID}.${ARTIFACT_ID/-/}
cd ${ARTIFACT_ID}
mvn compile
git init
git checkout -b main
git add .
git commit -m "Initial"
git remote add origin https://github.com/dbck/${ARTIFACT_ID}.git
git push --set-upstream origin main
```

# Usage

```
mvn clean install archetype:update-local-catalog
mvn archetype:crawl
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