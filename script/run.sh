#!/bin/sh

COUNTRY=AU
LANGUAGE=en
# (also supports FR-fr)

java  -Duser.country="${COUNTRY}" -Duser.language=${LANGUAGE} \
      --enable-preview \
      --add-modules javafx.controls,javafx.fxml \
      --module-path ./lib \
      -jar javafx-template.jar

