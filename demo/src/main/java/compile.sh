#!/usr/bin/env bash
if [ -d classes ]; then
    rm -rf classes;
fi

mkdir classes

javac -cp /usr/lib/jvm/jdk/lib/tools.jar org/pan/lombok/annotation/Getter* -d classes/
javac -cp classes -d classes -processor org.pan.lombok.annotation.GetterProcessor org/pan/lombok/annotation/AppTest.java
javap -p classes/org/pan/lombok/annotation/AppTest.class
java -cp classes org.pan.lombok.annotation.AppTest
