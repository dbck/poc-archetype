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
git init
git checkout -b main
git add .
git commit -m "Initial"
mvn compile
git remote add origin https://github.com/dbck/${ARTIFACT_ID}.git
git push --set-upstream origin main
```

# Local development environment

## Compile / Install

```
mvn clean install archetype:update-local-catalog
mvn archetype:crawl
```

## Quality check

```
mvn -Dsonar.login=${SONAR_TOKEN} -Pquality verify
```

# Deployment

## Local

```
mvn verify
```

## Snapshot

```
git checkout main
git push
```

## Release

```
git checkout release
git merge main
git push
git checkout main
# After release is finished
git pull
```

# Debug profiles

```
mvn help:active-profiles
```

## Disable profiles

```
mvn help:active-profiles -P-github,-ossrh
```

# Maintenance

```
mvn versions:display-dependency-updates
mvn versions:display-plugin-updates
```