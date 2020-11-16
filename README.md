# Generate project from archetype

```
export ARCHETYPE_VERSION="0.0.2" # CHOOSE ARCHTETYPE VERSION
export GIT_USER_NAME="" # INSERT GIT USER NAME HERE IF NOT ALREADY GLOBAL SET
export GIT_USER_EMAIL="" # INSERT GIT USER EMAIL HERE IF NOT ALREADY GLOBAL SET
export GROUP_ID="de.dbck.poc" # SET GROUP ID OF GENERATED PROJECT
export ARTIFACT_ID="poc-artifactid" # SET ARCHITYPE ID OF GENERATED PROJECT
mvn archetype:generate -DinteractiveMode=false \
                       -DarchetypeGroupId=de.dbck.poc \
                       -DarchetypeArtifactId=poc-archetype \
                       -DarchetypeVersion=${ARCHETYPE_VERSION} \
                       -DgroupdId=${GROUP_ID} \
                       -DartifactId=${ARTIFACT_ID} \
                       -Dpackage=${GROUP_ID}.$(sed -e's/-//g' <<< ${ARTIFACT_ID})
cd ${ARTIFACT_ID}
mv .gitignore_ .gitignore
git init
[ ! -z ${GIT_USER_NAME} ] && git config user.name "${GIT_USER_NAME}"
[ ! -z ${GIT_USER_EMAIL} ] && git config user.email "${GIT_USER_EMAIL}"
git config push.ff only
git config pull.ff only
git config merge.ff false
git checkout -b main
git add .
git commit -m "Initial"
mvn compile
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