mvn -q package
mvn -q install:install-file -Dfile=target/karans-s14-sample-db-project-dal-0.0.1-SNAPSHOT.jar -DgroupId=co.karans -DartifactId=sampledbproject.dal -Dversion=0.0.1 -Dpackaging=jar
