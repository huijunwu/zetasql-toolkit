#!/usr/bin/bash -ex

sudo apt update && sudo apt install -y default-jdk && sudo apt install -y maven

git clone https://github.com/huijunwu/zetasql-toolkit.git
mvn compile && mvn -DskipTests=true package

java -cp zetasql-toolkit-examples/target/zetasql-toolkit-examples-0.5.1-jar-with-dependencies.jar com.google.zetasql.toolkit.examples.AnalyzeWithoutCatalog

java -cp zetasql-toolkit-examples/target/zetasql-toolkit-examples-0.5.1-jar-with-dependencies.jar com.google.zetasql.toolkit.examples.AddResourcesToBigQueryCatalog
java -cp zetasql-toolkit-examples/target/zetasql-toolkit-examples-0.5.1-jar-with-dependencies.jar com.google.zetasql.toolkit.examples.AnalyzeBigQuery
java -cp zetasql-toolkit-examples/target/zetasql-toolkit-examples-0.5.1-jar-with-dependencies.jar com.google.zetasql.toolkit.examples.AnalyzingCreateStatements

java -cp zetasql-toolkit-examples/target/zetasql-toolkit-examples-0.5.1-jar-with-dependencies.jar com.google.zetasql.toolkit.examples.ExtractColumnLevelLineage

java -cp zetasql-toolkit-examples/target/zetasql-toolkit-examples-0.5.1-jar-with-dependencies.jar com.google.zetasql.toolkit.examples.LoadTablesUsedInQuery
