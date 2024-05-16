#!/usr/bin/bash -ex

sudo apt update

sudo apt install default-jdk
sudo apt install maven

mvn compile
mvn -DskipTests=true package

java -cp zetasql-toolkit-examples/target/zetasql-toolkit-examples-0.5.1.jar com.google.zetasql.toolkit.examples.AnalyzeWithoutCatalog
