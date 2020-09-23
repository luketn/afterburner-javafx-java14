# To run this you'll need to:
# - be using Java 14
# - have run maven package
# - be in the target/release-directory

cd target/release-directory

COUNTRY=AU
LANGUAGE=en
# (also supports FR-fr)

java  -Duser.country="${COUNTRY}" -Duser.language=${LANGUAGE} \
      --enable-preview \
      --add-modules javafx.controls,javafx.fxml,org.controlsfx.controls \
      --module-path ./lib \
      --add-exports javafx.base/com.sun.javafx.event=org.controlsfx.controls \
      -jar javafx-15-java-14-template-1.jar

