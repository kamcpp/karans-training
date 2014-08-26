mvn -q package
mvn -q install:install-file -Dfile=target/karans-s14-sample-db-project-biz-0.0.1-SNAPSHOT.jar -DgroupId=co.karans -DartifactId=sampledbproject.biz -Dversion=0.0.1 -Dpackaging=jar
