open module afterburnerfx {
	uses com.mycodefu.afterburner.injection.PresenterFactory;

	requires java.desktop;
	requires javafx.controls;
	requires javafx.fxml;
	requires javax.inject;

	exports com.mycodefu;
}