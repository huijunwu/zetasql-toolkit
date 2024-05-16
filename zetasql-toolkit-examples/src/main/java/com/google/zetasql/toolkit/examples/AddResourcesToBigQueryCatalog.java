/*
 * Copyright 2023 Google LLC All Rights Reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.zetasql.toolkit.examples;

import com.google.common.collect.ImmutableList;
import com.google.zetasql.toolkit.catalog.bigquery.BigQueryCatalog;

public class AddResourcesToBigQueryCatalog {

  public static void main(String[] args) {
    BigQueryCatalog catalog = BigQueryCatalog.usingBigQueryAPI("bigdata-platform-data-us-dev");

    // Add a table or a set of tables by name
    // Views are considered tables as well, so they can be added this way to the catalog
    catalog.addTable("bigdata-platform-data-us-dev.huijun_us_test.test_zsql");
    System.out.println(catalog.getZetaSQLCatalog().toString());
    System.out.println("---------------------------");

    catalog.addTables(
        ImmutableList.of(
            "bigdata-platform-data-us-dev.huijun_us_test.test_zsql",
            "bigdata-platform-data-us-dev.huijun_us_test.normal_filtered"));
            System.out.println(catalog.getZetaSQLCatalog().toString());
    System.out.println("---------------------------");

    // Add all tables in a dataset or project
    // Views are considered tables as well, so they will be added to the catalog too
    catalog.addAllTablesInDataset("bigdata-platform-data-us-dev", "huijun_us_test");
    System.out.println(catalog.getZetaSQLCatalog().toString());
    System.out.println("---------------------------");
    catalog.addAllTablesInProject("bigdata-platform-data-us-dev");
    System.out.println(catalog.getZetaSQLCatalog().toString());
    System.out.println("---------------------------");

    // Add a function or a set of functions by name
    // For the time being, functions must have an explicit return type (i.e. creating with
    // a RETURNS clause); otherwise adding them will fail.
    // catalog.addFunction("project.dataset.function");
    // catalog.addFunctions(
    //     ImmutableList.of("project.dataset.function2", "project.dataset.function3"));

    // Add all functions in a dataset or project
    // For the time being, functions without an explicit return type are silently ignored
    // catalog.addAllFunctionsInDataset("projectId", "datasetName");
    // catalog.addAllFunctionsInProject("projectId");

    // Add a TVF or a set of TVFs by name
    // For the time being, TVFs must have an explicit return type (i.e. creating with
    // a RETURNS clause); otherwise adding them will fail.
    // catalog.addTVF("project.dataset.tvf");
    // catalog.addTVFs(ImmutableList.of("project.dataset.tvf2", "project.dataset.tvf3"));

    // Add all TVFs in a dataset or project
    // For the time being, TVFs without an explicit return type are silently ignored
    // catalog.addAllTVFsInDataset("projectId", "datasetName");
    // catalog.addAllTVFsInProject("projectId");

    // Add a procedure or a set of procedures by name
    // catalog.addProcedure("project.dataset.procedure");
    // catalog.addProcedures(
    //     ImmutableList.of("project.dataset.procedure1", "project.dataset.procedure2"));

    // Add all procedures in a dataset or project
    // catalog.addAllProceduresInDataset("projectId", "datasetName");
    // catalog.addAllProceduresInProject("projectId");
  }
}
