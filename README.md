# JavaFX Template App!

[![CircleCI](https://circleci.com/gh/luketn/javafx-template.svg?style=svg)](https://circleci.com/gh/luketn/javafx-template)

A template for a multi-platform JavaFX app, which builds for all three major desktop platforms:
- Windows (MSI)
- Mac (PKG)
- Linux (DEB)

## Get Started!

1. Update the details for your project in the POM:

```
<groupId>com.mycodefu</groupId>
<artifactId>javafx-template</artifactId>
<name>javafx-template</name>
<url>https://mycodefu.com</url>
```
and
```
<main.class>com.mycodefu.App</main.class>
<jpackage-modules>javafx.controls,javafx.fxml</jpackage-modules>
<jpackage-copyright>2020 Luke Thompson</jpackage-copyright>
<jpackage-vendor>Luke Thompson</jpackage-vendor>
```

2. Go to CircleCI, Setup the project and add the following Environment Variable:
```
GITHUB_TOKEN=xxx4333
```

3. Publish your first version. Go to a terminal in the ./scripts folder and run:

```
./release 1.0.0
```

You should now have a new release in GitHub with a Linux, Windows and Windows installer ready to go.


##### The injector used in the project is derived from afterburner.fx - an excellent, but now unmaintained, library:
See: [https://github.com/AdamBien/afterburner.fx](https://github.com/AdamBien/afterburner.fx)

